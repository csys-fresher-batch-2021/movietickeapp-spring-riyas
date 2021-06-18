<%@page import="in.riyasahamed.service.SeatService"%>
<%@page import="java.time.LocalTime"%>
<%@page import="in.riyasahamed.dto.TicketDTO"%>
<%@page import="java.util.Map"%>
<%@page import="in.riyasahamed.model.Movie"%>
<%@page import="java.util.List"%>
<%@page import="in.riyasahamed.service.MovieService"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Book Movie</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="text-center">
			<h4>Select Date and Show Time</h4>
			<form onsubmit="getMovies()">
				<br> <label for="showDate">Enter Show Date :</label> <input
					type="date" placeholder="ShowDate" id="showDate" name="showDate"
					required onchange="getShowTimes()"><br />				
				<div id="showTimes"></div>
				<div id="seatTypes"></div><br/>
				<button type="submit" class="btn btn-primary">Search</button>
				<div id="movie"></div>
				<br>
				
				<br/>

			</form>
		</div>
		<br>
	</main>

	<script>
			let date = new Date();
			date.setDate(date.getDate());
			let today = date.toJSON().substring(0, 10);
			document.querySelector("#showDate").setAttribute("min", today);

			let endDate = new Date();
			endDate.setDate(endDate.getDate() + 10);
			let maxDate = endDate.toJSON().substring(0, 10);
			document.querySelector("#showDate").setAttribute("max", maxDate);
			
			getSeatTypes();
			
			function getShowTimes(){
				
				
				let date1 = document.querySelector("#showDate").value;
				console.log(date1);
				document.querySelector("#showDate").setAttribute("value", date1);
				console.log(typeof date1);
				let url = "ShowTimesServlet";
				fetch(url).then(res=> res.json()).then(res=>{
				let showTimes=res;
				let content="<br/>Show Time :" +"  ";	
				for(let time of showTimes){
					let showHour = parseInt(time.split(":")[0]);
					let date = new Date();
					let hour = date.getHours();
					let today = date.toJSON().substring(0, 10);
					console.log(hour);	
					console.log(date);
					if(today == date1){
					if(showHour > hour){

						content+=
				    	 "<input type=\"radio\" name=\"showTime\" id=\"showTime\""+
						"value =\""+time+"\" required >" + showHour + ":00 " ;
				    	console.log(time);
					} }else{
						content+=
					    	"<input type=\"radio\" name=\"showTime\" id=\"showTime\""+
							"value =\""+time+"\" required >" + showHour + ":00 " ;
					}
				}
				document.querySelector("#showTimes").innerHTML= content;
				});
			}
			
			function getSeatTypes(){
				let url = "SeatDetailsServlet";
				fetch(url).then(res=> res.json()).then(res=>{
				let seatTypes=res;							
				let content="<br/>Seat Type :" +"  ";
				for(let seat of seatTypes){
					content+=
				    	 "<input type=\"radio\" name=\"seatType\" id=\"seatType\""+
						"value =\""+seat.seatType+"\" required >" + " "+ seat.seatType + "  " ;	
				}				
				document.querySelector("#seatTypes").innerHTML= content;
				});		
				}
			
			function getMovies(){
				
				event.preventDefault();
				let url = "ListMoviesServlet";
				fetch(url).then(res=> res.json()).then(res=>{
				let movies=res;				
				let content="";				
				let i = 0;
				let role = localStorage.getItem("role");
				console.log(role);
				let tickets1 = getBookedTickets();
				console.log(tickets1);
				content+="<br/><table class='table table-bordered'>";
				content+="<thead><tr><th>S.No</th><th>Movie Name</th><th>Actor Name</th><th>Screen</th></tr></thead>";
				for(let movie of movies){					
					content+="<tbody><tr><td>"+ ++i + "</td><td>" + movie.name  + "</td><td>" + movie.actor + "</td><td>"+ movie.screen + "</td></tboby>";
				}
				content+="</table>";
				document.querySelector("#movie").innerHTML= content;
				});	
				
			}
			
			function getBookedTickets(){
				
				let showDate = document.querySelector("#showDate").value;
				let showTime = document.querySelector("#showTime").value;
				let seatType = document.querySelector("#seatType").value;
				let ticket={
					    "showDate" : showDate,
					    "showTime" : showTime,
					    "seatType" : seatType,				    
					};
				
				console.log(ticket);				
				let url = "BookedTicketsServlet";
				axios.post(url,ticket).then(res=>{
					console.log("Success");
					let data = res.data;
					console.log(data);
					return data;
				}).catch(err=>{
					console.log("Error");
					let data = err.response.data;
					console.log(data);	
					
				});
				
			}
			
			
						
		</script>

</body>
</html>
