<html>
<body>
<a href="helloworld">nihaonihaonihao</a>
<br><br><br>
<form action="testMethod" method="post">
	<input type="submit" value="submit">
</form>
<h2>Hello World!</h2>
<br><br><br>
<a href="testParams?username=mengmeng&age=11">testParams</a>
<br><br><br>
<a href="pathVariable/1">testPathVariable</a>
<br><br><br>
<a href="testTrans/1">testGet</a>
<br><br><br>
<form action="testTrans"method="post">
	<input type="submit" value="TestTrans Post">
</form>
<br><br><br>
<form action="testTrans/1"method="post">
	<input type="hidden"name="_method"value="DELETE">
	<input type="submit"value="TestTrans DELETE">
</form>
<br><br><br>
<form action="testTrans/1"method="post">
	<input type="hidden"name="_method"value="PUT">
	<input type="submit"value="TestTrans PUT">
</form>

<br><br><br>
<a href="testRequestParam?username=mengmeng&age=11">testParams</a>

<form action="testPOJO" method="post">
	username:<input type="text" name="username">
	<br>
	password:<input type="password"name="password">
	<br>
	email:<input type="email" name="email">
	<br>
	age:<input type="text"name="age">
	<br>
	city:<input type="text"name="address.city">
	<br>
	province:<input type="text"name="address.province">
	<input type="submit" value="submit">
</form>

	<a href="testSession">testSession</a>


	<form action="testModelAttribute" method="post">
	<input type="hidden"name="id"value="1">
	username:<input type="text" name="username"value="Tom">
	
	<br>
	email:<input type="email" name="email"value="159357@qq.com">
	<br>
	age:<input type="text"name="age"value="12">
	<br>
	<input type="submit" value="submit">
	</form>

	<a href="list">List All Employees</a>


</body>
</html>
