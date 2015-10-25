package com.ntu.learn.inetprog.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ntu.learn.inetprog.constants.OnlineCSRoomConstants;
import com.ntu.learn.inetprog.database.CoursesDBAO;
import com.ntu.learn.inetprog.model.EnrolledCourseUsers;

/**
 * Servlet implementation class AdminCoursesServlet
 */
@WebServlet("/AdminCoursesServlet")
public class AdminCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCoursesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("==== Loading All Pending Enrolled Courses ======");
		
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		
		String action = request.getParameter("action");
		String courseCode = request.getParameter("courseCode");
		String loginName = request.getParameter("loginName");
		
		System.out.println(action +"," + courseCode +"," + loginName);
		
		if(user == null || "".equals(user)) {
			response.sendRedirect("login.jsp");
		}  else if(loginName  != null &&courseCode !=null && action!=null ) {
			
			CoursesDBAO courseDBAO = new CoursesDBAO();
			int status = courseDBAO.approveOrRejectEnrolledCourse(courseCode, loginName, action);
			PrintWriter out = response.getWriter();
			System.out.println("== Writing response ===");
			if(status > 0) {
				out.write(OnlineCSRoomConstants.SUCCESS);
			} else  {
				out.write(OnlineCSRoomConstants.FAILED);
			}
			
		} else {
			
		
		CoursesDBAO courseDBAO = new CoursesDBAO();
		List<EnrolledCourseUsers> lstEnrolledCourses = courseDBAO.getAllPendingEnrolledCourse();
		
		request.setAttribute("lstEnrolledCourses", lstEnrolledCourses);
		
		RequestDispatcher rd = request.getRequestDispatcher("pendingenrolledcourses.jsp");
		rd.forward(request, response);
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
