<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get All Survey List</title>
</head>
<body>

	
	<div style="float: left; width: 50%;">
		<ol style="list-style: none; ">
		<c:forEach var="surveyUUID" items="${uuid}" varStatus="counter">
			<li>${surveyUUID}</li>
		</c:forEach>
	</ol>
	</div>
	<div style="float: right; width: 50%;">
		<ol style="list-style: none; ">
		<c:forEach var="name" items="${surveyName}" varStatus="counter">
			<li>${name}</li>
		</c:forEach>
	</ol>
	</div>
	
</body>
</html>