<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList, java.util.Date, java.util.Iterator"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<form action="newuser"><input type="submit" value="Ajouter un user"/></form><br>
	<form action="index"><input type="submit" value="<spring:message code="index.go.index" />"/></form>
	<div align="center">
        <table border="2" cellpadding="5">
            <caption><h2>List of User</h2></caption>
            <tr>
                <th>UserId</th>
                <th>Username</th>
                <th>Role</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="x" items="${listUser}">
                <tr>
                    <td>${x.userId}</td>
                    <td>${x.username}</td>
                    <td>${x.role.roleName}</td>
                   <td>
                    	<a href="editUser?id=${x.userId}">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="deleteUser?id=${x.userId}">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>