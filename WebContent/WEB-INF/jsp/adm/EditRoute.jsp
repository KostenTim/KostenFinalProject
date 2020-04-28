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
	<h2 class="mainText">${text.the_route_passes_through_the_station_data}</h2>
	<table class="table" cellspacing="2" border="1" cellpadding="5" width="600">
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
	
		<p class ="err">${error}</p>
	</div>
	<div class="adminButton">
	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="DeleteStation" />
		<p class="mainText">${text.station} </p>
		 <select class="select" name="delete_station">
			<c:set var="k" value="0" />
			<c:forEach var="item" items="${list_edit_station}">
				<c:set var="k" value="${k+1}" />
				<option value=${item.nameStation}>${item.nameStation}</option>
			</c:forEach>
			</select>
			<input class="btn2" type="submit" value="${text.DELETE}">
	</form>
	
	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="ChangeStopTime" />
		<p class="mainText">${text.station} </p> 
		<select class="select" name="change_station">
			<c:set var="k" value="0" />
			<c:forEach var="item" items="${list_edit_station}">
				<c:set var="k" value="${k+1}" />
				<option value=${item.nameStation}>${item.nameStation}</option>
			</c:forEach>
			</select>
			 <input  name="stop_time" placeholder="${text.STOP_TIME_MIN}" />
			
			<input class="btn2" type="submit" value="${text.CHANGE}">
	</form>
	
	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="AddStation" />
		<p class="mainText">${text.station} </p>
		<select class="select" name="add_station">
			<c:set var="k" value="0" />
			<c:forEach var="item" items="${list_add_station}">
				<c:set var="k" value="${k+1}" />
				<option value=${item.nameStation}>${item.nameStation}</option>
			</c:forEach>
			</select>
			 <input class="inputText" name="stop_time" placeholder="${text.STOP_TIME_MIN}" />
			
			<input class="btn2" type="submit" value="${text.ADD}">
	</form>
	</div>

	<footer class="footer">

  <div class="content-footer">
    <p class="report">(EPAM-KNURE Java Training) 2020<b></b></p>
   
  </div>

</footer>
</body>
</html>