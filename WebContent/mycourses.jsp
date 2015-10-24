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
				<ul class="top-nav">
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
			<h3>My Courses</h3>
			<div id="port" class="container portfolio-main">
				<div>
					<c:if test="${not empty message }">
						<span style="color: red;">${message }</span>
					</c:if>
				</div>
				<div id="portfoliolist">
				<c:forEach var="courses" items="${lstCourses }">
					<div class="portfolio logo1 mix_all" data-cat="logo"
						style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">
							<a data-toggle="modal" data-target=".bs-example-modal-md"
								href="#" class="b-link-stripe b-animate-go  thickbox"> <img
								class="p-img" src="images/p3.jpg" />
							</a>
						</div>
						<div class="port-info">
							<h4>
								<a href="MyCoursesServlet?courseCode=${courses.courseCode }">${courses.courseTitle }</a>
							</h4>

						</div>
					</div>
					</c:forEach>
				</div>
				<div class="clearfix"></div>
			</div>
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
