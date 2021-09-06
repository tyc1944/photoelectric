package com.electric.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.About;
import com.electric.entity.Page;
import com.electric.service.AboutService;
import com.electric.service.impl.AboutServiceimpl;



/**
 * Servlet implementation class AdminNewsServlet
 */
@WebServlet("/AdminAboutServlet")
public class AdminAboutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAboutServlet() {
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
		AboutService aboutService=new AboutServiceimpl();
		String flag=request.getParameter("flag");
		if(flag.equals("list")) {
			Page myPage=new Page();
			myPage.setPageSize(10);
			String pageNo=request.getParameter("pageNo");
			if(pageNo!=null) {
				myPage.setPageNo(Integer.parseInt(pageNo));
			}
			myPage.setRowCount(aboutService.findAll().size());//设置记录数
			request.setAttribute("aboutList", aboutService.findPageList(myPage));
			request.setAttribute("myPage", myPage);
			request.getRequestDispatcher("admin/about/list.jsp").forward(request, response);
		}else if(flag.equals("toAdd")) {
			request.getRequestDispatcher("admin/about/add.jsp").forward(request, response);
		}else if(flag.equals("add")) {
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			About jisu=new About(title, content);
			if(aboutService.saveabout(jisu)) {
				out.print("ok");
			}else {
				out.print("error");
			}
			
		}else if(flag.equals("delete")) {
			int proId=Integer.parseInt(request.getParameter("proId"));
			if(aboutService.deleteabout(proId)) {
				out.print("ok");
			}else {
				out.print("error");
			}
		}else if(flag.equals("toUpdate")) {
			//int proId=Integer.parseInt(request.getParameter("proId"));
			About about=aboutService.findAll().get(0);
			request.setAttribute("about", about);
			request.getRequestDispatcher("admin/about/update.jsp").forward(request, response);
		}else if(flag.equals("update")) {
			int proId=Integer.parseInt(request.getParameter("proId"));
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			About about=new About(proId, title, content);
			if(aboutService.updateabout(about)) {
				out.print("ok");
			}else {
				out.print("error");
			}
			
		}else if(flag.equals("Manydelete")) {
			String proIds=request.getParameter("proIds");//1,3,5
			if(aboutService.deleteMany(proIds)) {
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
