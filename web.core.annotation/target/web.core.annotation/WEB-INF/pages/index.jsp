<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<body>
	<a href="?lang=en">English</a>
	<a href="?lang=fr">Français</a>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>INDEX</h2>
			</caption>
			<tr>
				<th><spring:message code="employee.Employee"/></th>
				<th><spring:message code="department.Department"/></th>
			</tr>
			<tr>
				<td><form action="employeeTable"><input type="submit" value="<spring:message code="employee.Employeetable"/>" /></form></td>
				<td><form action="departmentTable"><input type="submit" value="<spring:message code="department.Departmenttable"/>" /></form></td>
				<td><form action="userTable"><input type="submit" value="Tableau des users" /></form></td>
			</tr>
			<tr>
				<td><form action="employee"><input type="submit" value="<spring:message code="employee.add.employee" />"/></form></td>
				<td><form action="department"><input type="submit" value="<spring:message code="department.add.department"/>" /></form></td>
			</tr>
		</table>
	</div>
</body>
</html>
