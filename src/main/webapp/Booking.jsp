<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Booking</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>

	<main class="container-fluid">

		<div class="text-center">
			<br>
			<h3>Booking</h3>
			<form onsubmit="book()">
				<input type="hidden" name="movieId" id="movieId" required readonly />
				<br> <label for="name">Movie Name: </label> <input type="text"
					name="name" id="name" readonly><br /> <br> <label
					for="actor">Actor Name: </label> <input type="text" name="actor"
					id="actor" readonly><br /> <br> <label for="date">
					Date: </label> <input type="date" id="date" name="date" required readonly><br />
				<br>
				<label for="time"> Show Time: </label> <input type="time" id="time"
					name="time" required readonly><br /> <br>
				<label for="seat"> Seat Type: </label> <input type="text" id="seat"
					name="seat" required readonly><br /> <br>
				<label for="screen"> Screen: </label> <input type="text" id="screen"
					name="screen" required readonly><br /> <br> <label
					for="tickets">Number of Tickets : </label> <input type="number"
					name="tickets" id="tickets" min=1 oninput="getPrice()" required><br />
				<br> <label for="price">Total Price: </label> <input
					type="number" name="price" id="price" required readonly><br />
				<br>
				<button class="btn btn-primary" type="submit">Book</button>
				<a class="btn btn-danger" href="index.jsp " type="reset">Cancel</a>
				<br />
			</form>
		</div>
		<script src="js/Booking-component.js">
		
		 		</script>


	</main>
</body>
</html>
