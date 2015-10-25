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
		System.out.println("==== Loading My Courses Servlet doGet Method ====");
		
		String courseCode = request.getParameter("courseCode");
		String enrollCourseCode = request.getParameter("enrollCourseCode");
		
		System.out.println("==== Requsting to Load Course ===== " + courseCode);
		System.out.println("==== Requsting to enroll course ===== " + enrollCourseCode);
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		CoursesDBAO courseDBAO = new CoursesDBAO();
		if(user == null || "".equals(user)) {
			response.sendRedirect("login.jsp");
		} else {
			
			if(enrollCourseCode != null && !"".equals(enrollCourseCode)) {
				response.sendRedirect("home.jsp");
			} else if(courseCode == null || "".equals(courseCode)) {
				@SuppressWarnings("unchecked")
				List<Menu> lstMenu = (List<Menu>) session.getAttribute("lstMenu");
				request.setAttribute("lstMenu", lstMenu);
				
				
				List<Courses> lstCourses = courseDBAO.getAllCourseByUserName(user.toUpperCase());
				
				if(lstCourses.isEmpty()) {
					request.setAttribute("message", "You're either not enrolled in any course or your enrolled course is yet to be approved.");
				} else {
					request.setAttribute("lstCourses", lstCourses);
				}
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("mycourses.jsp");
				requestDispatcher.forward(request, response);
			} else {
				Courses c = courseDBAO.getCourseByCourseId(courseCode);
				String courseTitle = c.getCourseTitle();
					request.setAttribute("courseCode", courseCode);
					request.setAttribute("courseTitle", courseTitle);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("courseStudent.jsp");
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
