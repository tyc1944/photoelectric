package com.electric.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.Page;
import com.electric.entity.ProductType;
import com.electric.service.ProductService;
import com.electric.service.ProductTypeService;
import com.electric.service.impl.ProductServiceimpl;
import com.electric.service.impl.ProductTypeServiceimpl;

/**
 * Servlet implementation class AdminNewsServlet
 */
@WebServlet("/AdminProductTypeServlet")
public class AdminProductTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminProductTypeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		ProductService productService = new ProductServiceimpl();
		ProductTypeService productTypeService = new ProductTypeServiceimpl();
		String flag = request.getParameter("flag");
		if (flag.equals("list")) {
			Page myPage = new Page();
			myPage.setPageSize(5);
			String pageNo = request.getParameter("pageNo");
			if (pageNo != null) {
				myPage.setPageNo(Integer.parseInt(pageNo));
			}
			myPage.setRowCount(productTypeService.findAll().size());// 设置记录数
			request.setAttribute("productTypeList", productTypeService.findPageList(myPage));
			request.setAttribute("myPage", myPage);
			request.getRequestDispatcher("admin/product/typelist.jsp").forward(request, response);
		} else if (flag.equals("toAdd")) {
			request.setAttribute("productTypeList", productTypeService.findAll());// 准备新闻类型集合给添加页面
			request.getRequestDispatcher("admin/product/addtype.jsp").forward(request, response);
		} else if (flag.equals("add")) {
			String typename = request.getParameter("typename");
			ProductType productType = new ProductType(typename);
			if (productTypeService.saveProductType(productType)) {
				out.print("ok");
			} else {
				out.print("error");
			}

		} else if (flag.equals("toUpdate")) {
			int typeId = Integer.parseInt(request.getParameter("typeId"));
			request.setAttribute("producttype", productTypeService.findById(typeId));
			request.setAttribute("productTypeList", productTypeService.findAll());
			request.getRequestDispatcher("admin/product/updatetype.jsp").forward(request, response);
		} else if (flag.equals("update")) {
			int typeId = Integer.parseInt(request.getParameter("typeId"));
			String typename = request.getParameter("typename");
			ProductType producttype = new ProductType(typeId, typename);
			if (productTypeService.updateProductType(producttype)) {
				out.print("ok");
			} else {
				out.print("error");
			}
		} else if (flag.equals("delete")) {
			int typeId = Integer.parseInt(request.getParameter("typeId"));
			if (productService.findListByTypeId(typeId).size() > 0) {
				out.print("haveChildren");
			} else {
				if (productTypeService.deleteProductType(typeId)) {
					out.print("ok");
				} else {
					out.print("error");
				}
			}
		} else if (flag.equals("Manydelete")) {
			String typeIds = request.getParameter("typeIds");// 1,3,5
			if (productTypeService.deleteMany(typeIds)) {
				out.print("ok");
			} else {
				out.print("error");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
