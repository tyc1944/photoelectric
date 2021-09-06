package com.electric.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.Page;
import com.electric.service.NewsService;
import com.electric.service.NewsTypeService;
import com.electric.service.impl.NewsServiceimpl;
import com.electric.service.impl.NewsTypeServiceimpl;

/**
 * Servlet implementation class FindPageListNewsServlet
 */
@WebServlet("/FindPageListNewsServlet")
public class FindPageListNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPageListNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		NewsService newsService=new NewsServiceimpl();
		NewsTypeService newsTypeService=new NewsTypeServiceimpl();
		Page myPage=new Page();
		String newPageNoStr=request.getParameter("pageNo");
		if(newPageNoStr!=null) {//如果传递了页码
			myPage.setPageNo(Integer.parseInt(newPageNoStr));
		}
		myPage.setRowCount(newsService.findAll().size());//设置记录数   注意此句位置
		request.setAttribute("newsList", newsService.findPageList(myPage,0));//传递所有新闻列表到页面中
		request.setAttribute("newsTypeList", newsTypeService.findAll());//传递新闻类型列表到页面中
		request.setAttribute("myPage", myPage);//分页对象传递给目标页面
		request.getRequestDispatcher("newslist.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
