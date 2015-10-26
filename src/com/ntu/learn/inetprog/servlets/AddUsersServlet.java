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

import com.ntu.learn.inetprog.constants.ProfileInfoConstants;
import com.ntu.learn.inetprog.database.UserDBAO;
import com.ntu.learn.inetprog.model.Menu;
import com.ntu.learn.inetprog.model.Users;

/**
 * Servlet implementation class AddUsersServlet
 */
@WebServlet("/AddUsersServlet")
public class AddUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("=== Loading Add User Profile Servlet in DoGet Method ==== ");
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		if(user == null || "".equals(user)) {
			response.sendRedirect("login.jsp");
		} else {
			@SuppressWarnings("unchecked")
			List<Menu> lstMenu = (List<Menu>) session.getAttribute("lstMenu");
			request.setAttribute("lstMenu", lstMenu);
			
			String userType = request.getParameter("userTypeId");
			request.setAttribute("usertype", userType);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("userprofileadd.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		if(user == null || "".equals(user)) {
			response.sendRedirect("login.jsp");
		} else {
			String loginName = request.getParameter("loginName");
			String password = request.getParameter("password");
			String firstName = request.getParameter("displayName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String city= request.getParameter("city");
			String country = request.getParameter("country");
			String postalCode = request.getParameter("postalCode");
			String telephone = request.getParameter("telephone");
			String email = request.getParameter("emailId");
			String userType = request.getParameter("typeOfUser");
			String userProfileInfo="";
			if(userType.equalsIgnoreCase("T")){
				userProfileInfo = ProfileInfoConstants.USER_PROFILE_STAFF;
			}
			else if(userType.equalsIgnoreCase("S")){
				userProfileInfo = ProfileInfoConstants.USER_PROFILE_STUDENT;
			}
			else if(userType.equalsIgnoreCase("A")){
				userProfileInfo = ProfileInfoConstants.USER_PROFILE_ADMIN;
			}
			else{
				userProfileInfo = ProfileInfoConstants.USER_PROFILE_OTHER;
			}
			String isDeleted = request.getParameter("isDeleted");
			System.out.println("=== Updating user profile information with following values " + 
			firstName +"," + lastName +","+password +"," + loginName +"," + address+","+userType+","+isDeleted+","
					+ ""+city+","+country+","+postalCode+","+telephone+","+email);
			
			
			Users users = new Users();
			users.setLoginName(loginName);
			users.setPassword(password);
			users.setFirstName(firstName);
			users.setLastName(lastName); 
			users.setAddress(address);
			users.setCity(city);
			users.setCountry(country);
			users.setTelephone(telephone);
			users.setEmail(email);
			users.setPostalCode(postalCode);
			users.setTypeOfUser(userType);
			users.setAboutMe(userProfileInfo);
			users.setIsDeleted(isDeleted);
			
			
			UserDBAO userDBAO = new UserDBAO();
			boolean updateFlag = true;
			try {
				userDBAO.insertUserProfile(users);
			} catch(Exception e) {
				e.printStackTrace();
				updateFlag = false;
			}
			if(updateFlag) {
				request.setAttribute("message", "User Profile "+loginName + " has been added successfully");
			} else {
				request.setAttribute("message", "Oops, There was some error, Please contact Programm Manager..........");
			}
			ArrayList<Users> lstUsers = userDBAO.getListOfUsersByTypeId(userType);
			System.out.println("The arraylist size is="+lstUsers.size());
			
			request.setAttribute("listofusers", lstUsers);
			request.setAttribute("usertype", userType);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("userslist.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
