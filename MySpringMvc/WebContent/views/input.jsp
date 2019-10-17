<%@page import="java.util.Map"import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="emp" method="post"modelAttribute="employee">
		LastName:<form:input path="lastName"/>
		<br>
		Email:<form:input path="email"/>
		<br>
		<%
			Map<String,String> genders = new HashMap();
			genders.put("1", "Male");
			genders.put("1", "Female");
			
			request.setAttribute("genders", genders);
		%>
		Gender: <form:radiobuttons path="gender" items="${genders }"/>
		<br>
		Department: <form:select path="department.id"
		items="${departments }"itemLabel="departmentName"itemValue="id"></form:select>
		<br>
		<input type="submit"value="submit">
	</form:form>
</body>
</html>