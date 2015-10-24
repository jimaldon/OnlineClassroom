package com.ntu.learn.inetprog.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ntu.learn.inetprog.database.EnrollCoursesDBAO;

/**
 * Servlet implementation class EnrollCourseServlet
 */
@WebServlet("/EnrollCourseServlet")
public class EnrollCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		

		if(user == null || "".equals(user)) {
			response.sendRedirect("login.jsp");
		} else {
			String courseCode = request.getParameter("courseCode");
			System.out.println("===== Enrolling Course for User ===== " + user +"," + courseCode);
			
			EnrollCoursesDBAO enrollCourseDBAO = new EnrollCoursesDBAO();
			enrollCourseDBAO.enrollCourse(user, courseCode);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
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
