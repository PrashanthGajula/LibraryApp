<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Home</title>
</head>
<body>
<form:form modelAttribute="category">
	<h1>Library Home Page</h1>
	<form:label path="category_desc">Select a category :</form:label>
    <form:select path = "category_desc" onchange="this.form.submit()">
    	<form:option value = "NONE" label = "Select"/>
        <form:options items = "${categoryList}" />
    </form:select>    
	<c:if test="${category.category_desc ne NONE}">
		<h1>Selected Category: ${category.category_desc} </h1>
	</c:if>
    <table id="tab">
    	<c:if test="${category.category_desc ne NONE}">
			<tr>
		  		<th>Book Description</th>
		    	<th>Quantity</th>
		  	</tr>
		  	<c:forEach items="${bookList}" var="book">
		  		<tr>
		      		<td><c:out value="${book.book_desc}" /></td>
		      		<td><c:out value="${book.quantity}" /></td>
		    	</tr>
		  	</c:forEach>
		</c:if>
	</table>
</form:form>
<br>
<form:form action="bookRequest.html" method="get">
	<input type="submit" value="Request"/>
</form:form>

</body>
</html>