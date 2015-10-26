package com.ntu.learn.inetprog.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ntu.learn.inetprog.database.UserDBAO;
import com.ntu.learn.inetprog.model.Menu;
import com.ntu.learn.inetprog.model.UserType;
import com.ntu.learn.inetprog.model.Users;

/**
 * 
 * @author Kailash Shankar
 *
 */
/**
 * Servlet implementation class FindUsersServlet
 */
@WebServlet("/FindUsersServlet")
public class FindUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("==== Loading Find Users Servlet DoGet Method ===== ");
		String userType = request.getParameter("userTypeId");
				
		System.out.println("==== The user type id is= "+ userType +" ====");
				
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		if(user == null || "".equals(user)) {
			response.sendRedirect("login.jsp");
		} else {
			
			@SuppressWarnings("unchecked")
			List<Menu> lstMenu = (List<Menu>) session.getAttribute("lstMenu");
			request.setAttribute("lstMenu", lstMenu);
			
			UserDBAO userDBAO = new UserDBAO();
			ArrayList<Users> lstUsers = userDBAO.getListOfUsersByTypeId(userType);
			System.out.println("The arraylist size is="+lstUsers.size());
			
			request.setAttribute("listofusers", lstUsers);
			request.setAttribute("usertype", userType);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("userslist.jsp");
			requestDispatcher.forward(request, response);
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
