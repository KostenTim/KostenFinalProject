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
	
	<br> ${text.result_find_from} ${st1}--${st2}
	<br>
	<table cellspacing="2" border="1" cellpadding="5" width="600">
		<thead>
			<tr>
				<td>${text.rain_N}</td>
				<td>${text.date_time_of_departure}</td>
				<td>${text.departure_station}</td>
				<td>${text.travel_time}</td>
				<td>${text.date_time_of_arrival}</td>
				<td>${text.arrival_station}</td>
				<td>${text.book_compartment_train}</td>
				<td>${text.prices_compartment_train}</td>
				<td>${text.book_sleeper_train}</td>
				<td>${text.prices_sleeper_train}</td>
				<td>${text.book_train_carriage}</td>
				<td>${text.prices_train_carriage}</td>
			</tr>
		</thead>
		<c:set var="k" value="0" />
		<c:forEach var="item" items="${WayShowForUser}">
			<c:set var="k" value="${k+1}" />
			<tr>
				<td>${item.rain_number}</td>
				<td>${item.start}</td>
				<td>${item.start_station}</td>
				<td>${item.min_travel}</td>
				<td>${item.end}</td>
				<td>${item.end_station}</td>
				<td>${item.free_place_type1}</td>
				<td>${item.cost_type1}</td>
				<td>${item.free_place_type2}</td>
				<td>${item.cost_type2}</td>
				<td>${item.free_place_type3}</td>
				<td>${item.cost_type3}</td>
		</c:forEach>
	</table>


	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="showInfoTrin" />
		 ${text.view_train_route_information_by_train_number} <select name="nameTrain">
			<c:set var="k" value="0" />
			<c:forEach var="item" items="${WayShowForUser}">
				<c:set var="k" value="${k+1}" />
				<option value=${item.rain_number}>${item.rain_number}</option>
			</c:forEach>
		</select> <input type="submit" value="${text.SHOW_INFO}">
	</form>
	<br>

	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="buyTicket" /> 
		${text.buy_train_ticket_number} <select name="nameTrain">
			<c:set var="k" value="0" />
			<c:forEach var="item" items="${WayShowForUser}">
				<c:set var="k" value="${k+1}" />
				<option value=${item.rain_number}>${item.rain_number}</option>
			</c:forEach>
		</select> ${text.place} <select name="place">
			<option value="compartment train">${text.compartment_train}</option>
			<option value="sleeper train">${text.sleeper_train}</option>
			<option value="train carriage">${text.train_carriage}</option>
		</select> <input type="submit" value="${text.BUY}">
	</form>
	<br> ${error} ${message}
</body>
</html>


