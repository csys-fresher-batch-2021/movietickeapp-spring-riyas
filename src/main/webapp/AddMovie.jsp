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

		<script>
		
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
			
			function addMovie(){
				
				event.preventDefault();
				let movieName = document.querySelector("#movie").value;
				let actorName = document.querySelector("#actor").value;
				let rating = document.querySelector("#rating").value;
				let screen = document.querySelector("#screen").value;
				let movie={
					    "name" : movieName,
					    "actor" : actorName,
					    "rating" : rating,
					    "screen" : screen					    
					};
				
				console.log(movie);				
				let url = "AddMovieServlet";
				content="";
				axios.post(url,movie).then(res=>{
					console.log("Success");
					let data = res.data;
					console.log(data);
					content+=data.infoMessage;
					document.querySelector("#message").innerHTML= content;
				}).catch(err=>{
					console.log("Error");
					let data = err.response.data;
					console.log(data);	
					content+=data.errorMessage;
					document.querySelector("#message").innerHTML= content;
					
				});
				
				
		}	
			

		</script>

	</main>
</body>
</html>
