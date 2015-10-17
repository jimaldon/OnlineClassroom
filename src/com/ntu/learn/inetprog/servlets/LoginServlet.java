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
import com.ntu.learn.inetprog.model.Menu;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("===== Inside Login Servlet ===== ");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		if(session == null) {
			System.out.println(" ==== Session Object is Null ====== ");
			response.sendRedirect("login.jsp");
		}
		
		String user = (String) session.getAttribute("user");
		
		if(user == null) {
			System.out.println(" ==== User Object is Null ====== ");
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("===== Inside Login Servlet POST Method ===== ");
		
		
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String userType =  request.getParameter("userType");
		
		System.out.println("===== Login Request for User Name "+ userName + " and User Type "+ userType +" ===== ");
		
		if((userName == null || "".equals(userName)) || (password == null || "".equals(password) )) {
			
			response.sendRedirect("login.jsp");
		} else {
			
		
		List<Menu> lstMenu = new ArrayList<Menu>();
		
		
		if (userType.equalsIgnoreCase(OnlineCSRoomConstants.USER_ROLE_STUDENT)) {
			lstMenu.add(new Menu("", OnlineCSRoomConstants.MENU_FIND_COURSE));
			lstMenu.add(new Menu("", OnlineCSRoomConstants.MENU_MY_COURSE));
			lstMenu.add(new Menu("", OnlineCSRoomConstants.MENU_MY_PROFILE));
			lstMenu.add(new Menu("LogoutServlet", OnlineCSRoomConstants.MENU_SIGN_OUT));
		}
		
		request.setAttribute("lstMenu", lstMenu);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
        requestDispatcher.forward(request, response);
		}
		
	}

}
