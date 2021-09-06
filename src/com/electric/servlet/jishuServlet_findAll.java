package com.electric.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.Jishu;
import com.electric.service.JishuService;
import com.electric.service.impl.JishuServiceimpl;

/**
 * Servlet implementation class ProductServlet_findAll
 */
@WebServlet("/jishuServlet_findAll")
public class jishuServlet_findAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jishuServlet_findAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		JishuService jishuService=new JishuServiceimpl();
		List<Jishu> List=jishuService.findAll();
		request.setAttribute("List", List);
		
		Jishu jishu=null;
		String jishuId=request.getParameter("jishuId");
		if(jishuId!=null) {
			jishu=jishuService.findById(Integer.parseInt(jishuId));
			
		}else {
			jishu=List.get(0);
		}
		request.setAttribute("jishu", jishu);
		request.getRequestDispatcher("jishu.jsp").forward(request, response);
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
