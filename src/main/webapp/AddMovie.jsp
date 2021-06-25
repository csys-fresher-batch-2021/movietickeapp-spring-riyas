<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Movie</title>
</head>
<body onload="getAvailableScreens()">
	<jsp:include page="Header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add Movie</h3>
		<form method="post" onsubmit="addMovie()">
			<p id="message"></p>
			<br> <label for="name">Movie Name :</label> 
				<input type="text" name="movie" id="movie" autocomplete="off" required placeholder="Enter Movie Name" autofocus><br /> <br> 
				<label for="name">Actor:</label> 
				<input type="text" name="actor" id="actor" autocomplete="off" required placeholder="Enter Actor Name"><br />
				<br><label for="name">Rating:</label> 
				<input type="number" name="rating" id="rating" autocomplete="off" required placeholder="Enter Rating" step="0.01"><br /> <br>
				<label for="screen">Select Screen</label>
				<p id ="screens"></p>
				
			<button class="btn btn-secondary" type="submit">Add Movie</button>
			<button class="btn btn-danger" type="reset">Reset</button>
			<br />
			
		</form>
	</main>
	<script src="js/AddMovie-component.js"></script>
</body>
</html>
