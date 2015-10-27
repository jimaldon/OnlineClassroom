package com.ntu.learn.inetprog.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.ntu.learn.inetprog.model.Comments;

/**
 * 
 * @author shankar
 *
 */
public class OnlineCSUtil {

	public static List<JSONObject>  getCommentsJsonObj(List<Comments> lstComments) throws Exception {
		
		List<JSONObject> jsonCategories = new ArrayList<JSONObject>();

		JSONObject jsonCategory = null;

		for (Comments category : lstComments) {
		    jsonCategory = new JSONObject();
		    jsonCategory.put("name", category.getCommentedBy());
		    jsonCategory.put("comment", category.getCommentsValue());
		    jsonCategories.add(jsonCategory);
		}
		
		return jsonCategories;
	}
}
