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
			<h3>My Profile</h3>
			<!----start-portfolio---->
			<br>
			<c:if test="${not empty message }">
				<span style="color: red;"> ${message} </span>
			</c:if>
			<form action="MyProfileServlet" method="post">
				<c:if test="${not empty profile}">
					<div id="port" class="container portfolio-main">
						<table>
							<tr>
								<td class="td">Display Name</td>
								<td class="td"><input type="text" name="displayName"
									value="${profile.firstName }" style="width: 392.22222px;" /></td>
							</tr>
							<tr>
								<td class="td">Last Name</td>
								<td class="td"><input type="text" name="lastName"
									value="${profile.lastName }" style="width: 392.22222px;" /></td>
							</tr>
							<tr>
								<td class="td">Gender</td>
								<td class="td"><input type="radio" name="gender" value="M"
									${profile.gender == 'M' ? 'checked' : ''}> <b> Male
								</b> &nbsp; <input type="radio" name="gender" value="F"
									${profile.gender == 'F' ? 'checked' : ''}> <b>
										Female </b> &nbsp; <input type="radio" name="gender" value="NA"
									${profile.gender == 'NA' ? 'checked' : ''} /> <b> I'd
										rather not say </b></td>
							</tr>
							<tr>
								<td class="td">About Me</td>
								<td class="td"><textarea
										style="margin: 0px; width: 391px; height: 89px;"
										name="aboutMe"> ${profile.aboutMe}</textarea></td>
							</tr>
							<tr>
								<td class="td">Birthday</td>
								<td class="td"><select name="month">
										<option value="-1" ${profile.bMonth == '' ? 'selected' : ''}>Month</option>
										<option value="1" ${profile.bMonth == '1' ? 'selected' : ''}>January</option>
										<option value="2" ${profile.bMonth == '2' ? 'selected' : ''}>February</option>
										<option value="3" ${profile.bMonth == '3' ? 'selected' : ''}>March</option>
										<option value="4" ${profile.bMonth == '4' ? 'selected' : ''}>April</option>
										<option value="5" ${profile.bMonth == '5' ? 'selected' : ''}>May</option>
										<option value="6" ${profile.bMonth == '6' ? 'selected' : ''}>June</option>
										<option value="7" ${profile.bMonth == '7' ? 'selected' : ''}>July</option>
										<option value="8" ${profile.bMonth == '8' ? 'selected' : ''}>August</option>
										<option value="9" ${profile.bMonth == '9' ? 'selected' : ''}>September</option>
										<option value="10" ${profile.bMonth == '10' ? 'selected' : ''}>October</option>
										<option value="11" ${profile.bMonth == '11' ? 'selected' : ''}>November</option>
										<option value="12" ${profile.bMonth == '12' ? 'selected' : ''}>December</option>
								</select> &nbsp; <select name="date"><option value="-1">Day</option>
										<option value="1" ${profile.bMonth == '1' ? 'selected' : ''}>1</option>
										<option value="2" ${profile.bMonth == '2' ? 'selected' : ''}>2</option>
										<option value="3" ${profile.bMonth == '3' ? 'selected' : ''}>3</option>
										<option value="4" ${profile.bMonth == '4' ? 'selected' : ''}>4</option>
										<option value="5" ${profile.bMonth == '5' ? 'selected' : ''}>5</option>
										<option value="6" ${profile.bMonth == '6' ? 'selected' : ''}>6</option>
										<option value="7" ${profile.bMonth == '7' ? 'selected' : ''}>7</option>
										<option value="8" ${profile.bMonth == '8' ? 'selected' : ''}>8</option>
										<option value="9" ${profile.bMonth == '9' ? 'selected' : ''}>9</option>
										<option value="10" ${profile.bMonth == '10' ? 'selected' : ''}>10</option>
										<option value="11" ${profile.bMonth == '11' ? 'selected' : ''}>11</option>
										<option value="12" ${profile.bMonth == '12' ? 'selected' : ''}>12</option>
										<option value="13" ${profile.bMonth == '13' ? 'selected' : ''}>13</option>
										<option value="14" ${profile.bMonth == '14' ? 'selected' : ''}>14</option>
										<option value="15" ${profile.bMonth == '15' ? 'selected' : ''}>15</option>
										<option value="16" ${profile.bDate == '16' ? 'selected' : ''}>16</option>
										<option value="17" ${profile.bMonth == '17' ? 'selected' : ''}>17</option>
										<option value="18" ${profile.bMonth == '18' ? 'selected' : ''}>18</option>
										<option value="19" ${profile.bMonth == '19' ? 'selected' : ''}>19</option>
										<option value="20" ${profile.bMonth == '20' ? 'selected' : ''}>20</option>
										<option value="21" ${profile.bMonth == '21' ? 'selected' : ''}>21</option>
										<option value="22" ${profile.bMonth == '22' ? 'selected' : ''}>22</option>
										<option value="23" ${profile.bMonth == '23' ? 'selected' : ''}>23</option>
										<option value="24" ${profile.bMonth == '24' ? 'selected' : ''}>24</option>
										<option value="25" ${profile.bMonth == '25' ? 'selected' : ''}>25</option>
										<option value="26" ${profile.bMonth == '26' ? 'selected' : ''}>26</option>
										<option value="27" ${profile.bMonth == '27' ? 'selected' : ''}>27</option>
										<option value="28" ${profile.bMonth == '28' ? 'selected' : ''}>28</option>
										<option value="29" ${profile.bMonth == '29' ? 'selected' : ''}>29</option>
										<option value="30" ${profile.bMonth == '30' ? 'selected' : ''}>30</option>
										<option value="31" ${profile.bMonth == '31' ? 'selected' : ''}>31</option></select>
									&nbsp; <select name="year"><option value="-1">Year</option>
										<option value="1999"
											${profile.bYear == '1999' ? 'selected' : ''}>1999</option>
										<option value="1998"
											${profile.bYear == '1998' ? 'selected' : ''}>1998</option>
										<option value="1997"
											${profile.bYear == '1997' ? 'selected' : ''}>1997</option>
										<option value="1996"
											${profile.bYear == '1996' ? 'selected' : ''}>1996</option>
										<option value="1995"
											${profile.bYear == '1995' ? 'selected' : ''}>1995</option>
										<option value="1994"
											${profile.bYear == '1994' ? 'selected' : ''}>1994</option>
										<option value="1993"
											${profile.bYear == '1993' ? 'selected' : ''}>1993</option>
										<option value="1992"
											${profile.bYear == '1992' ? 'selected' : ''}>1992</option>
										<option value="1991"
											${profile.bYear == '1991' ? 'selected' : ''}>1991</option>
										<option value="1990"
											${profile.bYear == '1990' ? 'selected' : ''}>1990</option>
										<option value="1989"
											${profile.bYear == '1989' ? 'selected' : ''}>1989</option>
										<option value="1988"
											${profile.bYear == '1988' ? 'selected' : ''}>1988</option>
										<option value="1987">1987</option>
										<option value="1986">1986</option>
										<option value="1985">1985</option>
										<option value="1984">1984</option>
										<option value="1983">1983</option>
										<option value="1982">1982</option>
										<option value="1981">1981</option>
										<option value="1980">1980</option>
										<option value="1979">1979</option>
										<option value="1978">1978</option>
										<option value="1977">1977</option>
										<option value="1976">1976</option>
										<option value="1975">1975</option>
										<option value="1974">1974</option>
										<option value="1973">1973</option>
										<option value="1972">1972</option>
										<option value="1971">1971</option>
										<option value="1970">1970</option>
										<option value="1969">1969</option>
										<option value="1968">1968</option>
										<option value="1967">1967</option>
										<option value="1966">1966</option>
										<option value="1965">1965</option>
										<option value="1964">1964</option>
										<option value="1963">1963</option>
										<option value="1962">1962</option>
										<option value="1961">1961</option>
										<option value="1960">1960</option>
										<option value="1959">1959</option>
										<option value="1958">1958</option>
										<option value="1957">1957</option>
										<option value="1956">1956</option>
										<option value="1955">1955</option>
										<option value="1954">1954</option>
										<option value="1953">1953</option>
										<option value="1952">1952</option>
										<option value="1951">1951</option>
										<option value="1950">1950</option>
										<option value="1949">1949</option>
										<option value="1948">1948</option>
										<option value="1947">1947</option>
										<option value="1946">1946</option>
										<option value="1945">1945</option>
										<option value="1944">1944</option>
										<option value="1943">1943</option>
										<option value="1942">1942</option>
										<option value="1941">1941</option>
										<option value="1940">1940</option>
										<option value="1939">1939</option>
										<option value="1938">1938</option>
										<option value="1937">1937</option>
										<option value="1936">1936</option>
										<option value="1935">1935</option>
										<option value="1934">1934</option>
										<option value="1933">1933</option>
										<option value="1932">1932</option>
										<option value="1931">1931</option>
										<option value="1930">1930</option>
										<option value="1929">1929</option>
										<option value="1928">1928</option>
										<option value="1927">1927</option>
										<option value="1926">1926</option>
										<option value="1925">1925</option>
										<option value="1924">1924</option>
										<option value="1923">1923</option>
										<option value="1922">1922</option>
										<option value="1921">1921</option>
										<option value="1920">1920</option>
										<option value="1919">1919</option>
										<option value="1918">1918</option>
										<option value="1917">1917</option>
										<option value="1916">1916</option>
										<option value="1915">1915</option>
										<option value="1914">1914</option>
										<option value="1913">1913</option>
										<option value="1912">1912</option>
										<option value="1911">1911</option>
										<option value="1910">1910</option>
										<option value="1909">1909</option>
										<option value="1908">1908</option>
										<option value="1907">1907</option>
										<option value="1906">1906</option>
										<option value="1905">1905</option>
										<option value="1904">1904</option>
										<option value="1903">1903</option>
										<option value="1902">1902</option>
										<option value="1901">1901</option></select></td>
							</tr>
							<tr>
								<td class="td">Address</td>
								<td class="td"><textarea
										style="margin: 0px; width: 391px; height: 89px;"
										name="address">${profile.address }</textarea>
							</tr>
							<tr>
								<td class="td">Country</td>
								<td class="td"><input type="text" name="country"
									value="${profile.country}" style="width: 392.22222px;" /></td>
							</tr>
							<tr>
								<td class="td">Postal Code</td>
								<td class="td"><input type="text" name="postalCode"
									value="${profile.postalCode }" style="width: 392.22222px;" /></td>
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

								<td class="td" colspan="2" align="center"><input
									type="submit" value="Save" class="artbtn artbtn1"> <input
									type="button" value="Back" class="artbtn artbtn1" onclick="location.href='LoginServlet'"></td>
							</tr>
						</table>

					</div>
				</c:if>
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
