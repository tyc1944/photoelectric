package com.electric.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.News;
import com.electric.entity.Page;
import com.electric.service.NewsService;
import com.electric.service.NewsTypeService;
import com.electric.service.impl.NewsServiceimpl;
import com.electric.service.impl.NewsTypeServiceimpl;



/**
 * Servlet implementation class AdminNewsServlet
 */
@WebServlet("/AdminNewsServlet")
public class AdminNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNewsServlet() {
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
		NewsService newsService=new NewsServiceimpl();
		NewsTypeService newsTypeService=new NewsTypeServiceimpl();
		String flag=request.getParameter("flag");
		if(flag.equals("list")) {
			Page myPage=new Page();
			myPage.setPageSize(3);
			String pageNo=request.getParameter("pageNo");
			if(pageNo!=null) {
				myPage.setPageNo(Integer.parseInt(pageNo));
			}
			myPage.setRowCount(newsService.findAll().size());//设置记录数
			request.setAttribute("newsList", newsService.findPageList(myPage, 0));
			request.setAttribute("myPage", myPage);
			request.getRequestDispatcher("admin/news/list.jsp").forward(request, response);
		}else if(flag.equals("toAdd")) {
			request.setAttribute("newsTypeList", newsTypeService.findAll());//准备新闻类型集合给添加页面
			request.getRequestDispatcher("admin/news/add.jsp").forward(request, response);
		}else if(flag.equals("add")) {
			String title=request.getParameter("title");
			String author=request.getParameter("author");
			int clicks=Integer.parseInt(request.getParameter("clicks"));
			int typeId=Integer.parseInt(request.getParameter("typeId"));
			String description=request.getParameter("description");
			News news=new News( title, description, clicks, author,new Timestamp(System.currentTimeMillis()), typeId);
			if(newsService.saveNews(news)) {
				out.print("ok");
			}else {
				out.print("error");
			}
			
		}else if(flag.equals("delete")) {
			int newsId=Integer.parseInt(request.getParameter("newsId"));
			if(newsService.deleteNews(newsId)) {
				out.print("ok");
			}else {
				out.print("error");
			}
		}else if(flag.equals("toUpdate")) {
			int newsId=Integer.parseInt(request.getParameter("newsId"));
			request.setAttribute("news", newsService.findById(newsId));
			request.setAttribute("newsTypeList", newsTypeService.findAll());//准备新闻类型集合给添加页面
			request.getRequestDispatcher("admin/news/update.jsp").forward(request, response);
		}else if(flag.equals("update")) {
			int newsId=Integer.parseInt(request.getParameter("newsId"));
			String title=request.getParameter("title");
			String author=request.getParameter("author");
			int clicks=Integer.parseInt(request.getParameter("clicks"));
			int typeId=Integer.parseInt(request.getParameter("typeId"));
			String description=request.getParameter("description");
			Timestamp postTime=Timestamp.valueOf(request.getParameter("postTime"));
			News news=new News(newsId, title, description, clicks, author, postTime, typeId);
			if(newsService.updateNews(news)) {
				out.print("ok");
			}else {
				out.print("error");
			}
			
		}else if(flag.equals("Manydelete")) {
			String newsIds=request.getParameter("newsIds");//1,3,5
			if(newsService.deleteMany(newsIds)) {
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
