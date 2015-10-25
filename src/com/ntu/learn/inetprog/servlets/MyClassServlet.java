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

/**
 * Servlet implementation class MyClassServlet
 */
@WebServlet("/MyClassServlet")
public class MyClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" ==== Loading My Class Servlet  ===== ");
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");

		if (user == null) {
			System.out.println(" ==== User Object is Null ====== ");
			response.sendRedirect("login.jsp");
		} else {
			CoursesDBAO courseDBAO = new CoursesDBAO();
			List<Courses> lstCourses = courseDBAO.getMyClassCourses(user.toUpperCase());
			
			request.setAttribute("lstCourses", lstCourses);
			
			RequestDispatcher rd = request.getRequestDispatcher("myclass.jsp");
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
