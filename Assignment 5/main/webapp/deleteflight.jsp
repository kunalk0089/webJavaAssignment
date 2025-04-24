<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Delete Booking</title>
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
		<h1>Deleting Booking </h1>

		<form action="deletebook" method="post">
			Flight ID:<input type="text" name="flightId"><br>  <br>
			<input type="submit" value="Delete">
		</form>

	</div>
</body>
</html>