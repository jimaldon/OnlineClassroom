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
	<c:if test="${not selectedCourse}">
		<div id="services" class="services">
			<div class="container">
				<h3>Services</h3>
				<!----start-servicves-list---->
				<div class="services-list text-center">
					<ul class="list-unstyled list-inline">


						<li><a href="FindCoursesServlet?course=database"><span
								class="service-icon4"> </span> <label>Database</label> </a></li>

						<li><a href="FindCoursesServlet?course=technology"><span
								class="service-icon6"> </span> <label>Technology</label> </a></li>
					</ul>
				</div>
				<!----//End-servicves-list---->
			</div>
		</div>
	</c:if>

	<c:if test="${selectedCourse }">
		<div id="blog" class="blog">
			<div class="container">
				<h3><%=request.getParameter("course") %></h3>

				<!---->
				<div class="col-md-4 artical-row2">
					<!----start-artical-info---->
					<div class="artical-info">
						<div class="post-head post-head1">
							<div class="post-head-left">
								<h4>
									<a href="#">This is blog post title</a>
								</h4>
								<p class="author">
									By <a href="#"> Amine Fessi</a>
								</p>

							</div>
							<div class="post-head-right post-head-right-C">
								<span>4</span> <label>August 2015</label>
							</div>
							<div class="clearfix"></div>
						</div>
						<p class="post-text">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Phasellus laoreet turpis a nibh feugiat, nec
							viverra arcu lacinia. Praesent facilisis diam eget velit
							tristique, a commodo elit porttitor. Mauris ac pretium ligula.
							Nam ultricies metus eu semper rutrum. Pellentesque tortor nulla.</p>
						<div class="post-bottom">
							<div class="post-bottom-left">
								<p>
									<a href="#">10 Comments</a> | <a href="#"><i
										class="fa fa-heart"> </i> 151</a>
								</p>
							</div>
							<div class="post-bottom-right">
								<a class="artbtn artbtn1" href="#">Read More</a>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-md-4 artical-row2">
					<!----start-artical-info---->

					<!----//End-artical-info---->
					<!----start-artical-info---->
					<div class="artical-info">
						<div class="post-head post-head1">
							<div class="post-head-left">
								<h4>
									<a href="#">This is blog post title</a>
								</h4>
								<p class="author">
									By <a href="#"> Amine Fessi</a>
								</p>
							</div>
							<div class="post-head-right post-head-right-C">
								<span>4</span> <label>August 2015</label>
							</div>
							<div class="clearfix"></div>
						</div>
						<p class="post-text">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Phasellus laoreet turpis a nibh feugiat, nec
							viverra arcu lacinia. Praesent facilisis diam eget velit
							tristique, a commodo elit porttitor. Mauris ac pretium ligula.
							Nam ultricies metus eu semper rutrum. Pellentesque tortor nulla.</p>
						<div class="post-bottom">
							<div class="post-bottom-left">
								<p>
									<a href="#">10 Comments</a> | <a href="#"><i
										class="fa fa-heart"> </i> 151</a>
								</p>
							</div>
							<div class="post-bottom-right">
								<a class="artbtn artbtn1" href="#">Read More</a>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
					<!----//End-artical-info---->
				</div>
				<div class="col-md-4 artical-row2">
					<!----start-artical-info---->

					<!----//End-artical-info---->
					<!----start-artical-info---->
					<div class="artical-info">
						<div class="post-head post-head1">
							<div class="post-head-left">
								<h4>
									<a href="#">This is blog post title</a>
								</h4>
								<p class="author">
									By <a href="#"> Amine Fessi</a>
								</p>
							</div>
							<div class="post-head-right post-head-right-C">
								<span>4</span> <label>August 2015</label>
							</div>
							<div class="clearfix"></div>
						</div>
						<p class="post-text">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Phasellus laoreet turpis a nibh feugiat, nec
							viverra arcu lacinia. Praesent facilisis diam eget velit
							tristique, a commodo elit porttitor. Mauris ac pretium ligula.
							Nam ultricies metus eu semper rutrum. Pellentesque tortor nulla.</p>
						<div class="post-bottom">
							<div class="post-bottom-left">
								<p>
									<a href="#">10 Comments</a> | <a href="#"><i
										class="fa fa-heart"> </i> 151</a>
								</p>
							</div>
							<div class="post-bottom-right">
								<a class="artbtn artbtn1" href="#">Read More</a>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
					<!----//End-artical-info---->
				</div>
			</div>
		</div>
	</c:if>

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
