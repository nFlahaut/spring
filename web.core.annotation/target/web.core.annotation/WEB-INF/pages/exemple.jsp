<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList, java.util.Date, java.util.Iterator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${message1}</h1>
	<h1>Liste des bonjours :</h1>
	<h2>
	<c:forEach items="${liste}" var="x">
		${x}<br>
	</c:forEach>
	</h2>
	<h1>Bonjour ${name}</h1>
	
</body>
</html>