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
	
	${text.the_route_passes_through_the_station_data}
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
	
	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="DeleteStation" />
		${text.station}  <select name="delete_station">
			<c:set var="k" value="0" />
			<c:forEach var="item" items="${list_edit_station}">
				<c:set var="k" value="${k+1}" />
				<option value=${item.nameStation}>${item.nameStation}</option>
			</c:forEach>
			</select>
			<input type="submit" value="${text.DELETE}">
	</form>
	
	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="ChangeStopTime" />
		${text.station}  <select name="change_station">
			<c:set var="k" value="0" />
			<c:forEach var="item" items="${list_edit_station}">
				<c:set var="k" value="${k+1}" />
				<option value=${item.nameStation}>${item.nameStation}</option>
			</c:forEach>
			</select>
			 <input name="stop_time" placeholder="${text.STOP_TIME_MIN}" />
			
			<input type="submit" value="${text.CHANGE}">
	</form>
	
	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="AddStation" />
		${text.station}  <select name="add_station">
			<c:set var="k" value="0" />
			<c:forEach var="item" items="${list_add_station}">
				<c:set var="k" value="${k+1}" />
				<option value=${item.nameStation}>${item.nameStation}</option>
			</c:forEach>
			</select>
			 <input name="stop_time" placeholder="${text.STOP_TIME_MIN}" />
			
			<input type="submit" value="${text.ADD}">
	</form>
	
	${error}
	
</body>
</html>