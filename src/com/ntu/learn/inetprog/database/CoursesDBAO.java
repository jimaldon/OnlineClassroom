package com.ntu.learn.inetprog.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ntu.learn.inetprog.model.Comments;
import com.ntu.learn.inetprog.model.Courses;
import com.ntu.learn.inetprog.model.EnrolledCourseUsers;

public class CoursesDBAO extends DatabaseUtil {

	String getAllCourseByCategorySql = "select CourseCode, Title, shortDescription, course_Month, course_Date, course_year, comments, likes, author from courses co join course_category cc on co.coursecategoryid = cc.categoryId where upper(cc.description) = ? ";

	String getAllCourseByUserSql = "select CourseCode, Title, shortDescription, course_Month, course_Date, course_year, comments, likes, author from courses co join course_enrolls ce on co.CourseID = ce.CourseID where  upper(ce.LoginName) = ? and ce.enroll_status='A' ";

	String getCourseByCourseId = " select co.CourseCode, co.Title, co.shortDescription, "
			+ "co.course_Month, co.course_Date, co.course_year, co.comments, co.likes, co.author , "
			+ "cc.AboutCourse, cc.Syllabus, cc.VideoURL from courses co join course_contents cc on co.CourseCode = cc.CourseCode "
			+ "where upper(co.CourseCode) = ?";

	String getAllPendingEnrollment = "select up.LoginName, up.firstName,  co.title, co.courseID, co.courseCode, if(ce.enroll_status='P','Pending',ce.enroll_status) as  enroll_status ,co.author"
			+ " from course_enrolls ce join courses co on ce.CourseID = co.CourseID join users_profile up "
			+ "on up.loginName = ce.loginName where ce.enroll_status ='P' ";

	String updateEnrolledCourse = "update course_enrolls set enroll_status=? where loginName=? and courseId=?";

	String getMyClassCourses = "select co.title, cc.Description, co.CourseID , co.likes, co.CourseCode from courses co join course_category cc on co.CoursecategoryId = cc.categoryId  where upper(co.author) = ?";

	String updateComments = "update courses set comments = ? where courseCode = ?";

	String insertCourse = "insert into courses (CourseCode,Title,shortDescription,CourseCategoryId,course_month,course_Date,course_year,author) values (?,?,?,?,?,?,?,?)";

	String insertCourseContents = "insert into course_contents (CourseCode, AboutCourse, Syllabus) values (?,?,?)";

	String getCourseCategoryByName = "select categoryId from course_category where upper(Description) = ? ";

