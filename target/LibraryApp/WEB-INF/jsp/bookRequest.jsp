<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Request</title>
</head>
<body>
	<h1>Book Request</h1>
	<form:form modelAttribute="bookRequest">
		<table id="reqTab">
			<tr>
				<td align="right">Full Name :</td>
				<td><form:input path="fullName" /></td>
			</tr>
			<tr>
				<td align="right">Category :</td>
				<td>
					<form:select path = "cat_desc">
				    	<form:option value = "NONE" label = "Select"/>
				        <form:options items = "${categoryList}" />
				    </form:select>
				</td>
			</tr>
			<tr>
				<td align="right">Book :</td>
				<td><form:input path="book_desc"/></td>
			</tr>
			<tr>
				<td align="right">Message :</td>
				<td><form:textarea path="message" rows="5" cols="30" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Request" align="middle">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>