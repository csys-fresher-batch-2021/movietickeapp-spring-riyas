<!DOCTYPE html>

<%@page import="java.util.List"%>

<html lang="en">
<head>
<title>Movies</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>All Movies</h3>
		<p id="message"></p>
		<table class="table table-bordered">
			<caption>This Table is for Showing All Movies</caption>
			<thead>
				<tr>
					<th id="S.no">S.No</th>
					<th id="movieName">Movie Name</th>
					<th id="actor">Actor Name</th>
					<th id="screen">Screen</th>
				</tr>
			</thead>
			<tbody id="movie">

			</tbody>
		</table>
	</main>
	<script src="js/ListMovies-component.js"></script>
</body>
</html>
