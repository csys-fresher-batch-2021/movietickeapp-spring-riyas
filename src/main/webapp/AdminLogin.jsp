<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Administrator Login</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Admin Login</h3>
		<p id="message"></p>
		<form method="post" onsubmit="adminLogin()">
				<br> <label for="userName">User Name :</label> 
				<input type="text" name="userName" id="userName" autocomplete="off" required placeholder="Enter User Name" autofocus><br /> <br> 
				<label for="password">Password : </label> 
				<input type="password" name="password" id="password" autocomplete="off" required placeholder="Enter Password"><br/><br>
				<button class="btn btn-secondary" type="submit">Submit</button>
				<button class="btn btn-danger" type="reset">Reset</button>
			<br />
		</form>
	</main>
	<script>
		
		function adminLogin(){
			
			event.preventDefault();
			let userName = document.querySelector("#userName").value;
			let password = document.querySelector("#password").value;
			localStorage.setItem("role","ADMIN");
			let admin={
				    "userName" : userName,
				    "password" : password					    
				};
			
			console.log(admin);				
			let url = "AdminLoginServlet";
			content="";
			axios.post(url,admin).then(res=>{
				let data = res.data;
				console.log(data.infoMessage);
				alert(data.infoMessage);
				window.location.href="index.jsp";
			}).catch(err=>{
				console.log("Error");
				let data = err.response.data;
				console.log(data);	
				content+=data.errorMessage;
				document.querySelector("#message").innerHTML= content;
				
			});		
	}
	
	
	
	</script>
</body>
</html>
