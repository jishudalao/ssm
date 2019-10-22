<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="testConversionServiceConverter" method="post">
		Employee:<input type="text" name="employee">
		<input type="submit" value="Submit"/>
	</form>
	<br><br>
	<form:form	action="${pageContext.request.contextPath }/emp" method="POST" modelAttribute="employee">
		
		
		<c:if test="${employee.id == null }">
		LastName: <form:input path="lastName"/>
		<br>
		<form:errors path="lastName"></form:errors>
		</c:if>
		
		<c:if test="${employee.id != null }">
			<form:hidden path="id"/>
			<input type="hidden" name="_method" value="PUT">
		</c:if>
		<br>
		Email:<form:input path="email"/>
		<br>
		<form:errors path="email"></form:errors>
		<br>
		<%
			Map<String,String> genders = new HashMap();
		genders.put("0", "Female");
		genders.put("1", "Male");
		
		request.setAttribute("genders", genders);
		%>
		Gender:<form:radiobuttons path="gender" items="${genders }"/>
		<br>
		Department:<form:select path="department.id" items="${departments }" itemLabel="departmentName" itemValue="id"></form:select>
		<br>
		 
		Birth:<form:input path="birth"/>
		<br>
		<form:errors path="birth"></form:errors>
		<br>
		Salary:<form:input path="salary"/>
		<br>
		<form:errors path="salary"></form:errors>
		<br>
		<input type="submit" value="submit">
	</form:form>
</body>
</html>