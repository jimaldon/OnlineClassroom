package com.ntu.learn.inetprog.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ntu.learn.inetprog.constants.OnlineCSRoomConstants;

public class EnrollCoursesDBAO extends DatabaseUtil {

	String getCourseId = "select CourseID from courses where CourseCode = ?";
	
	String getEnrolledCourse = "select CourseID, LoginName, enroll_status from course_enrolls where CourseID = ? and upper(LoginName) = ?";
	
	String insertEnrollCourse = "insert into course_enrolls (CourseID, LoginName, enroll_status) values (?,?,?)";
	
	public void enrollCourse(String userName, String courseCode) {
		try {
			String courseId = getCourseIDByCoursecode(courseCode);
			String enrollStatus = checkDupliateCourseEnroll(courseId, userName);
			if(enrollStatus == null || enrollStatus.equals(OnlineCSRoomConstants.REJECTED)) {
				PreparedStatement ps = getDBConnection().prepareStatement(insertEnrollCourse);
				ps.setString(1, courseId);
				ps.setString(2, userName);
				ps.setString(3, OnlineCSRoomConstants.PENDING);
				
				ps.execute();
				System.out.println(ps.toString());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String checkDupliateCourseEnroll(String courseId, String loginName) {
		String enrollStatus = null;
		try {
			
			PreparedStatement ps = getDBConnection().prepareStatement(getEnrolledCourse);
			ps.setString(1, courseId);
			ps.setString(2, loginName);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				enrollStatus = rs.getString("enroll_status");
			}
			System.out.println(ps.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return enrollStatus;
	}
	
	public String getCourseIDByCoursecode(String courseCode) {
		String courseId = null;
		try {
			PreparedStatement ps = getDBConnection().prepareStatement(getCourseId);
			ps.setString(1, courseCode);
			
			ResultSet rs = ps.executeQuery();
			System.out.println(ps.toString());
			if(rs.next()) {
				courseId = rs.getString("CourseID");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return courseId;
	}
}
