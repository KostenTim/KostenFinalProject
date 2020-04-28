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
	<br><h2 class="mainText"> ${text.list_of_all_routes_in_the_database}</h2>
	<br>
	
	<table class="table"  cellspacing="2"border="1"  cellpadding="5" >
		<thead>
			<tr>
				<td class="nameColonn">${text.route_N}</td>
				<td class="nameColonn">${text.rain_N}</td>
				<td class="nameColonn">${text.date_time_of_departure}</td>
				<td class="nameColonn">${text.date_time_of_arrival}</td>
				<td class="nameColonn">${text.book_compartment_train}</td>
				<td class="nameColonn">${text.book_sleeper_train}</td>
				<td class="nameColonn">${text.book_train_carriage}</td>
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
<div class="mainText">
	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="EditRoute" /> ${text.route}
		 <select class="select"
			name="id_route">
			<c:set var="k" value="0" />
			<c:forEach var="item" items="${listWay}">
				<c:set var="k" value="${k+1}" />
				<option value=${item.id_railway_route}>${item.id_railway_route}</option>
			</c:forEach>
		</select> <input class="btn2" type="submit" value="${text.EDIT}">
	</form>
	</div>
	<p class ="err">${error}</p>
	
</div>
<footer class="footer">

  <div class="content-footer">
    <p class="report">(EPAM-KNURE Java Training) 2020<b></b></p>
   
  </div>

</footer>
</body>
</html>