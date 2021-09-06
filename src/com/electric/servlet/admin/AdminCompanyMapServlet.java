package com.electric.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.Companymap;
import com.electric.service.CompanyMapService;
import com.electric.service.impl.CompanyMapServiceimpl;



/**
 * Servlet implementation class AdminNewsServlet
 */
@WebServlet("/AdminCompanyMapServlet")
public class AdminCompanyMapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCompanyMapServlet() {
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
		CompanyMapService companymapService=new CompanyMapServiceimpl();
		String flag=request.getParameter("flag");
		if(flag.equals("toUpdate")) {
			//int proId=Integer.parseInt(request.getParameter("proId"));
			Companymap companymap=companymapService.findAll().get(0);
			request.setAttribute("companymap", companymap);
			request.getRequestDispatcher("admin/companymap/update.jsp").forward(request, response);
		}else if(flag.equals("update")) {
			int typeId=Integer.parseInt(request.getParameter("typeId"));
			String typeName=request.getParameter("typeName");
			Companymap companymap=new Companymap(typeId, typeName);
			if(companymapService.updatecompanymap(companymap)) {
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
