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
<link rel="stylesheet" type="text/css"
	href="css/font-awesome.min.css" />

</head>
<body>

	<div id="home" class="header scroll">
		<div class="container"
			style="padding-left: 0px; padding-right: 0px; margin-left: 100px; margin-right: 150px;">
			<div class="logo" title="logo"></div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="clearfix"></div>

	<div id="contact" class="contact">
		<div class="container">
			<h3>Login</h3>
			<div class="contact-grids">
				<div class="col-md-6 contact-grid-left">
					<form method="post" action="LoginServlet">

						<table>
							<tr>
								<td><input type="text" placeholder="User Name " name="userName"/></td>
							</tr>
							<tr>
								<td><input type="password" placeholder="Password " name="password"/></td>
							</tr>
						
							<tr>
								<td>
								<br><select name="userType">
										<option value="admin">Admin</option>
										<option value="staff">Staff</option>
										<option value="student">Student</option>
								</select></td>
							</tr>
						</table>
						<span class="submit-btn"> <input type="submit" value="Submit">
						</span>
					</form>
					<div class="clearfix"></div>
				</div>
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
