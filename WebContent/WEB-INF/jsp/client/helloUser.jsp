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
	<form action="Controller" method="Post">
		<input type="hidden" name="command" value="findway" /> 
		</div>
		<div class="optionFind">
		
		<select class="select"
			name="station1">
			
			<option value="A1">A1</option>
			<option value="A2">A2</option>
			<option value="A3">A3</option>
			<option value="A4">A4</option>
			<option value="A5">A5</option>
			<option value="A6">A6</option>
			<option value="A7">A7</option>
			<option value="A8">A8</option>
		</select> 
		<select class="select" name="station2">
			<option value="A1">A1</option>
			<option value="A2">A2</option>
			<option value="A3">A3</option>
			<option value="A4">A4</option>
			<option value="A5">A5</option>
			<option value="A6">A6</option>
			<option value="A7">A7</option>
			<option value="A8">A8</option>
		</select>
		</div>
		<div class="mainMenu2">
		 <input class="btnMenu2" type="submit" value="${text.FIND}">
		 	<p class="err" >${error} </p>
		 </div>
	</form>
	<div class="mainMenu3"></div>
<footer class="footer">

  <div class="content-footer">
    <p class="report">(EPAM-KNURE Java Training) 2020<b></b></p>
   
  </div>

</footer>
</body>

</html>