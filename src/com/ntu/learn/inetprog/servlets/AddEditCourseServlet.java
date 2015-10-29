package com.ntu.learn.inetprog.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ntu.learn.inetprog.constants.OnlineCSRoomConstants;
import com.ntu.learn.inetprog.database.CoursesDBAO;
import com.ntu.learn.inetprog.model.Courses;

/**
 * Servlet implementation class AddEditCourseServlet
 */
@WebServlet("/AddEditCourseServlet")
public class AddEditCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEditCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		
		String editCourse = request.getParameter("editCourse");
		
		
		if (user == null) {
			System.out.println(" ==== User Object is Null ====== ");
			response.sendRedirect("login.jsp");
		} else if (editCourse != null) {
			System.out.println("=== Course to Edit and Save ==== " + editCourse);
			CoursesDBAO courseDBAO = new CoursesDBAO();
			Courses course = courseDBAO.getCourseByCourseId(editCourse, false);
			request.setAttribute("course", course);
			request.setAttribute("editCourse", true);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("addeditcourse.jsp");
			requestDispatcher.forward(request, response);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		System.out.println("=== Do Post Invoke for Adding or Editing new course =====");

		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		
		String editFlag = request.getParameter("editFlag");
		String updateCourse = request.getParameter("submit");

		if (user == null) {
			System.out.println(" ==== User Object is Null ====== ");
			response.sendRedirect("login.jsp");
		} else if(editFlag != null && editFlag.equalsIgnoreCase(OnlineCSRoomConstants.FLAG_YES)) {
			System.out.println("=== Request to update existing course =====");
			
		} else if(updateCourse != null) {
			System.out.println("=== Request to Update Course ==== " + updateCourse);
			CoursesDBAO courseDBAO = new CoursesDBAO();
			String courseCode = request.getParameter("courseCode");
			String courseTitle = request.getParameter("courseTitle");
			String courseCategory = request.getParameter("courseCategory");
			String shortDesc = request.getParameter("shortDesc");
			String aboutCourse = request.getParameter("aboutCourse");
			String ccMonth = request.getParameter("month");
			String ccDay = request.getParameter("date");
			String ccYear = request.getParameter("year");
			String courseSyllabus = request.getParameter("courseSyllabus");
			
			String categoryId = courseDBAO.getCourseCategoryId(courseCategory);
			
			System.out.println("=== Updating course with following details "+","+courseCode+","+courseTitle+","+courseCategory+","
			+shortDesc+","+aboutCourse+","+ccMonth+","+ccDay+","+ccYear+","+courseSyllabus);
			
			/*Courses course = new Courses();
			course.setCourseTitle(courseTitle);
			course.setCourseShortDesc(shortDesc);
			course.setCourseMonth(ccMonth);
			course.setCourseDate(ccDay);
			course.setCourseYear(ccYear);
			course.setCourseCategory(categoryId);
			course.setCourseSyallbus(courseSyllabus);
			course.setCourseCode(updateCourse);*/
			try {
				//if(course != null) {
				//	course =  courseDBAO.updateCourse(course);
					request.setAttribute("message", "Course Updated Successfully");
				//}
			} catch(Exception e) {
				request.setAttribute("message", "Oops, Something went wrong, Please contact adminstrator");
			}
			
			//request.setAttribute("course", course);
			request.setAttribute("editCourse", true);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("addeditcourse.jsp");
			requestDispatcher.forward(request, response);
		}
		
		else {
			System.out.println("=== Request to add new course =====");
			String courseTitle = request.getParameter("courseTitle");
			String courseCategory = request.getParameter("courseCategory");
			String shortDesc = request.getParameter("shortDesc");
			String aboutCourse = request.getParameter("aboutCourse");
			String ccMonth = request.getParameter("month");
			String ccDay = request.getParameter("date");
			String ccYear = request.getParameter("year");
			String courseSyllabus = request.getParameter("courseSyllabus");
			
			System.out.println("=== Creating new course with following details "+","+courseTitle+","+courseCategory+","
			+shortDesc+","+aboutCourse+","+ccMonth+","+ccDay+","+ccYear+","+courseSyllabus);
			
			CoursesDBAO courseDBAO = new CoursesDBAO();
			
			String time = Long.toString(System.currentTimeMillis());
			
			String categoryId = courseDBAO.getCourseCategoryId(courseCategory);
			
			Courses course = new Courses();
			course.setCourseTitle(courseTitle);
			course.setCourseShortDesc(shortDesc);
			course.setCourseMonth(ccMonth);
			course.setCourseDate(ccDay);
			course.setCourseYear(ccYear);
			course.setAuthor(user);
			course.setCourseCategory(categoryId);
			course.setCourseSyallbus(courseSyllabus);
			course.setCourseCode(time.substring(time.length()-3, time.length()));
			
			try {
				courseDBAO.createNewCourse(course);
				request.setAttribute("message", "Course Added Successfully");
			} catch(Exception e) {
				request.setAttribute("message", "Oops, Something went wrong, Please contact adminstrator");
			}
			
			request.setAttribute("course", course);
			request.setAttribute("editCourse", true);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("addeditcourse.jsp");
			requestDispatcher.forward(request, response);
			
		}
	}
}