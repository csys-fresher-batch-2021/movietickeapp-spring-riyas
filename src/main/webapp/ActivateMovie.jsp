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

		<script>
		
		let id = localStorage.getItem("id");
		let name= localStorage.getItem("name");
		document.querySelector("#name").value=name;
		document.querySelector("#id").value=id;
		
		function getAvailableScreens(){
			let url = "ListScreenServlet";
			fetch(url).then(res=> res.json()).then(res=>{
			let screens=res;				
			let content="";				
			let i = 0;
			content+= "<select name='screen' id='screen' required>";
			content+="<option disabled selected>Select Screen</option>";				
			for(let screen of screens){
				console.log(screen);
				content+="<option value = '" + screen + "' > "+ screen + "</option>";	
			}				
			content+="</select><br>";	
			document.querySelector("#screens").innerHTML= content;
			});	
			
		}	
		
		function activateMovie(){
			event.preventDefault();
			let id = document.querySelector("#id").value;
			let screen = document.querySelector("#screen").value;
			const queryParams = "?id=" + id + "&screen=" + screen;
			let url = "ActivateMovieServlet" + queryParams ;	
			console.log(url);
			content="";
			fetch(url).then(res=> res.json()).then(res=>{
				let data = res;
				content+=data.infoMessage;
				alert(content);
				window.location.href="ListMovies.jsp";
			}).catch(err=>{
				let data = err.response;
				console.log(data);	
				content+=data.errorMessage;
				document.querySelector("#message").innerHTML= content;				
			}); 
		}	

		</script>

	</main>
</body>
</html>
