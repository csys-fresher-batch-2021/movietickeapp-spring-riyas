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
					<th id="action">Action</th>
				</tr>
			</thead>
			<tbody id="movie">

			</tbody>
		</table>
		<script>
			function getAllMovies() {
				let url = "ListMoviesServlet";
				fetch(url).then(res=> res.json()).then(res=>{
				let movies=res;				
				let content="";				
				let i = 0;
				let role = localStorage.getItem("role");
				console.log(role);
				for(let movie of movies){
					content+="<tr><td>"+ ++i + "</td><td>" + movie.name  + "</td><td>" + movie.actor + "</td><td>"+ movie.screen + "</td>";
					if(role == "ADMIN"){
					if(movie.status == "ACTIVE"){
					content+="<td><button class = 'btn btn-danger' onclick=\"remove("+movie.id + "," + "'" +movie.screen +"')\">Remove</button</td></tr>"; 
				}else{
					content+="<td><button class = 'btn btn-primary' onclick=\"activate("+movie.id + "," + "'" +movie.name +"')\">Activate</button</td></tr>";
				}
				}
				}
				document.querySelector("#movie").innerHTML= content;
				});		
			}
			
			function remove(id,screen){				
				const queryParams = "?id=" + id + "&screen=" + screen;
				let url = "RemoveMovieServlet" + queryParams ;	
				console.log(url);
				content="";
				fetch(url).then(res=> res.json()).then(res=>{
					console.log("Success");
					let data = res;
					console.log(data);
					content+=data.infoMessage;
					alert(content);
					window.location.href = "ListMovies.jsp";
				}).catch(err=>{
					console.log("Error");
					let data = err.response;
					console.log(data);	
					content+=data.errorMessage;
					document.querySelector("#message").innerHTML= content;
					
				});
				}
				
			function activate(id,name){
				alert("function calls");
				localStorage.setItem("name",name);
				localStorage.setItem("id",id);
				window.location.href="ActivateMovie.jsp";
				}
			
				
				
				
			
			getAllMovies();
		</script>
	</main>
</body>
</html>
