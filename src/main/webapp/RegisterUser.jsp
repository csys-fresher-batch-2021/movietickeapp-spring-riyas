<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Register User</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="text-center">
			<h3>User Registration</h3>
			<p id="message"></p>
			<form method="post" onsubmit="addUser()">

				<br> <label for="name">Name :</label> <input type="text"
					name="name" id="name" autocomplete="off" required
					placeholder="Enter Your Name" autofocus><br /> <br> <label
					for="name">Email:</label> <input type="email" name="email"
					id="email" autocomplete="off" required
					placeholder="Enter Your Email"><br /> <br> <label
					for="name">Mobile Number:</label> <input type="number"
					name="mobileNumber" id="mobileNumber" autocomplete="off" required
					placeholder="Enter Your Mobile Number"><br /> <br> <label
					for="name">User Name :</label> <input type="text" name="userName"
					id="userName" autocomplete="off" required
					placeholder="Set Your User Name" autofocus><br /> <br>
				<br> <label for="name">Password:</label> <input type="password"
					name="password" id="password" autocomplete="off" required
					placeholder="Set Your Password" autofocus><br /> <br>
				<button class="btn btn-primary" type="submit">Register</button>
				<button class="btn btn-danger" type="reset">Reset</button>
				<br/>
			</form>			
		</div>
		<br>
		<br>
		<ul>
				<li><h6>User Name Must Contain 7-15 Characters.No Special
					Characters are Allowed</h6></li>
				<li><h6>Password Must Contain 7-15 Characters.Special Characters
					are Allowed</h6></li>
			</ul>
			<br/>
	</main>
	
	<script>
	
	function addUser(){
		
		event.preventDefault();
		let name = document.querySelector("#name").value;
		let userName = document.querySelector("#userName").value;
		let password = document.querySelector("#password").value;
		let email = document.querySelector("#email").value;
		let mobileNumber = document.querySelector("#mobileNumber").value;
		let user={
			    "name" : name,
			    "userName" : userName,
			    "password" : password,
			    "mobileNumber" : mobileNumber,
			    "email" : email
			};
		
		console.log(user);				
		let url = "RegisterUserServlet";
		content="";
		axios.post(url,user).then(res=>{
			let data = res.data;
			content+=data.infoMessage;
			document.querySelector("#message").innerHTML= content;
		}).catch(err=>{
			let data = err.response.data;
			content+=data.errorMessage;
			document.querySelector("#message").innerHTML= content;
			
		});
		
		
}	
	
	
	
	</script>
</body>
</html>
