<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList, java.util.Date, java.util.Iterator"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<form action="employee"><input type="submit" value="<spring:message code="employee.add.employee" />"/></form><br>
	<form action="index"><input type="submit" value="<spring:message code="index.go.index" />"/></form>
	<div align="center">
        <table border="2" cellpadding="5">
            <caption><h2>List of Employee</h2></caption>
            <tr>
                <th>EmpId</th>
                <th>EmpNo</th>
                <th>Job</th>
                <th>HireDate</th>
                <th>Department</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="x" items="${listEmployee}">
                <tr>
                    <td>${x.empId}</td>
                    <td>${x.empNo}</td>
                    <td>${x.job}</td>
                    <td>${x.hireDate}</td>
                    <td>${x.department.deptName}</td>
                   <td>
                    	<a href="editEmp?id=${x.empId}">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="deleteEmployee?id=${x.empId}">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>