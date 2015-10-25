package com.ntu.learn.inetprog.model;

import java.io.Serializable;

/**
 * 
 * @author shankar
 *
 */
public class UserType implements Serializable{
	private String profileInfo;
	private String userType;
	public String getProfileInfo() {
		return profileInfo;
	}
	public void setProfileInfo(String profileInfo) {
		this.profileInfo = profileInfo;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	

}
