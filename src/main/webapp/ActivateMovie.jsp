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
		<h3>Activate Movie</h3>
		<form method="get" onsubmit="activateMovie()">
			<p id="message"></p>
			<br> <label for="name">Movie Name :</label> 
				<input type="text" name="name" id="name" autocomplete="off" required placeholder="Enter Movie Name" readonly><br /> <br>
				<input id="id" name="id" type="hidden"> 
				<label for="screen">Select Screen</label>
				<p id ="screens"></p>
				
			<button class="btn btn-primary" type="submit">Activate Movie</button>
			<button class="btn btn-danger" type="reset">Reset</button>
			<br />
			
		</form>
</main>
<script src="js/ActivateMovie-component.js"></script>
</body>
</html>
