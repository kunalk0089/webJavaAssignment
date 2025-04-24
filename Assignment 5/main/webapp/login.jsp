<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<style type="text/css">
#box {
	background-color: yellow;
	margin: 100px;
	padding: 0;
	font-family: Arial, sans-serif;
}
</style>
</head>
<body bgcolor="aqua">
	<div id="box">
		<h1>Login </h1>

		<form action="login" method="post">
			email:<input type="text" name="email"><br>  <br>
			Password:<input type="text" name="password"><br>  <br>
			<input type="submit" value="LogIn">
		</form>

	</div>
</body>
</html>