<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List</title>
</head>
<body>
	<div id="home" class="header scroll">
		<div class="container"
			style="padding-left: 0px; padding-right: 0px; margin-left: 100px; margin-right: 0px; width: 1500px;">
			<div class="logo" title="logo"></div>
			<nav class="top-nav">
				<ul class="top-nav">
					<c:forEach items="${listofusers}" var="user">
						<li class="page-scroll"><a href=${user.loginName
							}
							class="scroll" style="width: 200px; height: 50px;">${user.loginName}</a></li>
					</c:forEach>
				</ul>
				<a href="#" id="pull"></a>
			</nav>
			<div class="clearfix"></div>
		</div>
	</div>
</body>
<form action="MyProfileServlet" method="post">
<table>
							<tr>
								<td class="td">Display Name</td>
								<td class="td"><input type="text" name="displayName"
									value="${profile.firstName }" style="width: 392.22222px;" /></td>
							</tr>
</table>
</form>
</html>