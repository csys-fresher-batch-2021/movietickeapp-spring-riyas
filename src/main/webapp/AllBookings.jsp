<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>All Bookings</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Bookings by All Users</h3>
		<table class="table table-bordered" id="bookingsTable">
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
			<tbody id="bookings"></tbody>
		</table>
	</main>
	<script type="text/javascript"src="js/ListAllBookings.js"></script>
</body>
</html>
