<%@ page language="java" import="SurveyDemo.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Survey</title>
</head>
<body style="text-align:center;">

	
	
	<h2>Welcome To Survey CS370</h2>
	
	<form action="survey" method="post">
		<input type="text" name="uuid" size="40"/> <br>
		<br>
		<input type="submit" name="action" value="Get Survey" />
	</form>
	
	<br>
	<br>
	<hr>
	<form action="list" method="post">
		<input type="submit" name="action" value="List All Survey">
	</form>

	
	
	
	
</body>
</html>