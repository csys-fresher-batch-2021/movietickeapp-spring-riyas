<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bookings</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>My Bookings</h3>
		<p id="message"></p>
		<table class="table table-bordered" id="bookingsTable">
			<caption>This Table is for Showing Booking Details</caption>
			<thead>
				<tr>
					<th id="S.no">S.no</th>
					<th id="bookingId">Booking ID</th>
					<th id="movieName">Movie Name</th>
					<th id="bookedDate">Booked Date</th>
					<th id="showDate">Show Date</th>
					<th id="showTime">Show Time</th>
					<th id="screen">Screen</th>
					<th id="seatType">Seat Type</th>
					<th id="tickets">Tickets</th>
					<th id="price">Total Price</th>
					<th id="status">Status</th>
					<th id="action">Cancel</th>
				</tr>
			</thead>
			<tbody id="bookings">
			</tbody>
		</table>
	</main>
	<script type="text/javascript" src="js/UserBookings-component.js"></script>
</body>
</html>
