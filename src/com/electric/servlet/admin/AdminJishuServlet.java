package com.electric.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.Jishu;
import com.electric.entity.Page;
import com.electric.service.JishuService;
import com.electric.service.impl.JishuServiceimpl;



/**
 * Servlet implementation class AdminNewsServlet
 */
@WebServlet("/AdminJishuServlet")
public class AdminJishuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminJishuServlet() {
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
		JishuService jishuService=new JishuServiceimpl();
		String flag=request.getParameter("flag");
		if(flag.equals("list")) {
			Page myPage=new Page();
			myPage.setPageSize(10);
			String pageNo=request.getParameter("pageNo");
			if(pageNo!=null) {
				myPage.setPageNo(Integer.parseInt(pageNo));
			}
			myPage.setRowCount(jishuService.findAll().size());//设置记录数
			request.setAttribute("jishuList", jishuService.findPageList(myPage));
			request.setAttribute("myPage", myPage);
			request.getRequestDispatcher("admin/jishu/list.jsp").forward(request, response);
		}else if(flag.equals("toAdd")) {
			request.getRequestDispatcher("admin/jishu/add.jsp").forward(request, response);
		}else if(flag.equals("add")) {
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			Jishu jisu=new Jishu(title, content);
			if(jishuService.savejishu(jisu)) {
				out.print("ok");
			}else {
				out.print("error");
			}
			
		}else if(flag.equals("delete")) {
			int proId=Integer.parseInt(request.getParameter("proId"));
			if(jishuService.deletejishu(proId)) {
				out.print("ok");
			}else {
				out.print("error");
			}
		}else if(flag.equals("toUpdate")) {
			int proId=Integer.parseInt(request.getParameter("proId"));
			request.setAttribute("jishu", jishuService.findById(proId));
			request.getRequestDispatcher("admin/jishu/update.jsp").forward(request, response);
		}else if(flag.equals("update")) {
			int proId=Integer.parseInt(request.getParameter("proId"));
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			Jishu jishu=new Jishu(proId, title, content);
			if(jishuService.updatejishu(jishu)) {
				out.print("ok");
			}else {
				out.print("error");
			}
			
		}else if(flag.equals("Manydelete")) {
			String proIds=request.getParameter("proIds");//1,3,5
			if(jishuService.deleteMany(proIds)) {
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
