package com.electric.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.Pingzhi;
import com.electric.service.PingzhiService;
import com.electric.service.impl.PingzhiServiceimpl;

/**
 * Servlet implementation class ProductServlet_findAll
 */
@WebServlet("/pingzhiServlet_findAll")
public class pingzhiServlet_findAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pingzhiServlet_findAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PingzhiService pingzhiService=new PingzhiServiceimpl();
		List<Pingzhi> List=pingzhiService.findAll();
		request.setAttribute("List", List);
		
		Pingzhi pingzhi=null;
		String pingzhiId=request.getParameter("pingzhiId");
		if(pingzhiId!=null) {
			pingzhi=pingzhiService.findById(Integer.parseInt(pingzhiId));
			
		}else {
			pingzhi=List.get(0);
		}
		request.setAttribute("pingzhi", pingzhi);
		request.getRequestDispatcher("pingzhi.jsp").forward(request, response);
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
