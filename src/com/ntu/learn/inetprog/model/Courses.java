package com.ntu.learn.inetprog.model;

import java.io.Serializable;

public class Courses implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String courseCode;
	
	private String courseTitle;
	
	private String courseShortDesc;
	
	private String courseMonth;
	
	private String courseDate;
	
	private String courseYear;
	
	private String comments;
	
	private String likes;
	
	private String author;

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
}
