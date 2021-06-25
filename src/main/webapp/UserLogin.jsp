<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>User Login</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>User Login</h3>
		<p id="message"></p>
		<form method="post" onsubmit="userLogin()">
				<br> <label for="userName">User Name :</label> 
				<input type="text" name="userName" id="userName" autocomplete="off" required placeholder="Enter User Name" autofocus><br /> <br> 
				<label for="password">Password : </label> 
				<input type="password" name="password" id="password" autocomplete="off" required placeholder="Enter Password"><br/><br>
				<button class="btn btn-secondary" type="submit">Submit</button>
				<button class="btn btn-danger" type="reset">Reset</button>
			<br />
		</form>
	</main>
	<script src="js/UserLogin-component.js"></script>
</body>
</html>
