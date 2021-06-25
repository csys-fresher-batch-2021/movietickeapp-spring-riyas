<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>All Bookings</title>
</head>
<body onload="filterDetails()">
	<jsp:include page="Header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Bookings by All Users</h3>
		<form>
			<br> <input type="date" id="date" name="date"
				onchange="filterDetails()"> <input type="text" id="movie"
				name="movie" oninput="filterDetails()" placeholder="Movie Name">
			<select id="status" name="status" onchange="filterDetails()">
				<option value="" selected>All</option>
				<option value="BOOKED">Booked</option>
				<option value="CANCELLED">Cancelled</option>
				<option value="FINISHED">FINISHED</option>
			</select>
			<button type="reset" class="btn btn-primary" onclick="clearFilters()">Clear
				Filters</button>
		</form>
		<table class="table table-bordered">
			<caption>This Table is for Showing Booking Details</caption>
			<thead>
				<tr>
					<th id="S.no">S.no</th>
					<th id="bookingId">Booking ID</th>
					<th id="user">Name of the User</th>
					<th id="mobileNumber">Mobile Number</th>
					<th id="movieId">Movie ID</th>
					<th id="movieName">Movie Name</th>
					<th id="bookedDate">Booked Date</th>
					<th id="showDate">Show Date</th>
					<th id="showTime">Show Time</th>
					<th id="screen">Screen</th>
					<th id="seatType">Seat Type</th>
					<th id="tickets">Number of Tickets</th>
					<th id="price">Total Price</th>
					<th id="status">Status</th>
				</tr>
			</thead>
			<tbody id="bookings">

			</tbody>
		</table>
	</main>
	<script type="text/javascript"src="js/AllBookings-component.js"></script>
</body>
</html>
