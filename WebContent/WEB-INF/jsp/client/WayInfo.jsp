<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Railroad</title>
</head>
<body>

<form action="Controller" method="Post">
		<input type="hidden" name="command" value="translate" /> <input
			type="hidden" name="leng" value="eng" /> <input type="submit"
			value="EN">
	</form>

	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="translate" /> <input
			type="hidden" name="leng" value="rus" /> <input type="submit"
			value="RU">
	</form>

	<form action="Controller" method="Post">
		<input class="inputs" type="hidden" name="command"
			value="goToHomePage" /> <input type="submit" value="${text.home_page}" />
	</form>

	<form action="Controller" method="Post">
		<input class="inputs" type="hidden" name="command" value="logout" />
		<input type="submit" value="${text.logout}" />
	</form>

	<form action="Controller" method="Post">
		<input class="inputs" type="hidden" name="command" value="showTickets" />
		<input type="submit" value="${text.showTickets}" />
	</form>


	<table cellspacing="2" border="1" cellpadding="5" width="600">
		<thead>
			<tr>
				<td>${text.name_station}</td>
				<td>${text.date_time_of_arrival}</td>
				<td>${text.date_time_of_departure}</td>
				<td>${text.stop_time}</td>
			</tr>
		</thead>
		<c:set var="k" value="0" />
		<c:forEach var="item" items="${liststation}">
			<c:set var="k" value="${k+1}" />
			<tr>
				<td>${item.nameStation}</td>
				<td>${item.time_of_arrival}</td>
				<td>${item.departure_time}</td>
				<td>${item.stop_time}</td>
		</c:forEach>
	</table>
</body>
</html>


