<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Weather App</title>
		<link rel="stylesheet" href="style.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link
			href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
			rel="stylesheet">
	</head>

	<body>
		<section>
			<h1 class="poppins-extrabold" id="main-heading">Welcome to Weather App</h1>
			<form action="MyServlet" method="post" id="main-page-form">
				<input name="userInput" placeholder="Enter The City Name"> </input>
				<button id="searchButton"><i class="fa-solid fa-magnifying-glass"></i></button>
			</form>

			<div id="outerbox">
				<div class="temp-weatherCond">
					<img alt="" src="" id="weather-image">
					<h2 class="poppins-extrabold" id="main-heading"> ${temperature} °C</h2>
					<input type="hidden" id="weatherCondition" value="${weatherCondition}"> </input>

				</div>
				<div class="city">
					<h2 class="poppins-medium"> ${city}</h2>
				</div>
				<div class="date">
					<h2 class="poppins-medium">${date}</h2>
				</div>
				<div id="humid-wind">
					<div class="humidity">
						<img src="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhgr7XehXJkOPXbZr8xL42sZEFYlS-1fQcvUMsS2HrrV8pcj3GDFaYmYmeb3vXfMrjGXpViEDVfvLcqI7pJ03pKb_9ldQm-Cj9SlGW2Op8rxArgIhlD6oSLGQQKH9IqH1urPpQ4EAMCs3KOwbzLu57FDKv01PioBJBdR6pqlaxZTJr3HwxOUlFhC9EFyw/s320/thermometer.png"
							alt="Humidity" id="weather-image2">
						<div id="text-block">
							<h3 class="poppins-regular">Humidity</h3>
							<h2 class="poppins-medium"> ${humidity}</h2>
						</div>

					</div>
					<div class="windSpeed">
						<img src="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiyaIguDPkbBMnUDQkGp3wLRj_kvd_GIQ4RHQar7a32mUGtwg3wHLIe0ejKqryX8dnJu-gqU6CBnDo47O7BlzCMCwRbB7u0Pj0CbtGwtyhd8Y8cgEMaSuZKrw5-62etXwo7UoY509umLmndsRmEqqO0FKocqTqjzHvJFC2AEEYjUax9tc1JMWxIWAQR4g/s320/wind.png"
							id="weather-image2">
						<div id="text-block">
							<h3 class="poppins-regular">Wind Speed</h3>
							<h2 class="poppins-medium"> ${windSpeed} km/h</h2>
						</div>

					</div>
				</div>
			</div>


		</section>
		<script src="script.js"></script>
	</body>

	</html>