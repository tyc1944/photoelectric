package com.electric.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.User;
import com.electric.entity.Page;
import com.electric.entity.StringUtil;
import com.electric.service.UserService;
import com.electric.service.impl.UserServiceimpl;

/**
 * Servlet implementation class AdminmanagerServlet
 */
@WebServlet("/AdminManagerServlet")
public class AdminManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminManagerServlet() {
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
		UserService userService=new UserServiceimpl();
		String flag=request.getParameter("flag");
		if(flag.equals("list")) {
			request.setAttribute("user", userService.findById(1));
			request.getRequestDispatcher("admin/manager/list.jsp").forward(request, response);
		}else if(flag.equals("toUpdate")) {
			int uid=Integer.parseInt(request.getParameter("uid"));
			request.setAttribute("user", userService.findById(uid));
			request.getRequestDispatcher("admin/manager/update.jsp").forward(request, response);
		}else if(flag.equals("update")) {
			int uid=Integer.parseInt(request.getParameter("uid"));
			String uname=request.getParameter("uname");
			String upass=StringUtil.getMD5(request.getParameter("upass"));
			User user=new User(uid, uname, upass);
			if(userService.updateUser(user)) {
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
