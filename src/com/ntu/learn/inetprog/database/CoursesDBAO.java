package com.ntu.learn.inetprog.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ntu.learn.inetprog.model.Courses;

public class CoursesDBAO extends DatabaseUtil {

	String getAllCourseByCategorySql = "select CourseCode, Title, shortDescription, course_Month, course_Date, course_year, comments, likes, author from courses co join course_category cc on co.coursecategoryid = cc.categoryId where upper(cc.description) = ? ";

	String getAllCourseByUserSql = "select CourseCode, Title, shortDescription, course_Month, course_Date, course_year, comments, likes, author from courses co join course_enrolls ce on co.CourseID = ce.CourseID where  upper(ce.LoginName) = ? ";

	String getCourseByCourseId = " select co.CourseCode, co.Title, co.shortDescription, "
			+ "co.course_Month, co.course_Date, co.course_year, co.comments, co.likes, co.author , "
			+ "cc.AboutCourse, cc.Syllabus, cc.VideoURL from courses co join course_contents cc on co.CourseCode = cc.CourseCode "
			+ "where upper(co.CourseCode) = ?";
	
	public List<Courses> getAllCourseByCategory(String categoryName) {
		try {

			PreparedStatement prepStmt = getDBConnection().prepareStatement(
					getAllCourseByCategorySql);
			prepStmt.setString(1, categoryName);
			ResultSet rs = prepStmt.executeQuery();

			List<Courses> lstCourses = new ArrayList<Courses>();

			while (rs.next()) {
				Courses course = new Courses();
				course.setCourseCode(rs.getString("CourseCode"));
				course.setCourseTitle(rs.getString("Title"));
				course.setCourseShortDesc(rs.getString("shortDescription"));
				course.setCourseYear(rs.getString("course_year"));
				course.setCourseDate(rs.getString("course_Date"));
				course.setCourseMonth(rs.getString("course_Month"));
				course.setComments(rs.getString("comments"));
				course.setLikes(rs.getString("likes"));
				course.setAuthor(rs.getString("author"));
				lstCourses.add(course);
			}

			return lstCourses;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Courses> getAllCourseByUserName(String userName) {
		try {
			PreparedStatement prepStmt = getDBConnection().prepareStatement(
					getAllCourseByUserSql);
			prepStmt.setString(1, userName);
			ResultSet rs = prepStmt.executeQuery();
			System.out.println("=== SQL Firing to Database " + getAllCourseByUserSql);
			System.out.println("=== SQL Parameters " + userName);
			List<Courses> lstCourses = new ArrayList<Courses>();

			while (rs.next()) {
				Courses course = new Courses();
				course.setCourseCode(rs.getString("CourseCode"));
				course.setCourseTitle(rs.getString("Title"));
				course.setCourseShortDesc(rs.getString("shortDescription"));
				course.setCourseYear(rs.getString("course_year"));
				course.setCourseDate(rs.getString("course_Date"));
				course.setCourseMonth(rs.getString("course_Month"));
				course.setComments(rs.getString("comments"));
				course.setLikes(rs.getString("likes"));
				course.setAuthor(rs.getString("author"));
				lstCourses.add(course);
			}

			return lstCourses;

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Courses getCourseByCourseId(String courseCode) {
		try {
			PreparedStatement prepStmt = getDBConnection().prepareStatement(
					getCourseByCourseId);
			prepStmt.setString(1, courseCode);
			System.out.println(" SQL Going to Fire "+prepStmt.toString());
			ResultSet rs = prepStmt.executeQuery();
			Courses course = new Courses();
			if (rs.next()) {
				course.setCourseCode(rs.getString("CourseCode"));
				course.setCourseTitle(rs.getString("Title"));
				course.setCourseShortDesc(rs.getString("shortDescription"));
				course.setCourseYear(rs.getString("course_year"));
				course.setCourseDate(rs.getString("course_Date"));
				course.setCourseMonth(rs.getString("course_Month"));
				course.setComments(rs.getString("comments"));
				course.setLikes(rs.getString("likes"));
				course.setAuthor(rs.getString("author"));
				String syllabus = rs.getString("Syllabus");
				syllabus = syllabus.replace("\n", "<br>");
				course.setCourseSyallbus(syllabus);
				course.setAboutCourse(rs.getString("AboutCourse"));
				course.setVideoURL(rs.getString("VideoURL"));
			}
			
			
			
			return course;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
