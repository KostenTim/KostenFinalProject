<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style2.css">
<meta charset="UTF-8">
<title>Railroad</title>
</head>
<body>

<header class="header">
  <div class="logo-menu">
  
                <a href="#"><img class="logotip" src="https://upload.wikimedia.org/wikipedia/commons/7/75/Train_Austria.svg" alt="logo">
              </a>
            
              <nav class="menu">
<ul>
<li>
<form action="Controller" method="Post">
		<input  class="inputs" type="hidden" name="command" value="showTickets" />
		<input id="btn1" class="btn" type="submit" value="${text.showTickets}" />
	</form>
</li>
<li>
<form action="Controller" method="Post">
		<input type="hidden" name="command" value="translate" /> <input
			type="hidden" name="leng" value="eng" /> <input class="translateButton" type="submit"
			value="EN">
	</form>

	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="translate" /> <input
			type="hidden" name="leng" value="rus" /> <input class="translateButton" type="submit"
			value="RU">
	</form>
  </li>
  <li>
    <form action="Controller" method="Post">
		<input type="hidden" name="command"
			value="goToHomePage" />
			 <input id="btn1" class="btn" type="submit" value="${text.home_page}" />
	</form>
  </li>
    <li>
      <form action="Controller" method="Post">
		<input  type="hidden" name="command" value="logout" />
		<input class="btn" type="submit" value="${text.logout}" />
	</form>
    </li>
  </ul>  
  </div>

 </nav>
    </header>

<div class="mainMenu2">
	<table class="table" cellspacing="2" border="1" cellpadding="5" width="600">
		<thead>
			<tr>
				<td class="nameColonn">${text.name_station}</td>
				<td class="nameColonn">${text.date_time_of_arrival}</td>
				<td class="nameColonn">${text.date_time_of_departure}</td>
				<td class="nameColonn">${text.stop_time}</td>
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
	</div>
	<footer class="footer">

  <div class="content-footer">
    <p class="report">(EPAM-KNURE Java Training) 2020<b></b></p>
   
  </div>

</footer>
</body>
</html>


