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
 * Servlet implementation class AdminrServlet
 */
@WebServlet("/AdminAdminServlet")
public class AdminAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAdminServlet() {
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
			Page myPage=new Page();
			myPage.setPageSize(5);
			String pageNo=request.getParameter("pageNo");
			if(pageNo!=null) {
				myPage.setPageNo(Integer.parseInt(pageNo));
			}
			myPage.setRowCount(userService.findAll().size());//设置记录数
			request.setAttribute("userList", userService.findPageList(myPage));
			request.setAttribute("myPage", myPage);
			request.getRequestDispatcher("admin/admin/list.jsp").forward(request, response);
		}else if(flag.equals("toAdd")) {
			request.getRequestDispatcher("admin/admin/add.jsp").forward(request, response);
		}else if(flag.equals("add")) {
			int uid=Integer.parseInt(request.getParameter("uid"));
			String uname=request.getParameter("uname");
			String upass=request.getParameter("upass");
			User user=new User(uid, uname, upass);
			if(userService.saveUser(user)) {
				out.print("ok");
			}else {
				out.print("error");
			}
			
		}else if(flag.equals("delete")) {
			int uid=Integer.parseInt(request.getParameter("uid"));
			if(userService.deleteUser(uid)) {
				out.print("ok");
			}else {
				out.print("error");
			}
		}else if(flag.equals("toUpdate")) {
			int uid=Integer.parseInt(request.getParameter("uid"));
			request.setAttribute("user", userService.findById(uid));
			request.getRequestDispatcher("admin/admin/update.jsp").forward(request, response);
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
			
		}else if(flag.equals("Manydelete")) {
			String uids=request.getParameter("uids");//1,3,5
			if(userService.deleteMany(uids)) {
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
