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

	String getUserProfile = "select FirstName, LastName, Gender, Address, City, Country, Email, Telephone,"
			+ " PostalCode, Birthday_Month, Birthday_year, Birthday_Date, ProfileInfo from users_profile where upper(LoginName) = ? ";
	
	String updateUserProfile = "update users_profile set FirstName = ?, LastName = ?, Gender = ?, Address = ?, City = ?, Country = ?, Email = ?, Telephone = ?, PostalCode = ?, Birthday_Month = ?"
			+ ", Birthday_year = ?, Birthday_Date = ?, ProfileInfo = ? where upper(LoginName) = ? ";
	
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
				user.setbDate(rs.getString("Birthday_Date"));
				user.setbYear(rs.getString("Birthday_year"));
				user.setbMonth(rs.getString("Birthday_Month"));
				user.setAboutMe(rs.getString("ProfileInfo"));
				user.setEmail(rs.getString("Email"));
				user.setAddress(rs.getString("Address"));
				user.setPostalCode(rs.getString("PostalCode"));
				user.setCity(rs.getString("City"));
				user.setCountry(rs.getString("Country"));
				user.setTelephone(rs.getString("Telephone"));
				return user;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Users updateUserProfile(Users user) throws Exception {
		try {
			PreparedStatement prepStmt = getDBConnection().prepareStatement(
					updateUserProfile);
			System.out.println("=== SQL that is going to fire ==== "+updateUserProfile);
			prepStmt.setString(1, user.getFirstName());
			prepStmt.setString(2, user.getLastName());
			prepStmt.setString(3, user.getGender());
			prepStmt.setString(4, user.getAddress());
			prepStmt.setString(5, user.getCity());
			prepStmt.setString(6, user.getCountry());
			prepStmt.setString(7, user.getEmail());
			prepStmt.setString(8, user.getTelephone());
			prepStmt.setString(9, user.getPostalCode());
			prepStmt.setString(10, user.getbMonth());
			prepStmt.setString(11, user.getbYear());
			prepStmt.setString(12, user.getbDate());
			prepStmt.setString(13, user.getAboutMe());
			prepStmt.setString(14, user.getLoginName());
			
			System.out.println(prepStmt);
			
			prepStmt.executeUpdate();
		} catch(Exception e) {
			throw new Exception(e);
		}
		return user;
	}
	
}