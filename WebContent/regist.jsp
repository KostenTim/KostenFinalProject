<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${text.registration}</title>
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
		<input class = "inputs" type="hidden" name="command" value="registr" /> ${text.login} <input
			name="login" /> <br> 
			${text.password}
			<input name="password" type="password" /> <br>
			${text.confirm_password}
			<input name="password2" type="password" />
			<input type="submit" value="${text.registration}" />
	</form>
	
	${error}
</body>
</html>