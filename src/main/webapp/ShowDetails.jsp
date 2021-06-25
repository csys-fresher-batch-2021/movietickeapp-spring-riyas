	<%@page import="in.riyasahamed.service.SeatService"%>
<%@page import="java.time.LocalTime"%>
<%@page import="in.riyasahamed.dto.TicketDTO"%>
<%@page import="java.util.Map"%>
<%@page import="in.riyasahamed.model.Movie"%>
<%@page import="java.util.List"%>
<%@page import="in.riyasahamed.service.MovieService"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Book Movie</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="text-center">
			<h4>Select Date and Show Time</h4>
			<form onsubmit="getMovies()">
				<br> <label for="showDate">Enter Show Date :</label> <input
					type="date" placeholder="ShowDate" id="showDate" name="showDate"
					required onchange="getShowTimes()"><br />				
				<div id="showTimes"></div>
				<div id="seatTypes"></div><br/>
				<input id="availableTickets" name="availableTickets" type="hidden">
				<button type="submit" class="btn btn-primary">Search</button>
				<div id="movie"></div>
				<br>
				
				<br/>

			</form>
		</div>
		<br>
	</main>
</body>
<script src="js/ShowDetails-component.js"></script>
</html>
