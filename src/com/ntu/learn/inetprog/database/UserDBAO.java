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
}
