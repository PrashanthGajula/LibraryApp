<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<body>
<H1>User Registration</H1>
<form:form modelAttribute="user">
	<table border="0">
		<tr>
			<td>UserName:</td>
			<td><form:input path="userName"/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><form:password path="password"/></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td><form:input path="fName"/></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><form:input path="lName"/></td>
		</tr>
		<tr>
			<td>Age:</td>
			<td><form:input path="age"/></td>
		</tr>
		<tr>
			<td>Admin access:</td>
			<td>
				<form>
					<input type="radio" name="admin" value="TRUE"> TRUE
				    <input type="radio" name="admin" value="FALSE"> FALSE
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Add User">
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>