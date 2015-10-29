<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Online Class Room</title>

<script src="js/jquery.min.js"></script>

<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/testmonial.css" />
<link rel="stylesheet" type="text/css" href="css/theme-style.css" />
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />

</head>
<body>

	<div id="home" class="header scroll">
		<div class="container"
			style="padding-left: 0px; padding-right: 0px; margin-left: 100px; margin-right: 0px; width: 1500px;">
			<div class="logo" title="logo"></div>
			<nav class="top-nav">
				<ul class="top-nav" style="width: 1000px;">
					<c:forEach items="${lstMenu}" var="menu">
						<li class="page-scroll"><a href=${menu.menuURL
							}
							class="scroll" style="width: 200px; height: 50px;">${menu.menuName}</a></li>
					</c:forEach>
				</ul>
				<a href="#" id="pull"></a>
			</nav>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="clearfix"></div>

	<div id="port" class="portfolio portfolio-box">
		<div class="container">
			<c:if test="${not editCourse }">
				<h3>Add Course</h3>
			</c:if>
			<c:if test="${editCourse }">
				<h3>Edit Course</h3>
			</c:if>
			<!----start-portfolio---->
			<br>
			<c:if test="${not empty message }">
				<span style="color: red;"> ${message} </span>
			</c:if>
			<form action="AddEditCourseServlet" method="post">
				<div id="port" class="container portfolio-main">
					<table>
						<tr>
							<td class="td">Course Title</td>
							<td class="td"><input type="text" name="courseTitle"
								value="${course.courseTitle }" style="width: 392.22222px;" /></td>
						</tr>
						<tr>
							<td class="td">Course Category</td>
							<td class="td"><select name="courseCategory">
									<option value="database"
										${course.courseCategory == '1' ? 'selected' : ''}>Database</option>
									<option value="technology"
										${course.courseCategory == '2' ? 'selected' : ''}>Technology</option>
							</select></td>
						</tr>
						<tr>
							<td class="td">Short Description</td>
							<td class="td"><textarea
									style="margin: 0px; width: 900px; height: 150px;"
									name="shortDesc"> ${course.courseShortDesc}</textarea></td>
						</tr>
						<tr>
							<td class="td">About Course</td>
							<td class="td"><textarea
									style="margin: 0px; width: 900px; height: 200px;"
									name="aboutCourse"> ${course.aboutCourse}</textarea></td>
						</tr>
						<tr>
							<td class="td">Creation Date</td>
							<td class="td"><select name="month">
									<option value="-1" ${course.courseMonth == '' ? 'selected' : ''}>Month</option>
									<option value="January"
										${course.courseMonth == 'January' ? 'selected' : ''}>January</option>
									<option value="February"
										${course.courseMonth == 'February' ? 'selected' : ''}>February</option>
									<option value="March"
										${course.courseMonth == 'March' ? 'selected' : ''}>March</option>
									<option value="April"
										${course.courseMonth == 'April' ? 'selected' : ''}>April</option>
									<option value="May"
										${course.courseMonth == 'May' ? 'selected' : ''}>May</option>
									<option value="June"
										${course.courseMonth == 'June' ? 'selected' : ''}>June</option>
									<option value="July"
										${course.courseMonth == 'July' ? 'selected' : ''}>July</option>
									<option value="August"
										${course.courseMonth == 'August' ? 'selected' : ''}>August</option>
									<option value="September"
										${course.courseMonth == 'September' ? 'selected' : ''}>September</option>
									<option value="October"
										${course.courseMonth == 'October' ? 'selected' : ''}>October</option>
									<option value="November"
										${course.courseMonth == 'November' ? 'selected' : ''}>November</option>
									<option value="December"
										${course.courseMonth == 'December' ? 'selected' : ''}>December</option>
							</select> &nbsp; <select name="date"><option value="-1">Day</option>
									<option value="1" ${course.courseMonth == '1' ? 'selected' : ''}>1</option>
									<option value="2" ${course.courseMonth == '2' ? 'selected' : ''}>2</option>
									<option value="3" ${course.courseMonth == '3' ? 'selected' : ''}>3</option>
									<option value="4" ${course.courseMonth == '4' ? 'selected' : ''}>4</option>
									<option value="5" ${course.courseMonth == '5' ? 'selected' : ''}>5</option>
									<option value="6" ${course.courseMonth == '6' ? 'selected' : ''}>6</option>
									<option value="7" ${course.courseMonth == '7' ? 'selected' : ''}>7</option>
									<option value="8" ${course.courseMonth == '8' ? 'selected' : ''}>8</option>
									<option value="9" ${course.courseMonth == '9' ? 'selected' : ''}>9</option>
									<option value="10" ${course.courseMonth == '10' ? 'selected' : ''}>10</option>
									<option value="11" ${course.courseMonth == '11' ? 'selected' : ''}>11</option>
									<option value="12" ${course.courseMonth == '12' ? 'selected' : ''}>12</option>
									<option value="13" ${course.courseMonth == '13' ? 'selected' : ''}>13</option>
									<option value="14" ${course.courseMonth == '14' ? 'selected' : ''}>14</option>
									<option value="15" ${course.courseMonth == '15' ? 'selected' : ''}>15</option>
									<option value="16" ${course.courseMonth == '16' ? 'selected' : ''}>16</option>
									<option value="17" ${course.courseMonth == '17' ? 'selected' : ''}>17</option>
									<option value="18" ${course.courseMonth == '18' ? 'selected' : ''}>18</option>
									<option value="19" ${course.courseMonth == '19' ? 'selected' : ''}>19</option>
									<option value="20" ${course.courseMonth == '20' ? 'selected' : ''}>20</option>
									<option value="21" ${course.courseMonth == '21' ? 'selected' : ''}>21</option>
									<option value="22" ${course.courseMonth == '22' ? 'selected' : ''}>22</option>
									<option value="23" ${course.courseMonth == '23' ? 'selected' : ''}>23</option>
									<option value="24" ${course.courseMonth == '24' ? 'selected' : ''}>24</option>
									<option value="25" ${course.courseMonth == '25' ? 'selected' : ''}>25</option>
									<option value="26" ${course.courseMonth == '26' ? 'selected' : ''}>26</option>
									<option value="27" ${course.courseMonth == '27' ? 'selected' : ''}>27</option>
									<option value="28" ${course.courseMonth == '28' ? 'selected' : ''}>28</option>
									<option value="29" ${course.courseMonth == '29' ? 'selected' : ''}>29</option>
									<option value="30" ${course.courseMonth == '30' ? 'selected' : ''}>30</option>
									<option value="31" ${course.courseMonth == '31' ? 'selected' : ''}>31</option></select>
								&nbsp; <select name="year"><option value="-1">Year</option>
									<option value="2015"
										${course.courseYear == '2015' ? 'selected' : ''}>2015</option>
									<option value="2014"
										${course.courseYear == '2014' ? 'selected' : ''}>2014</option>
									<option value="courseYear"
										${course.courseYear == '2013' ? 'selected' : ''}>2013</option>

							</select></td>
						</tr>
						<tr>
							<td class="td">Course Syllabus</td>
							<td class="td"><textarea
									style="margin: 0px; width: 900px; height: 695px;"
									name="courseSyllabus">${course.courseSyallbus }</textarea>
						</tr>

						<tr>

							<td class="td" colspan="2" align="center">
										<c:if test="${not editCourse }">
							<input type="submit" value="Save" class="artbtn artbtn1"> 
							</c:if>
										<c:if test="${editCourse }">
										<input type="button" value="Update" class="artbtn artbtn1" onclick="location.href='AddEditCourseServlet?updateCourse=${course.courseCode}'"> 
										</c:if>
							<input type="button" value="Back" class="artbtn artbtn1"
								onclick="location.href='home.jsp'"></td>
						</tr>
					</table>

				</div>
			</form>
		</div>
		<div class="clearfix"></div>
	</div>

	<div class="clearfix"></div>

	<div class="copy-right">
		<div class="container">
			<p>
				Copyright &copy; 2014.Company name All rights reserved.<a
					target="_blank" href="#"></a>
			</p>

		</div>
	</div>
</body>
</html>
