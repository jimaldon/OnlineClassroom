package com.ntu.learn.inetprog.model;

import java.io.Serializable;

public class Comments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String commentedBy;
	
	private String commentsValue;

	public String getCommentedBy() {
		return commentedBy;
	}

	public void setCommentedBy(String commentedBy) {
		this.commentedBy = commentedBy;
	}

	public String getCommentsValue() {
		return commentsValue;
	}

	public void setCommentsValue(String commentsValue) {
		this.commentsValue = commentsValue;
	}
}
