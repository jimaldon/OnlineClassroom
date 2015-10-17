package com.ntu.learn.inetprog.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ntu.learn.inetprog.model.Menu;

/**
 * Servlet implementation class MyCoursesServlet
 */
@WebServlet("/MyCoursesServlet")
public class MyCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCoursesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	System.out.println("==== Loading My Courses Servlet doGet Method ====");
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		if(user == null || "".equals(user)) {
			response.sendRedirect("login.jsp");
		} else {
			@SuppressWarnings("unchecked")
			List<Menu> lstMenu = (List<Menu>) session.getAttribute("lstMenu");
			request.setAttribute("lstMenu", lstMenu);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("mycourses.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
