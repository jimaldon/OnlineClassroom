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
			<div id="port" class="container portfolio-main">
				<table>
					<tr>
						<td class="td">Display Name</td>
						<td class="td"><input type="text" name="displayName"
							style="width: 392.22222px;" /></td>
					</tr>
					<tr>
						<td class="td">Location</td>
						<td class="td"><input type="text" name="location"
							style="width: 392.22222px;" /></td>
					</tr>
					<tr>
						<td class="td">Gender</td>
						<td class="td"><input type="radio" name="gender" value="MALE">
							<b> Male </b> &nbsp; <input type="radio" name="gender"
							value="FEMALE"> <b> Female </b> &nbsp; <input
							type="radio" name="gender" value="NA" /> <b> I'd rather not
								say </b></td>
					</tr>
					<tr>
						<td class="td">About Me</td>
						<td class="td"><textarea
								style="margin: 0px; width: 391px; height: 89px;" name="aboutMe"></textarea>
						</td>
					</tr>
					<tr>
						<td class="td">Birthday</td>
						<td class="td"><select name="month">
								<option value="-1">Month</option>
								<option value="1">January</option>
								<option value="2">February</option>
								<option value="3">March</option>
								<option value="4">April</option>
								<option value="5">May</option>
								<option value="6">June</option>
								<option value="7">July</option>
								<option value="8">August</option>
								<option value="9">September</option>
								<option value="10">October</option>
								<option value="11">November</option>
								<option value="12">December</option>
						</select> &nbsp; <select name="day"><option value="-1">Day</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
								<option value="19">19</option>
								<option value="20">20</option>
								<option value="21">21</option>
								<option value="22">22</option>
								<option value="23">23</option>
								<option value="24">24</option>
								<option value="25">25</option>
								<option value="26">26</option>
								<option value="27">27</option>
								<option value="28">28</option>
								<option value="29">29</option>
								<option value="30">30</option>
								<option value="31">31</option></select> &nbsp; <select name="year"><option
									value="-1">Year</option>
								<option value="1999">1999</option>
								<option value="1998">1998</option>
								<option value="1997">1997</option>
								<option value="1996">1996</option>
								<option value="1995">1995</option>
								<option value="1994">1994</option>
								<option value="1993">1993</option>
								<option value="1992">1992</option>
								<option value="1991">1991</option>
								<option value="1990">1990</option>
								<option value="1989">1989</option>
								<option value="1988">1988</option>
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
						<td class="td" colspan="2" align="center">
							<input type="submit" value="Save" class="artbtn artbtn1">
							
						</td>
					</tr>
				</table>

			</div>
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
