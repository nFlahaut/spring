<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h2>Employee Success From</h2>
	<hr />

	<table>
		<tr>
			<th>EmpNo</th>
			<td>${employee.empNo}</td>
		</tr>
		<tr>
			<th>Job</th>
			<td>${employee.job}</td>
		</tr>
		<tr>
			<th>HireDate</th>
			<td>${employee.hireDate}</td>
		</tr>
	</table>
</body>
</html>