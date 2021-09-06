package com.electric.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.Page;
import com.electric.service.ProductService;
import com.electric.service.ProductTypeService;
import com.electric.service.impl.ProductServiceimpl;
import com.electric.service.impl.ProductTypeServiceimpl;


/**
 * Servlet implementation class ProductServlet_findAll
 */
@WebServlet("/Productpage")
public class Productpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productpage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ProductService productService=new ProductServiceimpl();
		ProductTypeService productTypeService=new ProductTypeServiceimpl();
		Page myPage=new Page();
		String newPageNoStr=request.getParameter("pageNo");
		if(newPageNoStr!=null) {//如果传递了页码
			myPage.setPageNo(Integer.parseInt(newPageNoStr));
		}
		myPage.setRowCount(productService.findAll().size());//某类型下新闻的记录数作为分页对象的总记录数
		request.setAttribute("productList", productService.findPageList(myPage,0));
		request.setAttribute("productTypeList", productTypeService.findAll());//传递新闻类型列表到页面中
		request.setAttribute("myPage", myPage);//传递分页对象到页面
		
		request.getRequestDispatcher("productlist.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
