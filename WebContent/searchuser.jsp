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
				<h3>User Types</h3>

	<c:forEach var="usertype" items="${listofusertype }">
				<!---->
				<div class="col-md-4 artical-row2">
					<!----start-artical-info---->
					<div class="artical-info">
						<div class="post-head post-head1">
							<div class="post-head-left">
								<h4>
									<a href="FindUsersServlet?userTypeId=${usertype.userType }">${usertype.profileInfo }</a>	
								</h4>
								<p class="author">
									Type Id is <a href="#"> ${usertype.userType}</a>
								</p>

							</div>
							
							<div class="clearfix"></div>
						</div>
						
						<div class="post-bottom">
							
							<div class="post-bottom-right">
								<a class="artbtn artbtn1" href="FindUsersServlet?userTypeId=${usertype.userType }">Read More</a>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				
				</c:forEach>
			</div>
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
