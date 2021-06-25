<!DOCTYPE html>
<%@page import="in.riyasahamed.model.Seat"%>
<%@page import="java.util.List"%>
<%@page import="in.riyasahamed.service.SeatService"%>
<html lang="en">
<head>
<title>Seat Types</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Seat Types</h3>

		<table class="table table-bordered">
			<caption>This Table is for Showing Different Seat Types</caption>
			<thead>
				<tr>
					<th id="S.no">S.No</th>
					<th id="seatType">Seat Type</th>
					<th id="price">Price Per Ticket</th>
				</tr>
			</thead>
			<tbody id="seat">

			</tbody>
		</table>
	</main>
   	<script src="js/SeatDetails-component.js"></script>
</body>
</html>
