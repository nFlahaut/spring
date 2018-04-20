<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList, java.util.Date, java.util.Iterator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>${titre}</h1>
	<form:form method="POST" action="addUser" modelAttribute="newuser">
		<form:hidden path="userId"/>
		<form:label path="username">username :</form:label><br> 
		<form:input path="username"></form:input> 
		<form:label path="password">password :</form:label><br> 
		<form:input path="password"></form:input>
		<form:select path="role" items="${listRole}" itemValue="roleId" itemLabel="roleName" />
		<input type="submit" value="Submit"/>
	</form:form><br>
	<form action="userTable"><input type="submit" value="Tableau des users" /></form><br>
	<form action="index"><input type="submit" value="<spring:message code="index.go.index" />"/></form>
</body>
</html>