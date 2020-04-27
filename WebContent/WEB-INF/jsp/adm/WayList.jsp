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

	<br> ${text.list_of_all_routes_in_the_database}
	<br>
	<table cellspacing="2" border="1" cellpadding="5" width="600">
		<thead>
			<tr>
				<td>${text.route_N}</td>
				<td>${text.rain_N}</td>
				<td>${text.date_time_of_departure}</td>
				<td>${text.date_time_of_arrival}</td>
				<td>${text.book_compartment_train}</td>
				<td>${text.book_sleeper_train}</td>
				<td>${text.book_train_carriage}</td>
			</tr>
		</thead>
		<c:set var="k" value="0" />
		<c:forEach var="item" items="${listWay}">
			<c:set var="k" value="${k+1}" />
			<tr>
				<td>${item.id_railway_route}</td>
				<td>${item.nameTrain}</td>
				<td>${item.start}</td>
				<td>${item.end}</td>
				<td>${item.free_place_type1}</td>
				<td>${item.free_place_type2}</td>
				<td>${item.free_place_type3}</td>
		</c:forEach>
	</table>
	<br>

	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="EditRoute" /> ${text.route} <select
			name="id_route">
			<c:set var="k" value="0" />
			<c:forEach var="item" items="${listWay}">
				<c:set var="k" value="${k+1}" />
				<option value=${item.id_railway_route}>${item.id_railway_route}</option>
			</c:forEach>
		</select> <input type="submit" value="${text.EDIT}">
	</form>
	${error}

</body>
</html>