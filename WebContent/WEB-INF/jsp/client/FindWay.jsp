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
	 <p class="mainText">${text.result_find_from} ${st1}--${st2}</p>
	 </div>
	<div class="mainMenu">	
	<table class="table" cellspacing="2" border="1" cellpadding="5" width="800">
		<thead>
			<tr>
				<td class="nameColonn">${text.rain_N}</td>
				<td class="nameColonn">${text.date_time_of_departure}</td>
				<td class="nameColonn">${text.departure_station}</td>
				<td class="nameColonn">${text.travel_time}</td>
				<td class="nameColonn">${text.date_time_of_arrival}</td>
				<td class="nameColonn">${text.arrival_station}</td>
				<td class="nameColonn">${text.book_compartment_train}</td>
				<td class="nameColonn">${text.prices_compartment_train}</td>
				<td class="nameColonn">${text.book_sleeper_train}</td>
				<td class="nameColonn">${text.prices_sleeper_train}</td>
				<td class="nameColonn">${text.book_train_carriage}</td>
				<td class="nameColonn">${text.prices_train_carriage}</td>
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
</div>
<div class="selected">
	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="showInfoTrin" />
		<p class="mainText"> ${text.view_train_route_information_by_train_number}</p>
		  <select class="select" name="nameTrain">
			<c:set var="k" value="0" />
			<c:forEach var="item" items="${WayShowForUser}">
				<c:set var="k" value="${k+1}" />
				<option value=${item.rain_number}>${item.rain_number}</option>
			</c:forEach>
		</select> <input class="btn2" type="submit" value="${text.SHOW_INFO}">
	</form>
	<br>

	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="buyTicket" /> 
		<p class="mainText"> ${text.buy_train_ticket_number} </p>
		<select class="select" name="nameTrain">
			<c:set var="k" value="0" />
			<c:forEach var="item" items="${WayShowForUser}">
				<c:set var="k" value="${k+1}" />
				<option value=${item.rain_number}>${item.rain_number}</option>
			</c:forEach>
		</select>
		
		 ${text.place}
		 <select class="select" name="place">
			<option value="compartment train">${text.compartment_train}</option>
			<option value="sleeper train">${text.sleeper_train}</option>
			<option value="train carriage">${text.train_carriage}</option>
		</select> <input class="btn2" type="submit" value="${text.BUY}">
		<p class="err"> ${error} </p>
	<p class="message">  ${message} </p>
	</form>
	</div>
	
	 <footer class="footer">

  <div class="content-footer">
    <p class="report">(EPAM-KNURE Java Training) 2020<b></b></p>
   
  </div>

</footer>
</body>
</html>


