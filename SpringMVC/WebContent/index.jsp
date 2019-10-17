<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="SpringMvc/postMethod"method="post">
		<input type="submit"value="tijiao">
	</form>
	<br><br>
	<a href="helloworld">Hello World</a>
	<br><br>
	<a href="SpringMvc/test">just test</a>
	<br><br>
	<a href="SpringMvc/testParam?username=mengyuan&age=11">test ParamVariable</a>
	<br><br>
	<a href="SpringMvc/testPathVariable/aaa/1">test PathVariable</a>
	<br><br>
	<a href="SpringMvc/testRest/1">Test Rest Get</a>
	<br><br>
	<form action="SpringMvc/testRest"method="post">
		<input type="submit" value="TestRest Post">
	</form>
	<br><br>
	<form action="SpringMvc/testRest/1"method="post">
		<input type="hidden"name="_method"value="DELETE">
		<input type="submit" value="TestRest DELETE">
	</form>
	<br><br>
	<form action="SpringMvc/testRest/1"method="post">
		<input type="hidden"name="_method"value="PUT">
		<input type="submit" value="TestRest PUT">
	</form>
	<br><br>
	<a href="SpringMvc/testRequestParam?username=xuke&age=12">test RequestParam</a>
</body>
</html>