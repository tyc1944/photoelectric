package com.electric.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.Liuyan;
import com.electric.service.impl.LiuyanServiceimpl;

/**
 * Servlet implementation class LiuyanServlet
 */
@WebServlet("/LiuyanServlet")
public class LiuyanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LiuyanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	String verifycode=request.getParameter("verifycode");//获取填写的验证码
	String rightCode=request.getSession().getAttribute("checkcode").toString();
	if(!verifycode.equals(rightCode)) {
		request.setAttribute("msg", "验证码错误");
	}else {
		String username=request.getParameter("username");//sno是表单中(或者超链接中)传递过来的参数名
		String company=request.getParameter("company");
		int phone=Integer.parseInt(request.getParameter("phone"));
		String email=request.getParameter("email");
		String homepage=request.getParameter("homepage");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
			Liuyan liuyan=new Liuyan(username,company,phone,email,homepage,title,content);
			if(new LiuyanServiceimpl().saveLiuyan(liuyan)) {
				request.setAttribute("msg", "留言成功！");
			}else {
				request.setAttribute("msg", "留言失败！");
			}
	}
	request.getRequestDispatcher("liuyan.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
