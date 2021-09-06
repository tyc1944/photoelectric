package com.electric.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.NewsType;
import com.electric.entity.Page;
import com.electric.service.NewsService;
import com.electric.service.NewsTypeService;
import com.electric.service.impl.NewsServiceimpl;
import com.electric.service.impl.NewsTypeServiceimpl;

/**
 * Servlet implementation class AdminNewsServlet
 */
@WebServlet("/AdminNewsTypeServlet")
public class AdminNewsTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminNewsTypeServlet() {
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
		NewsService newsService = new NewsServiceimpl();
		NewsTypeService newsTypeService = new NewsTypeServiceimpl();
		String flag = request.getParameter("flag");
		if (flag.equals("list")) {
			Page myPage = new Page();
			myPage.setPageSize(10);
			String pageNo = request.getParameter("pageNo");
			if (pageNo != null) {
				myPage.setPageNo(Integer.parseInt(pageNo));
			}
			myPage.setRowCount(newsTypeService.findAll().size());// 设置记录数
			request.setAttribute("newsTypeList", newsTypeService.findPageList(myPage));
			request.setAttribute("myPage", myPage);
			request.getRequestDispatcher("admin/news/typelist.jsp").forward(request, response);
		} else if (flag.equals("toAdd")) {
			request.setAttribute("newsTypeList", newsTypeService.findAll());// 准备新闻类型集合给添加页面
			request.getRequestDispatcher("admin/news/addtype.jsp").forward(request, response);
		} else if (flag.equals("add")) {
			String typename = request.getParameter("typename");
			NewsType newstype = new NewsType(typename);
			if (newsTypeService.saveNewsType(newstype)) {
				out.print("ok");
			} else {
				out.print("error");
			}

		} else if (flag.equals("toUpdate")) {
			int typeId = Integer.parseInt(request.getParameter("typeId"));
			request.setAttribute("newstype", newsTypeService.findById(typeId));
			request.setAttribute("newsTypeList", newsTypeService.findAll());
			request.getRequestDispatcher("admin/news/updatetype.jsp").forward(request, response);
		} else if (flag.equals("update")) {
			int typeId = Integer.parseInt(request.getParameter("typeId"));
			String typename = request.getParameter("typename");
			NewsType newstype = new NewsType(typeId, typename);
			if (newsTypeService.updateNewsType(newstype)) {
				out.print("ok");
			} else {
				out.print("error");
			}
		} else if (flag.equals("delete")) {
			int typeId = Integer.parseInt(request.getParameter("typeId"));
			if (newsService.findListByTypeId(typeId).size() > 0) {
				out.print("haveChildren");
			} else {
				if (newsTypeService.deleteNewsType(typeId)) {
					out.print("ok");
				} else {
					out.print("error");
				}
			}
		} else if (flag.equals("Manydelete")) {
			String typeIds = request.getParameter("typeIds");// 1,3,5
			if (newsTypeService.deleteMany(typeIds)) {
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
