<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty requestScope.employees }">
		没有任何员工信息
	</c:if>
	<c:if test="${!empty requestScope.employees }">
		<table border="1" cellpadding="10"cellspacing="0">
			<tr>
				<th>ID</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			
			<c:forEach items="${requestScope.employees }"var="emp">
				<tr>
					<th>${emp.id }</th>
					<th>${emp.lastName }</th>
					<th>${emp.email }</th>
					<th>${emp.gender == 0 ? 'Female' : 'Male' }</th>
					<th>${emp.department.departmentName }</th>
					<th><a href="">Edit</a></th>
					<th><a href="">Delete</a></th>
				</tr>
			</c:forEach>
		</table>
		
	</c:if>
	
	<a href="emp">Add new employee</a>
	
	
</body>
</html>