	public List<Courses> getAllCourseByCategory(String categoryName) {
		try {

			PreparedStatement prepStmt = getDBConnection().prepareStatement(getAllCourseByCategorySql);
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
			PreparedStatement prepStmt = getDBConnection().prepareStatement(getAllCourseByUserSql);
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

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Courses getCourseByCourseId(String courseCode, boolean replaceFlag) {
		try {
			PreparedStatement prepStmt = getDBConnection().prepareStatement(getCourseByCourseId);
			prepStmt.setString(1, courseCode);
			System.out.println(" SQL Going to Fire " + prepStmt.toString());
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
				if(course.getComments() != null) {
					course.setLstComments(parseJson(course.getComments()));
				}
				course.setLikes(rs.getString("likes"));
				course.setAuthor(rs.getString("author"));
				String syllabus = rs.getString("Syllabus");
				if(replaceFlag) {
					syllabus = syllabus.replace("\n", "<br>");
				}
				course.setCourseSyallbus(syllabus);
				course.setAboutCourse(rs.getString("AboutCourse"));
				course.setVideoURL(rs.getString("VideoURL"));
			}

			return course;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<EnrolledCourseUsers> getAllPendingEnrolledCourse() {
		try {
			PreparedStatement prepStmt = getDBConnection().prepareStatement(getAllPendingEnrollment);
			System.out.println(" SQL Going to Fire " + prepStmt.toString());
			ResultSet rs = prepStmt.executeQuery();

			List<EnrolledCourseUsers> lstEnrollment = new ArrayList<EnrolledCourseUsers>();
			while (rs.next()) {
				EnrolledCourseUsers enrolledUser = new EnrolledCourseUsers();
				enrolledUser.setCourseAuthor(rs.getString("author"));
				enrolledUser.setCourseStatus(rs.getString("enroll_status"));
				enrolledUser.setCourseTitle(rs.getString("title"));
				enrolledUser.setLoginName(rs.getString("LoginName"));
				enrolledUser.setUserName(rs.getString("firstName"));
				enrolledUser.setCourseCode(rs.getString("courseCode"));
				enrolledUser.setCourseId(rs.getString("courseID"));
				lstEnrollment.add(enrolledUser);
			}

			return lstEnrollment;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int approveOrRejectEnrolledCourse(String courseId, String userName, String action) {
		int status = 0;
		try {
			PreparedStatement prepStmt = getDBConnection().prepareStatement(updateEnrolledCourse);

			prepStmt.setString(1, action);
			prepStmt.setString(2, userName);
			prepStmt.setString(3, courseId);

			System.out.println(" SQL Going to Fire " + prepStmt.toString());

			status = prepStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<Courses> getMyClassCourses(String loginName) {
		try {
			PreparedStatement prepStmt = getDBConnection().prepareStatement(getMyClassCourses);

			prepStmt.setString(1, loginName);

			System.out.println(" SQL Going to Fire " + prepStmt.toString());

			ResultSet rs = prepStmt.executeQuery();
			List<Courses> lstCourses = new ArrayList<Courses>();
			while (rs.next()) {
				Courses course = new Courses();
				course.setCourseId(rs.getString("CourseID"));
				course.setCourseTitle(rs.getString("title"));
				course.setLikes(rs.getString("likes"));
				course.setCourseCategory(rs.getString("Description"));
				course.setCourseCode(rs.getString("CourseCode"));
				lstCourses.add(course);
			}
			return lstCourses;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateCourseComments(String comments, String courseCode) {
		int result = 0;
		try {
			PreparedStatement prepStmt = getDBConnection().prepareStatement(updateComments);

			prepStmt.setString(1, comments);
			prepStmt.setString(2, courseCode);

			System.out.println(" SQL Going to Fire " + prepStmt.toString());

			result = prepStmt.executeUpdate();

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * "insert into courses (CourseCode,Title,shortDescription,CourseCategoryId,course_month,course_Date,course_year,author) values (?,?,?,?,?,?,?,?)"
	 * ;
	 * "insert into course_contents (CourseCode, AboutCourse, Syllabus) values (?,?,?)"
	 * ;
	 * 
	 * @param course
	 * @return
	 */
	public Courses createNewCourse(Courses course) throws Exception {
		try {
			PreparedStatement prepStmt = getDBConnection().prepareStatement(insertCourse);

			prepStmt.setString(1, course.getCourseCode());
			prepStmt.setString(2, course.getCourseTitle());
			prepStmt.setString(3, course.getCourseShortDesc());
			prepStmt.setString(4, course.getCourseCategory());
			prepStmt.setString(5, course.getCourseMonth());
			prepStmt.setString(6, course.getCourseDate());
			prepStmt.setString(7, course.getCourseYear());
			prepStmt.setString(8, course.getAuthor());
			System.out.println(" === Firing SQL ==== " + prepStmt.toString());
			prepStmt.execute();
			
			PreparedStatement prepStmts = getDBConnection().prepareStatement(insertCourseContents);
			prepStmts.setString(1, course.getCourseCode());
			prepStmts.setString(2, course.getAboutCourse());
			prepStmts.setString(3, course.getCourseSyallbus());
			System.out.println(" === Firing SQL ==== " + prepStmts.toString());
			prepStmts.execute();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		return course;
	}

	public String getCourseCategoryId(String courseCategoryDesc) {
		String categoryId = null;
		try {
			PreparedStatement ps = getDBConnection().prepareStatement(getCourseCategoryByName);
			ps.setString(1, courseCategoryDesc);
			System.out.println(" === Firing SQL ==== " + ps.toString());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				categoryId = rs.getString("categoryId");
			}

			return categoryId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryId;
	}

	public List<Comments> parseJson(String jsonValue) {
		List<Comments> lstComments = new ArrayList<Comments>();
		try {
			jsonValue = jsonValue.replace("\\", "");
			System.out.println(jsonValue);
			final JSONObject obj = new JSONObject(jsonValue);
			final JSONArray geodata = obj.getJSONArray("comments");
			final int n = geodata.length();
			for (int i = 0; i < n; ++i) {
				Comments comment = new Comments();
				final JSONObject comments = geodata.getJSONObject(i);
				comment.setCommentedBy(comments.getString("name").toUpperCase());
				comment.setCommentsValue(comments.getString("comment"));
				lstComments.add(comment);
			}

			return lstComments;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lstComments;
	}
}