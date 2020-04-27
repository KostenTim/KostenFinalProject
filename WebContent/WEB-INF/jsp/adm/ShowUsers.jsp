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

	<table cellspacing="2" border="1" cellpadding="5" width="600">
		<thead>
			<tr>
				<td>${text.login}</td>
				<td>${text.role}</td>
			</tr>
		</thead>
		<c:set var="k" value="0" />
		<c:forEach var="item" items="${userlist}">
			<c:set var="k" value="${k+1}" />
			<tr>
				<td>${item.login}</td>
				<td>${item.role}</td>
		</c:forEach>
	</table>
</body>
</html>