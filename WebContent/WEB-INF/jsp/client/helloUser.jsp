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

	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="findway" /> <select
			name="station1">
			<option value="A1">A1</option>
			<option value="A2">A2</option>
			<option value="A3">A3</option>
			<option value="A4">A4</option>
			<option value="A5">A5</option>
			<option value="A6">A6</option>
			<option value="A7">A7</option>
			<option value="A8">A8</option>
		</select> <select name="station2">
			<option value="A1">A1</option>
			<option value="A2">A2</option>
			<option value="A3">A3</option>
			<option value="A4">A4</option>
			<option value="A5">A5</option>
			<option value="A6">A6</option>
			<option value="A7">A7</option>
			<option value="A8">A8</option>
		</select> <input type="submit" value="${text.FIND}">
	</form>
	${error}
</body>
</html>