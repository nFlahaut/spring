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
	<form:form method="POST" action="addEmployee" modelAttribute="employee">
		<form:hidden path="empId"/>
		<form:label path="empNo">empNo :</form:label><br> 
		<form:input path="empNo"></form:input> 
		<sup>*</sup>
		<form:errors path="empNo" cssClass="error"/><br>
		<form:label path="job">job :</form:label><br> 
		<form:input path="job"></form:input>
		<sup>*</sup>
		<form:errors path="job" cssClass="error"/><br>
		<form:label path="hireDate">hireDate :</form:label><br> 
		<form:input path="hireDate"></form:input>
		<sup>*</sup>
		<form:errors path="hireDate" cssClass="error"/><br>
		<form:select path="department" items="${listDept}"	itemValue="deptId" itemLabel="deptNo" />
		<input type="submit" value="Submit"/>
	</form:form><br>
	<form action="employeeTable"><input type="submit" value="<spring:message code="employee.Employeetable"/>" /></form><br>
	<form action="index"><input type="submit" value="<spring:message code="index.go.index" />"/></form>
</body>
</html>