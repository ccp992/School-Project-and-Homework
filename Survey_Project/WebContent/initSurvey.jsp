<%@page import="java.util.List"%>
<%@ page language="java" import="SurveyDemo.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question Demo</title>
</head>
<body>
	<form action="result" method="post">

		<c:forEach var="list" items="${quest}" varStatus="counter">

			<h4>${list.getQuestion()}</h4>
			<c:forEach var="ans" items="${list.getChoice()}">
			
				<c:choose>
					<c:when test="${list.getType() == 'text'}">
						<textarea rows="6" cols="26" name="${list.getName()}" ${list.getLength()}></textarea>
					</c:when>
					<c:otherwise>
						<input type="${list.getType()}" name="${list.getName()}"
							value="${ans}" ${list.getLength()}> ${ans}<br>
					</c:otherwise>
				</c:choose>

			</c:forEach>

		</c:forEach>
		<hr>
		<input type="submit" name="action" value="Result" />
	</form>
</body>
</html>