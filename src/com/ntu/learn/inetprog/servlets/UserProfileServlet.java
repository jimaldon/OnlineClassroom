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

import com.ntu.learn.inetprog.constants.ProfileInfoConstants;
import com.ntu.learn.inetprog.database.UserDBAO;
import com.ntu.learn.inetprog.model.Menu;
import com.ntu.learn.inetprog.model.Users;

/**
 * 
 * @author Kailash Shankar
 *
 */
/**
 * Servlet implementation class UserProfileServlet
 */
@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.out.println("=== Loading User Profile Servlet in DoGet Method ==== ");
				
				HttpSession session = request.getSession();
				String user = (String) session.getAttribute("user");
				if(user == null || "".equals(user)) {
					response.sendRedirect("login.jsp");
				} else {
					@SuppressWarnings("unchecked")
					List<Menu> lstMenu = (List<Menu>) session.getAttribute("lstMenu");
					request.setAttribute("lstMenu", lstMenu);
					
					String userLoginName = request.getParameter("userLoginName");
					
					UserDBAO userDBAO = new UserDBAO();
					Users users = userDBAO.getUserProfileByAdmin(userLoginName);
					request.setAttribute("profile", users);
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("userprofile.jsp");
					requestDispatcher.forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		if(user == null || "".equals(user)) {
			response.sendRedirect("login.jsp");
		} else {
			String loginName = request.getParameter("loginName");
			String password = request.getParameter("password");
			String firstName = request.getParameter("displayName");
			String lastName = request.getParameter("lastName");
			String gender = request.getParameter("gender");
			String birthDate = request.getParameter("date");
			String birthMonth = request.getParameter("month");
			String birthYear = request.getParameter("year");
			String aboutMe = request.getParameter("aboutMe");
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
			firstName +"," + lastName +","+gender +"," + birthDate +"," + birthMonth+","+birthYear+","+aboutMe+","
					+ ""+address+","+country+","+postalCode+","+telephone+","+email);
			
			Users users = new Users();
			users.setPassword(password);
			users.setFirstName(firstName);
			users.setLastName(lastName); 
			users.setCountry(country);
			users.setCity(city);
			users.setTelephone(telephone);
			users.setEmail(email);
			users.setPostalCode(postalCode);
			users.setAddress(address);
			users.setTypeOfUser(userType);
			users.setAboutMe(userProfileInfo);
			users.setIsDeleted(isDeleted);
			users.setLoginName(loginName);
			
			UserDBAO userDBAO = new UserDBAO();
			boolean updateFlag = true;
			try {
				userDBAO.updateUserProfileByAdmin(users);
			} catch(Exception e) {
				e.printStackTrace();
				updateFlag = false;
			}
			if(updateFlag) {
				request.setAttribute("message", "User Profile "+loginName + " Has Been Updated Successfully");
			} else {
				request.setAttribute("message", "Oops, There was some error, Please contact Programm Manager..........");
			}
			request.setAttribute("profile", users);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("userprofile.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
