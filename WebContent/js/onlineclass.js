function initRequest() {
	if (window.XMLHttpRequest) {
		return new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		isIE = true;
		return new ActiveXObject("Microsoft.XMLHTTP");
	}
}

function approveOrRejectEnrolledCourse(loginName, courseCode, action, elementid) {

	var url = "AdminCoursesServlet?loginName="+loginName+"&courseCode=" + courseCode+"&action="+action;
	var req = initRequest();
	req.onreadystatechange = function() {
		if (req.readyState == 4 && req.status == 200 ) {
				console.log( req.responseText);
				document.getElementById(elementid).innerHTML = req.responseText;
		}
	};
	req.open("GET", url, true);
	req.send(null);
}

function addComments(loginName, comment) {
	
}
