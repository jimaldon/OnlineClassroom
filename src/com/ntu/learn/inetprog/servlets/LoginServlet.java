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

import com.ntu.learn.inetprog.constants.OnlineCSRoomConstants;
import com.ntu.learn.inetprog.database.UserDBAO;
import com.ntu.learn.inetprog.model.Menu;
import com.ntu.learn.inetprog.model.Users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("===== Inside Login Servlet ===== ");
		response.getWriter().append("Served at: ")
				.append(request.getContextPath());
		HttpSession session = request.getSession();
		if (session == null) {
			System.out.println(" ==== Session Object is Null ====== ");
			response.sendRedirect("login.jsp");
		}

		String user = (String) session.getAttribute("user");

		if (user == null) {
			System.out.println(" ==== User Object is Null ====== ");
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("===== Inside Login Servlet POST Method ===== ");

		HttpSession session = request.getSession();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		System.out.println("===== Login Request for User Name " + userName
				+ " ===== ");

		if ((userName == null || "".equals(userName))
				|| (password == null || "".equals(password))) {

			response.sendRedirect("login.jsp");
		} else {
			UserDBAO userDBAO = new UserDBAO();

			Users user = userDBAO.authenticate(userName, password);

			if (null == user) {
				session.setAttribute("error", "User Profile Not Found");
				response.sendRedirect("login.jsp");
			} else if(user.getIsDeleted().equalsIgnoreCase(OnlineCSRoomConstants.FLAG_YES)) {
				session.setAttribute("error", "User Profile is Deleted, Please contact Adminstrator");
				response.sendRedirect("login.jsp");
			} else {

				List<Menu> lstMenu = new ArrayList<Menu>();
	
				session.setAttribute("user", userName);
	
				if (user.getTypeOfUser().equalsIgnoreCase(
						OnlineCSRoomConstants.USER_ROLE_STUDENT)) {
					lstMenu.add(new Menu("FindCoursesServlet",
							OnlineCSRoomConstants.MENU_FIND_COURSE));
					lstMenu.add(new Menu("MyCoursesServlet",
							OnlineCSRoomConstants.MENU_MY_COURSE));
					lstMenu.add(new Menu("MyProfileServlet",
							OnlineCSRoomConstants.MENU_MY_PROFILE));
					lstMenu.add(new Menu("LogoutServlet",
							OnlineCSRoomConstants.MENU_SIGN_OUT));
				} else if (user.getTypeOfUser().equalsIgnoreCase(
						OnlineCSRoomConstants.USER_ROLE_ADMIN)) {
					lstMenu.add(new Menu("AdminUserServlet", OnlineCSRoomConstants.MENU_ADMIN_USER));
					//lstMenu.add(new Menu("", OnlineCSRoomConstants.MENU_ADMIN_COURSE));
					lstMenu.add(new Menu("LogoutServlet",OnlineCSRoomConstants.MENU_SIGN_OUT));
				}
	
				request.setAttribute("lstMenu", lstMenu);
				session.setAttribute("lstMenu", lstMenu);
	
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
				requestDispatcher.forward(request, response);
			}
		}

	}

}
