<%@page import="com.airline.entiry.Booking"%>
<%@page import="com.airline.entiry.Flight"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>MYBOOKING</title>
<style type="text/css">
#box {
	background-color: yellow;
	margin: 100px;
	padding: 0;
	font-family: Arial, sans-serif;
}

#p {
	background-color: yellow;
	margin: 100px;
	padding: 0;
	font-family: Arial, sans-serif;
}

.flight-info {
	background-color: yellow;
	margin: 20px;
	padding: 15px;
	border-radius: 8px;
	box-shadow: 2px 2px 5px gray;
}
</style>
</head>
<body bgcolor="lightgreen">
	<div id="box">
		<h1>🎶✈️MY BOOKING DONES✈️🎶</h1>
		<%
		List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
		for (Booking b : bookings) {
		%>
		<p>
			Bookings ID:<%=b.getId()%>
			<br> <br> Bookings User ID:<%=b.getUserId()%>
			<br> <br> Bookings Flight ID:<%=b.getFlightId()%>
			<br> <br> Bookings Date:<%=b.getBookingDate()%>
			<hr/>


		</p>

		<%
		}
		%>
	</div>
</body>
</html>