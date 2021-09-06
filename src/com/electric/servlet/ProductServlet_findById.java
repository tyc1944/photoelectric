package com.electric.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.Product;
import com.electric.entity.ProductType;
import com.electric.service.ProductService;
import com.electric.service.ProductTypeService;
import com.electric.service.impl.ProductServiceimpl;
import com.electric.service.impl.ProductTypeServiceimpl;



/**
 * Servlet implementation class ProductServlet_findById
 */
@WebServlet("/ProductServlet_findById")
public class ProductServlet_findById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet_findById() {
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
		
		int productId=Integer.parseInt(request.getParameter("proId"));
		Product product=productService.findById(productId);
		
		ProductTypeService productTypeService=new ProductTypeServiceimpl();
		List<ProductType> allProductTypeList=productTypeService.findAll();
		request.setAttribute("proEntity", productService.findNewsEntityById(productId));
		request.setAttribute("product", product);//“背着”新闻对象到目标页面
		request.setAttribute("productTypeList", allProductTypeList);//"背着"所有的新闻类型列表
		request.getRequestDispatcher("productdetail.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
