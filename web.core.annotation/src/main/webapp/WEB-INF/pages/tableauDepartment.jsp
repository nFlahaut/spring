<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList, java.util.Date, java.util.Iterator"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<form action="department"><input type="submit" value="<spring:message code="department.add.department"/>"/></form><br>
	<form action="index"><input type="submit" value="<spring:message code="index.go.index" />"/></form>
	<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Department</h2></caption>
            <tr>
                <th>DeptId</th>
                <th>DeptNo</th>
                <th>DeptName</th>
                <th>Loation</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="x" items="${listDepartment}">
                <tr>
                    <td><c:out value="${x.deptId}" /></td>
                    <td><c:out value="${x.deptNo}" /></td>
                    <td><c:out value="${x.deptName}" /></td>
                    <td><c:out value="${x.location}" /></td>
                   <td>
                    	<a href="editDept?id=${x.deptId}">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="deleteDepartment?id=${x.deptId}">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>