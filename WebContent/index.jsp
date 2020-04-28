<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Railroad</title>
</head>
<body>
	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="translate" /> <input
			type="hidden" name="leng" value="eng" /> <input class="btn2" type="submit"
			value="EN">
	</form>

	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="translate" /> <input
			type="hidden" name="leng" value="rus" /> <input class="btn2" type="submit"
			value="RU">
	</form>


	<div class="main">
		<form action="Controller" method="Post">
			<input type="hidden" name="command" value="login" />
			 <span>
				<h3>${text.login}</h3>
			</span> 
			<input name="login" /> 
			<span>
				<h3>${text.password}</h3>
			</span> 
			<input name="password" type="password" min=6 /> 
			<input class="btn" type="submit" value="${text.sign_in}" />

		</form>
		<form action="Controller" method="Post">
			<input type="hidden" name="command" value="goToRegistration" /> 
			<input class="btn" type="submit" value="${text.registration}" />
		</form>
		<span class="err">${error}</span> <br> ${messege}
	</div>
</body>
</html>