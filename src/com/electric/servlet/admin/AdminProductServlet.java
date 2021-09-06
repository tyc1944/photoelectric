package com.electric.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.Page;
import com.electric.entity.Product;
import com.electric.service.ProductService;
import com.electric.service.ProductTypeService;
import com.electric.service.impl.ProductServiceimpl;
import com.electric.service.impl.ProductTypeServiceimpl;



/**
 * Servlet implementation class AdminNewsServlet
 */
@WebServlet("/AdminProductServlet")
public class AdminProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProductServlet() {
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
		ProductService productService=new ProductServiceimpl();
		ProductTypeService productTypeService=new ProductTypeServiceimpl();
		String flag=request.getParameter("flag");
		if(flag.equals("list")) {
			Page myPage=new Page();
			myPage.setPageSize(10);
			String pageNo=request.getParameter("pageNo");
			if(pageNo!=null) {
				myPage.setPageNo(Integer.parseInt(pageNo));
			}
			myPage.setRowCount(productService.findAll().size());//设置记录数
			request.setAttribute("productList", productService.findPageList(myPage, 0));
			request.setAttribute("myPage", myPage);
			request.getRequestDispatcher("admin/product/list.jsp").forward(request, response);
		}else if(flag.equals("toAdd")) {
			request.setAttribute("productTypeList", productTypeService.findAll());//准备新闻类型集合给添加页面
			request.getRequestDispatcher("admin/product/add.jsp").forward(request, response);
		}else if(flag.equals("add")) {
			String title=request.getParameter("title");
			String pic=request.getParameter("pic");
			int typeId=Integer.parseInt(request.getParameter("typeId"));
			String content=request.getParameter("content");
			Product product=new Product(title, content, pic, typeId);
			if(productService.saveProduct(product)) {
				out.print("ok");
			}else {
				out.print("error");
			}
			
		}else if(flag.equals("delete")) {
			int proId=Integer.parseInt(request.getParameter("proId"));
			if(productService.deleteProduct(proId)) {
				out.print("ok");
			}else {
				out.print("error");
			}
		}else if(flag.equals("toUpdate")) {
			int proId=Integer.parseInt(request.getParameter("proId"));
			request.setAttribute("product", productService.findById(proId));
			request.setAttribute("productTypeList", productTypeService.findAll());//准备新闻类型集合给添加页面
			request.getRequestDispatcher("admin/product/update.jsp").forward(request, response);
		}else if(flag.equals("update")) {
			int proId=Integer.parseInt(request.getParameter("proId"));
			String title=request.getParameter("title");
			String pic=request.getParameter("pic");
			int typeId=Integer.parseInt(request.getParameter("typeId"));
			String content=request.getParameter("content");
			Timestamp postTime=Timestamp.valueOf(request.getParameter("postTime"));
			Product product=new Product(proId, title, content, pic, postTime, typeId);
			if(productService.updateProduct(product)) {
				out.print("ok");
			}else {
				out.print("error");
			}
			
		}else if(flag.equals("Manydelete")) {
			String proIds=request.getParameter("proIds");//1,3,5
			if(productService.deleteMany(proIds)) {
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
