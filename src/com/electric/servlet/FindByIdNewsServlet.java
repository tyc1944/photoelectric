package com.electric.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.service.NewsService;
import com.electric.service.NewsTypeService;
import com.electric.service.impl.NewsServiceimpl;
import com.electric.service.impl.NewsTypeServiceimpl;

/**
 * Servlet implementation class FindByIdNewsServlet
 */
@WebServlet("/FindByIdNewsServlet")
public class FindByIdNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByIdNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int newsId=Integer.parseInt(request.getParameter("newsId"));
		NewsService newsService=new NewsServiceimpl();
		NewsTypeService newsTypeService=new NewsTypeServiceimpl();
		request.setAttribute("newsEntity", newsService.findNewsEntityById(newsId));
		request.setAttribute("news", newsService.findById(newsId));//传递新闻对象到详情页
		request.setAttribute("newsTypeList", newsTypeService.findAll());//传递新闻类型列表到页面中
		request.getRequestDispatcher("newsdetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
