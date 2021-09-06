package com.electric.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electric.entity.About;
import com.electric.service.AboutService;
import com.electric.service.impl.AboutServiceimpl;

/**
 * Servlet implementation class ProductServlet_findAll
 */
@WebServlet("/aboutServlet_findAll")
public class aboutServlet_findAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public aboutServlet_findAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		AboutService aboutService=new AboutServiceimpl();
		List<About> List=aboutService.findAll();
		request.setAttribute("List", List);
		
		About about=null;
		String aboutId=request.getParameter("aboutId");
		if(aboutId!=null) {
			about=aboutService.findById(Integer.parseInt(aboutId));
			
		}else {
			about=List.get(0);
		}
		request.setAttribute("about", about);
		request.getRequestDispatcher("about.jsp").forward(request, response);
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
