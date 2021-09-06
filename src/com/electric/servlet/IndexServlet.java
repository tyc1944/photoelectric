package com.electric.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.About;
import com.electric.entity.News;
import com.electric.entity.NewsType;
import com.electric.entity.Product;
import com.electric.service.NewsService;
import com.electric.service.NewsTypeService;
import com.electric.service.ProductService;
import com.electric.service.impl.AboutServiceimpl;
import com.electric.service.impl.ContactServiceimpl;
import com.electric.service.impl.NewsServiceimpl;
import com.electric.service.impl.NewsTypeServiceimpl;
import com.electric.service.impl.ProductServiceimpl;



/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		NewsTypeService newstypeService=new NewsTypeServiceimpl();
		List<NewsType> newsList1=newstypeService.findAll();
		newsList1=newsList1.size()>=6?newsList1.subList(0, 6):newsList1;//只要前6条新闻
		request.setAttribute("newsList1", newsList1);
		NewsService newsService=new NewsServiceimpl();
		List<News> newsList=newsService.findAll();
		newsList=newsList.size()>=6?newsList.subList(0, 6):newsList;//只要前6条新闻
		request.setAttribute("newsList", newsList);
		
		request.setAttribute("contact", new ContactServiceimpl().findAll().get(0));
		
		ProductService productService=new ProductServiceimpl();
		List<Product> productList=productService.findAll();
		productList=productList.size()>3?productList.subList(0, 3):productList;
		request.setAttribute("productList", productList);

		About about=new AboutServiceimpl().findAll().get(0);
		String contentNoHTML=about.getContent().replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
		//System.out.println(contentNoHTML+"==============");
		//System.out.println(contentNoHTML+"==============");
		request.setAttribute("aboutContent", contentNoHTML.length()>200?contentNoHTML.substring(0, 200):contentNoHTML);
		
		request.getSession().setAttribute("contact", new ContactServiceimpl().findAll().get(0));//把联系我们放入到会话session中
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
