<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList, java.util.Date, java.util.Iterator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<form:form method="POST" action="addDepartment" modelAttribute="department">
		<form:label path="deptId">deptId :</form:label><br>
		<form:input path="deptId"></form:input> 
		<sup>*</sup>
		<form:errors path="deptId" cssClass="error"/><br>
		<form:label path="deptNo">deptNo :</form:label><br> 
		<form:input path="deptNo"></form:input> 
		<sup>*</sup>
		<form:errors path="deptNo" cssClass="error"/><br>
		<form:label path="deptName">deptName :</form:label><br> 
		<form:input path="deptName"></form:input>
		<sup>*</sup>
		<form:errors path="deptName" cssClass="error"/><br>
		<form:label path="location">location :</form:label><br> 
		<form:input path="location"></form:input>
		<sup>*</sup>
		<form:errors path="location" cssClass="error"/><br>
		<input type="submit" value="Submit"/>
	</form:form><br>
	<form action="departmentTable"><input type="submit" value="<spring:message code="department.Departmenttable"/>" /></form><br>
	<form action="index"><input type="submit" value="<spring:message code="index.go.index" />"/></form>
</body>
</html>