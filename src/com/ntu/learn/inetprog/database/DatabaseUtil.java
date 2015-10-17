package com.ntu.learn.inetprog.database;

import java.sql.Connection;
import java.sql.DriverManager;

import com.ntu.learn.inetprog.constants.DatabaseConstants;

public class DatabaseUtil {

	private static Connection connection = null;

	public static Connection getDBConnection() throws Exception {
		if (connection == null) {
			try {
				Class.forName(DatabaseConstants.DB_DRIVER);
				connection = DriverManager.getConnection(
						DatabaseConstants.DB_CONNECTION,
						DatabaseConstants.DB_USER_NAME,
						DatabaseConstants.DB_PASSWORD);
			} catch (Exception e) {
				System.err
						.println("=== Error in getting database connection ====");
				e.printStackTrace();
				throw new Exception(e);
			}
		}

		return connection;
	}
}
