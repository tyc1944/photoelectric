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
 * Servlet implementation class FindPageListByTypeIdNewsServlet
 */
@WebServlet("/FindPageListByTypeIdNewsServlet")
public class FindPageListByTypeIdNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPageListByTypeIdNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int typeId=Integer.parseInt(request.getParameter("typeId"));
		NewsService newsService=new NewsServiceimpl();
		NewsTypeService newsTypeService=new NewsTypeServiceimpl();
		Page myPage=new Page();
		String newPageNoStr=request.getParameter("pageNo");
		if(newPageNoStr!=null) {//如果传递了页码
			myPage.setPageNo(Integer.parseInt(newPageNoStr));
		}
		myPage.setRowCount(newsService.findListByTypeId(typeId).size());//某类型下新闻的记录数作为分页对象的总记录数
		request.setAttribute("newsList", newsService.findPageList(myPage,typeId));
		request.setAttribute("newsTypeList", newsTypeService.findAll());//传递新闻类型列表到页面中
		request.setAttribute("myPage", myPage);//传递分页对象到页面
		
		request.setAttribute("newsType", newsTypeService.findById(typeId));//多传递一个新闻类型对象到页面//////
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
