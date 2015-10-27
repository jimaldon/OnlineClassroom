function initRequest() {
	if (window.XMLHttpRequest) {
		return new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		isIE = true;
		return new ActiveXObject("Microsoft.XMLHTTP");
	}
}

function approveOrRejectEnrolledCourse(loginName, courseCode, action, elementid) {

	var url = "AdminCoursesServlet?loginName=" + loginName + "&courseCode="
			+ courseCode + "&action=" + action;
	var req = initRequest();
	req.onreadystatechange = function() {
		if (req.readyState == 4 && req.status == 200) {
			console.log(req.responseText);
			document.getElementById(elementid).innerHTML = req.responseText;
		}
	};
	req.open("GET", url, true);
	req.send(null);
}

function addComments(courseCode) {

	var comment = document.getElementById('comment').value;
	var url = "MyClassServlet?comments=" + comment + "&&courseCode="
			+ courseCode;
	var html = "<table>";

	var req = initRequest();
	req.onreadystatechange = function() {
		if (req.readyState == 4 && req.status == 200) {
			var response = req.responseText;
			var comm = JSON.parse(response);
			var data = JSON.parse(comm.comments);
			console.log(data);
			for (var i = 0; i < data.length; i++) {
				var o = data[i];
				html += "<tr>  <td> <b>" + o.name + " : </b> </td>  <td> " + o.comment
						+ "</tr>";
			}

			html += "</table>";
			console.log(html);
			document.getElementById('commentTable').innerHTML = html;
			document.getElementById('comment').value = "";
		} else {

		}
	};

	req.open("GET", url, true);
	req.send();
}
