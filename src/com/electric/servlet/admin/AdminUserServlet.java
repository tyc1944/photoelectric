package com.electric.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.StringUtil;
import com.electric.entity.User;
import com.electric.service.UserService;
import com.electric.service.impl.UserServiceimpl;

/**
 * Servlet implementation class AdminUserServlet
 */
@WebServlet("/AdminUserServlet")
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		UserService userService = new UserServiceimpl();
		String flag = request.getParameter("flag");
		if (flag.equals("login")) {

			String userName = request.getParameter("username");
			String password = request.getParameter("password");

			User user = userService.checkUser(userName, StringUtil.getMD5(password));
			if (user != null) {
				request.getSession().setAttribute("LOGIN_USER", user);
				out.print("ok");
			} else {
				out.print("error");
			}

		} else if (flag.equals("updatePass")) {
			String newpass = StringUtil.getMD5(request.getParameter("newpass"));
			String oldpass = request.getParameter("oldpass");
			//String oldRightPass = request.getParameter("oldRightPass");
			//System.out.println(oldRightPass + "~~~~~~~~~~~~~~~~");
			//System.out.println(oldpass + "~~~~~~~~~~~~~~~~");
			User user = (User) request.getSession().getAttribute("LOGIN_USER");
			if(!user.getUpass().equals(StringUtil.getMD5(oldpass))) {
				out.print("oldpassError");
			}else
			{
				user.setUpass(newpass);
				if (userService.updateUser(user)) {
					out.print("ok");
				} else {
					out.print("error");
				}
			}
			
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
