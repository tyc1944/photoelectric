package com.electric.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.Contact;
import com.electric.entity.Page;
import com.electric.service.ContactService;
import com.electric.service.impl.ContactServiceimpl;



/**
 * Servlet implementation class AdminNewsServlet
 */
@WebServlet("/AdminContactServlet")
public class AdminContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminContactServlet() {
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
		ContactService contactService=new ContactServiceimpl();
		String flag=request.getParameter("flag");
		if(flag.equals("list")) {
			Page myPage=new Page();
			myPage.setPageSize(10);
			String pageNo=request.getParameter("pageNo");
			if(pageNo!=null) {
				myPage.setPageNo(Integer.parseInt(pageNo));
			}
			myPage.setRowCount(contactService.findAll().size());//设置记录数
			request.setAttribute("contactList", contactService.findPageList(myPage));
			request.setAttribute("myPage", myPage);
			request.getRequestDispatcher("admin/contact/list.jsp").forward(request, response);
//		}else if(flag.equals("toAdd")) {
//			request.getRequestDispatcher("admin/contact/add.jsp").forward(request, response);
//		}else if(flag.equals("add")) {
//			String title=request.getParameter("title");
//			String pic=request.getParameter("pic");
//			int typeId=Integer.parseInt(request.getParameter("typeId"));
//			String content=request.getParameter("content");
//			About jisu=new About(title, content, pic, typeId);
//			if(contactService.savecontact(jisu)) {
//				out.print("ok");
//			}else {
//				out.print("error");
//			}
			
		}else if(flag.equals("delete")) {
			int proId=Integer.parseInt(request.getParameter("proId"));
			if(contactService.deletecontact(proId)) {
				out.print("ok");
			}else {
				out.print("error");
			}
		}else if(flag.equals("toUpdate")) {
			//int proId=Integer.parseInt(request.getParameter("proId"));
			Contact contact=contactService.findAll().get(0);
			request.setAttribute("contact", contact);
			request.getRequestDispatcher("admin/contact/update.jsp").forward(request, response);
		}else if(flag.equals("update")) { 
			int proId=Integer.parseInt(request.getParameter("proId"));
			String gsmc=request.getParameter("gsmc");
			String gsdz=request.getParameter("gsdz");
			String youbian=request.getParameter("youbian");
			String kfdh=request.getParameter("kfdh");
			String chuanzhen=request.getParameter("chuanzhen");
			String shouji=request.getParameter("shouji");
			String lianxiren=request.getParameter("lianxiren");
			String msn=request.getParameter("msn");
			String qq=request.getParameter("qq");
			String swyx=request.getParameter("swyx");
			String kfyx=request.getParameter("kfyx");
			String gswz=request.getParameter("gswz");
			Contact contact=new Contact(proId, gsmc, gsdz, youbian, kfdh, chuanzhen, shouji, lianxiren, msn, qq, swyx, kfyx, gswz);
			if(contactService.updatecontact(contact)) {
				out.print("ok");
			}else {
				out.print("error");
			}
			
		}else if(flag.equals("Manydelete")) {
			String proIds=request.getParameter("proIds");//1,3,5
			if(contactService.deleteMany(proIds)) {
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
