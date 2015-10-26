package com.ntu.learn.inetprog.model;

import java.io.Serializable;
import java.util.List;

public class Courses implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String courseCode;
	
	private String courseId;
	
	private String courseTitle;
	
	private String courseShortDesc;
	
	private String courseMonth;
	
	private String courseDate;
	
	private String courseYear;
	
	private String comments;
	
	private String likes;
	
	private String author;
	
	private String aboutCourse;
	
	private String courseSyallbus;
	
	private String videoURL;
	
	private String courseCategory;
	
	private List<Comments> lstComments;

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseShortDesc() {
		return courseShortDesc;
	}

	public void setCourseShortDesc(String courseShortDesc) {
		this.courseShortDesc = courseShortDesc;
	}

	public String getCourseMonth() {
		return courseMonth;
	}

	public void setCourseMonth(String courseMonth) {
		this.courseMonth = courseMonth;
	}

	public String getCourseDate() {
		return courseDate;
	}

	public void setCourseDate(String courseDate) {
		this.courseDate = courseDate;
	}

	public String getCourseYear() {
		return courseYear;
	}

	public void setCourseYear(String courseYear) {
		this.courseYear = courseYear;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAboutCourse() {
		return aboutCourse;
	}

	public void setAboutCourse(String aboutCourse) {
		this.aboutCourse = aboutCourse;
	}

	public String getCourseSyallbus() {
		return courseSyallbus;
	}

	public void setCourseSyallbus(String courseSyallbus) {
		this.courseSyallbus = courseSyallbus;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseCategory() {
		return courseCategory;
	}

	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}

	public List<Comments> getLstComments() {
		return lstComments;
	}

	public void setLstComments(List<Comments> lstComments) {
		this.lstComments = lstComments;
	}
}
