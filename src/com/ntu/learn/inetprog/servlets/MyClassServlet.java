package com.ntu.learn.inetprog.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.ntu.learn.inetprog.database.CoursesDBAO;
import com.ntu.learn.inetprog.model.Comments;
import com.ntu.learn.inetprog.model.Courses;
import com.ntu.learn.inetprog.utils.OnlineCSUtil;

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
		
		String comment = request.getParameter("comments");
		String courseCode = request.getParameter("courseCode");
		System.out.println(" Add Comments Parameter  comments for course " + comment +"," + courseCode);
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");

		if (user == null) {
			System.out.println(" ==== User Object is Null ====== ");
			response.sendRedirect("login.jsp");
		} else if(user != null && comment != null && courseCode != null) {
			System.out.println(" Invoking method to add comments ");
			CoursesDBAO courseDBAO = new CoursesDBAO();
			Courses course = courseDBAO.getCourseByCourseId(courseCode);
			
			Comments comments = new Comments();
			comments.setCommentedBy(user.toUpperCase());
			comments.setCommentsValue(comment);
			
			List<Comments> lstComments = course.getLstComments();
			if(lstComments == null) {
				lstComments = new ArrayList<Comments>();
			}
			lstComments.add(comments);
			List<JSONObject> lstJsonObj = null;
			String jsonString = null;
			JSONObject responseDetailsJson = new JSONObject();
			JSONObject dbJson = new JSONObject();
			try {
				lstJsonObj = OnlineCSUtil.getCommentsJsonObj(lstComments);
				dbJson.put("comments",lstJsonObj);
				responseDetailsJson.put("comments", lstJsonObj.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("=== Converted Json after added to Comments ==== " + dbJson);
			System.out.println("=== Converted Json after added to Comments to database ==== " + responseDetailsJson.toString());
			
			courseDBAO.updateCourseComments(dbJson.toString(), courseCode);
			
			PrintWriter out = response.getWriter();
			out.write(responseDetailsJson.toString());
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
