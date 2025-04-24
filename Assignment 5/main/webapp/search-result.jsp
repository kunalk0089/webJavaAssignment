<%@page import="com.airline.entiry.Flight"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Results</title>
<style type="text/css">
#box {
	background-color: yellow;
	margin: 100px;
	padding: 0;
	font-family: Arial, sans-serif;
}
</style>
</head>
<body>
		<div id="box">
		<h1> ✈️Available Flight✈️ </h1>

		<%
		  List<Flight> flights = (List<Flight>) request.getAttribute("flights");
		  for(Flight f: flights)
		  {
		%>
		<p>
			Flight Number:<%=f.getFlightNumber() %> | <%=f.getSource() %> to <%=f.getDestination()%> <br>
			Schedule Date: <%=f.getFlightDate() %> | Price: <%=f.getPrice() %> <br>
			
			<form action="bookFlight" method="post">
			<input type="hidden" name="flightId" value=<%=f.getId() %>> 
			<input type="submit" value="Book">
			</form>
			<hr/>
		</p>
		
		<%
		  }
		%>

	</div>

</body>
</html>