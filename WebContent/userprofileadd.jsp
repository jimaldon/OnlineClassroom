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
				<ul class="top-nav" style="
    width: 1000px;">
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
			<h3>User Profile - Create New UserProfile</h3>
			<!----start-portfolio---->
			<br>
			<c:if test="${not empty message }">
				<span style="color: red;"> ${message} </span>
			</c:if>
			<form action="AddUsersServlet" method="post">
				
					<div id="port" class="container portfolio-main">
						<table>
							<tr>
								<td class="td">Login Name</td>
								<td class="td"><input type="text" name="loginName" style="width: 392.22222px;" /></td>
							</tr>
							<tr>
								<td class="td">Password</td>
								<td class="td"><input type="text" name="password"
									 style="width: 392.22222px;" /></td>
							</tr>
							<tr>
								<td class="td">Display Name</td>
								<td class="td"><input type="text" name="displayName"
									 style="width: 392.22222px;" /></td>
							</tr>
							<tr>
								<td class="td">Last Name</td>
								<td class="td"><input type="text" name="lastName"
									 style="width: 392.22222px;" /></td>
							</tr>
						
							<tr>
								<td class="td">Address</td>
								<td class="td"><textarea
										style="margin: 0px; width: 391px; height: 89px;"
										name="address"></textarea>
							</tr>
							<tr>
								<td class="td">City</td>
								<td class="td"><textarea
										style="margin: 0px; width: 391px; height: 89px;"
										name="city"></textarea>
							</tr>
							<tr>
								<td class="td">Country</td>
								<td class="td"><input type="text" name="country"
									style="width: 392.22222px;" /></td>
							</tr>
							<tr>
								<td class="td">Postal Code</td>
								<td class="td"><input type="text" name="postalCode"
									 style="width: 392.22222px;" /></td>
							</tr>
							<tr>
								<td class="td">Telephone</td>
								<td class="td"><input type="text" name="telephone" 
									style="width: 392.22222px;" /></td>
							</tr>
							<tr>
								<td class="td">Email</td>
								<td class="td"><input type="text" name="emailId" 
									style="width: 392.22222px;" /></td>
							</tr>
							<tr>
								<td class="td">UserType</td>
								<td class="td"><input type="text" name="typeOfUser" 
									style="width: 392.22222px;" /></td>
							</tr>
							<tr>
								<td class="td">Is Deleted</td>
								<td class="td"><input type="text" name="isDeleted" 
									style="width: 392.22222px;" /></td>
							</tr>
							<tr>

								<td class="td" colspan="2" align="center"><input
									type="submit" value="Save" class="artbtn artbtn1"> <input
									type="button" value="Back" class="artbtn artbtn1" onclick="location.href='home.jsp'"></td>
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