<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"src="js/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#testJson").click(function(){
			var url = this.href;
			var args = {};
			$.post(url,args,function(data){
				for(var i=0;i<data.length;i++){
					var id = data[i].id;
					var lastName = data[i].lastName;
					alert(id+":"+lastName);
				}
			})
			return false;
		})
	})
</script>
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
	<br><br>
	<form action="SpringMvc/testPOJO"method="post">
		username:<input type="text" name="username">
		<br>
		password:<input type="password" name="password">
		<br>
		email:<input type="text" name="email">
		<br>
		age:<input type="text" name="age">
		<br>
		city:<input type="text" name="address.city">
		<br>
		province:<input type="text" name="address.province">
		<br>
		<input type="submit" value="Submit">
	</form>
	<br><br>
	<a href="SpringMvc/testModelAndView">testModelAndView</a>
	<br><br>
	<a href="SpringMvc/testMap">testMap</a>
	<br><br>
	<a href="SpringMvc/testSessionAttribute">testSessionAttribute</a>
	<br><br>
	<a href="SpringMvc/testSessionAttributeString">testSessionAttributeString</a>
	<br><br>
	<form action="SpringMvc/testModelAttribute"method="post">
		<input type="hidden"name="id"value="1">
		username:<input type="text" name="username"value="yuan">
		<br>
		email:<input type="text" name="email"value="bb@qq.com">
		<br>
		age:<input type="text" name="age"value="30">
		<br>
		<input type="submit" value="Submit">
	</form>
	<br><br>
	<a href="SpringMvc/testRedirect">testRedirect</a>
	<br><br>
	<a href="emps">List All Employees</a>
	
	<br><br>
	<a href="emp">Add New Employee</a>
	<br><br>
	<a href="testJson" id="testJson">testJson</a>
	<br><br>
	<form action="testHttpMessageConverter" method="post" enctype="multipart/form-data">
		File:<input type="file" name="file">
		<br>
		Desc:<input type="text" name="desc">
		<br>
		<input type="submit" value="Submit">
	</form>
	<br><br>
	<a href="testResponseEntity">testResponseEntity</a>
	<br><br>
	<form action="testFileUpload" method="post" enctype="multipart/form-data">
		File:<input type="file" name="file">
		<br>
		Desc:<input type="text" name="desc">
		<br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>