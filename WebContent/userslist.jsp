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


		<div id="blog" class="blog">
			<div class="container">
				<h3>Users List</h3>

	<form action="MyProfileServlet" method="post">

		<table>
		<tr>
		<td> <img class="p-img" src="images/adduser.png" alt="Add User"> <a href="AddUsersServlet?userTypeId=${usertype}"> Add New User</a>
		</td>
		</tr>
		</table>
		<table border="1" style="width:100%">
		<caption>Users List</caption>
		
			<tr>
			    <th>Login Name</th>
			    <th>First Name</th>		
			    <th>Last Name</th>
			    <th>User Type</th>
			    <th>Telephone</th>
			    <th>Email</th>
			    <th>Postal Code</th>
	  		</tr>
			<c:forEach items="${listofusers}" var="user">
			<tr>
				<td>
				<a href="UserProfileServlet?userLoginName=${user.loginName}"
							
							class="scroll" style="width: 200px; height: 50px;">${user.loginName}</a>
				</td>
				<td>
				${user.firstName}
				</td>
				<td>
			    ${user.lastName}
				</td>
				<td style="text-align:center">
			    ${user.typeOfUser}
				</td>
				<td style="text-align:center">
				${user.telephone}
				</td>	
				<td>
				${user.email}
				</td>
				<td style="text-align:center">
				${user.postalCode}
				</td>		
			</tr>
			</c:forEach>
							
		</table>
</form>
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
