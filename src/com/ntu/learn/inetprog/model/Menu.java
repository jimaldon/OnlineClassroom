package com.ntu.learn.inetprog.model;

import java.io.Serializable;

/**
 * 
 * @author shankara
 *
 */
public class Menu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String menuURL;
	
	private String menuName;

	public Menu(String menuURL, String menuName) {
		this.menuURL = menuURL;
		this.menuName = menuName;
	}
	
	public String getMenuURL() {
		return menuURL;
	}

	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	

}
