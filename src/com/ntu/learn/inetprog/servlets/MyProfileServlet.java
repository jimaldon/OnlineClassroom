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

import com.ntu.learn.inetprog.database.UserDBAO;
import com.ntu.learn.inetprog.model.Menu;
import com.ntu.learn.inetprog.model.Users;

/**
 * Servlet implementation class MyProfileServlet
 */
@WebServlet("/MyProfileServlet")
public class MyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("=== Loading My Profile Servlet in DoGet Method ==== ");
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		if(user == null || "".equals(user)) {
			response.sendRedirect("login.jsp");
		} else {
			@SuppressWarnings("unchecked")
			List<Menu> lstMenu = (List<Menu>) session.getAttribute("lstMenu");
			request.setAttribute("lstMenu", lstMenu);
			
			UserDBAO userDBAO = new UserDBAO();
			Users users = userDBAO.getUserProfileByName(user.toUpperCase());
			request.setAttribute("profile", users);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("profile.jsp");
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
			
			String firstName = request.getParameter("displayName");
			String lastName = request.getParameter("lastName");
			String gender = request.getParameter("gender");
			String birthDate = request.getParameter("date");
			String birthMonth = request.getParameter("month");
			String birthYear = request.getParameter("year");
			String aboutMe = request.getParameter("aboutMe");
			String address = request.getParameter("address");
			String country = request.getParameter("country");
			String postalCode = request.getParameter("postalCode");
			String telephone = request.getParameter("telephone");
			String email = request.getParameter("emailId");
			
			System.out.println("=== Updating user profile information with following values " + 
			firstName +"," + lastName +","+gender +"," + birthDate +"," + birthMonth+","+birthYear+","+aboutMe+","
					+ ""+address+","+country+","+postalCode+","+telephone+","+email);
			
			Users users = new Users();
			users.setFirstName(firstName);
			users.setLastName(lastName); 
			users.setAboutMe(aboutMe);
			users.setbDate(birthDate);
			users.setbMonth(birthMonth);
			users.setbYear(birthYear);
			users.setCountry(country);
			users.setTelephone(telephone);
			users.setEmail(email);
			users.setPostalCode(postalCode);
			users.setAddress(address);
			users.setGender(gender);
			
			users.setLoginName(user.toUpperCase());
			
			UserDBAO userDBAO = new UserDBAO();
			boolean updateFlag = true;
			try {
				userDBAO.updateUserProfile(users);
			} catch(Exception e) {
				e.printStackTrace();
				updateFlag = false;
			}
			if(updateFlag) {
				request.setAttribute("message", "Your Profile Has Been Updated Successfully");
			} else {
				request.setAttribute("message", "Oops, There was some error, Please contact System Admin");
			}
			request.setAttribute("profile", users);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("profile.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
