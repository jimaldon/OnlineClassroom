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

import com.ntu.learn.inetprog.database.CoursesDBAO;
import com.ntu.learn.inetprog.model.Courses;
import com.ntu.learn.inetprog.model.Menu;

/**
 * Servlet implementation class FindCoursesServlet
 */
@WebServlet("/FindCoursesServlet")
public class FindCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCoursesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("==== Loading Find Courses Servlet doGet Method ====");
		
		String courseName = request.getParameter("course");
		
		System.out.println("==== Find Courses for Category "+ courseName +" ====");
		
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		
		@SuppressWarnings("unchecked")
		List<Menu> lstMenu = (List<Menu>) session.getAttribute("lstMenu");
		request.setAttribute("lstMenu", lstMenu);
		
		if(user == null || "".equals(user)) {
			response.sendRedirect("login.jsp");
		} else {

			if(courseName == null || "".equals(courseName)) {
				request.setAttribute("selectedCourse", false);
				System.out.println("==== Setting Selected Course Flag N ====");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("findcourses.jsp");
				requestDispatcher.forward(request, response);
			} else {
				request.setAttribute("selectedCourse", true);
				System.out.println("==== Setting Selected Course Flag Y ====");
				
				CoursesDBAO courseDBAO = new CoursesDBAO();
				List<Courses> lstCourses = courseDBAO.getAllCourseByCategory(courseName.toUpperCase());
				
				request.setAttribute("lstCourses", lstCourses);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("findcourses.jsp");
				requestDispatcher.forward(request, response);
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
