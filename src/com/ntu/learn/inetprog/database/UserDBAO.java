package com.ntu.learn.inetprog.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ntu.learn.inetprog.model.Users;

/**
 * 
 * @author shankara
 *
 */
public class UserDBAO extends DatabaseUtil {

	String getUserProfile = "select FirstName, LastName, Gender, Address, City, Country, Email, Telephone, PostalCode from users_profile where upper(LoginName) = ? ";
	
	public Users authenticate(String userId, String password) {
		try {
			String selectStatement = "select LoginName, UserType, IsDeleted "
					+ "from users_profile where LoginName = ? and Password = ? ";
			PreparedStatement prepStmt = getDBConnection().prepareStatement(
					selectStatement);
			prepStmt.setString(1, userId);
			prepStmt.setString(2, password);
			ResultSet rs = prepStmt.executeQuery();

			if (rs.next()) {
				Users user = new Users();
				user.setLoginName(rs.getString("LoginName"));
				user.setTypeOfUser(rs.getString("UserType"));
				user.setIsDeleted(rs.getString("IsDeleted"));
				return user;
			}
			
		} catch (Exception e) {
			System.err.println("=== Error in User Authentication ===== ");
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public Users getUserProfileByName(String userId) {
		try {
			PreparedStatement prepStmt = getDBConnection().prepareStatement(
					getUserProfile);
			prepStmt.setString(1, userId);
			ResultSet rs = prepStmt.executeQuery();
			System.out.println("=== SQL Firing to Database " + getUserProfile);
			System.out.println("=== SQL Parameters " + userId);
			if (rs.next()) {
				Users user = new Users();
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
				user.setGender(rs.getString("Gender"));
				return user;
			}
		} catch(Exception e) {
			
		}
		return null;
	}
}
