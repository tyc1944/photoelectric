package com.electric.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.Liuyan;
import com.electric.entity.Page;
import com.electric.service.LiuyanService;
import com.electric.service.impl.LiuyanServiceimpl;



/**
 * Servlet implementation class AdminNewsServlet
 */
@WebServlet("/AdminLiuyanServlet")
public class AdminLiuyanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLiuyanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out=response.getWriter();
		LiuyanService liuyanService=new LiuyanServiceimpl();
		String flag=request.getParameter("flag");
		if(flag.equals("list")) {
			Page myPage=new Page();
			myPage.setPageSize(10);
			String pageNo=request.getParameter("pageNo");
			if(pageNo!=null) {
				myPage.setPageNo(Integer.parseInt(pageNo));
			}
			myPage.setRowCount(liuyanService.findAll().size());//设置记录数
			request.setAttribute("liuyanList", liuyanService.findPageList(myPage));
			request.setAttribute("myPage", myPage);
			request.getRequestDispatcher("admin/liuyan/list.jsp").forward(request, response);
		}else if(flag.equals("toAdd")) {
			request.getRequestDispatcher("admin/liuyan/add.jsp").forward(request, response);
		}else if(flag.equals("add")) {
			String username=request.getParameter("username");
			String company=request.getParameter("company");
			int phone=Integer.parseInt(request.getParameter("phone"));
			String email=request.getParameter("email");
			String homepage=request.getParameter("homepage");			
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			Liuyan liuyan=new Liuyan(username, company, phone, email, homepage, title, content);
			if(liuyanService.saveLiuyan(liuyan)) {
				out.print("ok");
			}else {
				out.print("error");
			}
			
		}else if(flag.equals("delete")) {
			int id=Integer.parseInt(request.getParameter("id"));
			if(liuyanService.deleteLiuyan(id)) {
				out.print("ok");
			}else {
				out.print("error");
			}
		}else if(flag.equals("toUpdate")) {
			int id=Integer.parseInt(request.getParameter("id"));
			request.setAttribute("liuyan", liuyanService.findById(id));
			request.getRequestDispatcher("admin/liuyan/update.jsp").forward(request, response);
		}else if(flag.equals("update")) {
			int id=Integer.parseInt(request.getParameter("id"));
			String username=request.getParameter("username");
			String company=request.getParameter("company");
			int phone=Integer.parseInt(request.getParameter("phone"));
			String email=request.getParameter("email");
			String homepage=request.getParameter("homepage");			
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			Liuyan liuyan=new Liuyan(id, username, company, phone, email, homepage, title, content);
			if(liuyanService.updateLiuyan(liuyan)) {
				out.print("ok");
			}else {
				out.print("error");
			}
			
		}else if(flag.equals("Manydelete")) {
			String Ids=request.getParameter("Ids");//1,3,5
			if(liuyanService.deleteMany(Ids)) {
				out.print("ok");
			}else {
				out.print("error");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
