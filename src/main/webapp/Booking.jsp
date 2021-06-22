<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Booking</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>

	<main class="container-fluid">

		<div class="text-center">
			<br>
			<h3>Booking</h3>
			<form onsubmit="book()">
				<input type="hidden" name="movieId" id="movieId" required readonly />
				<br> <label for="name">Movie Name: </label> <input type="text"
					name="name" id="name" readonly><br /> <br> <label
					for="actor">Actor Name: </label> <input type="text" name="actor"
					id="actor" readonly><br /> <br> <label for="date">
					Date: </label> <input type="date" id="date" name="date" required readonly><br />
				<br>
				<label for="time"> Show Time: </label> <input type="time" id="time"
					name="time" required readonly><br /> <br>
				<label for="seat"> Seat Type: </label> <input type="text" id="seat"
					name="seat" required readonly><br /> <br>
				<label for="screen"> Screen: </label> <input type="text" id="screen"
					name="screen" required readonly><br /> <br> <label
					for="tickets">Number of Tickets : </label> <input type="number"
					name="tickets" id="tickets" min=1 oninput="getPrice()" required><br />
				<br> <label for="price">Total Price: </label> <input
					type="number" name="price" id="price" required readonly><br />
				<br>
				<button class="btn btn-primary" type="submit">Book</button>
				<a class="btn btn-danger" href="index.jsp " type="reset">Cancel</a>
				<br />
			</form>
		</div>
		<script>
		
		 getShowDetails();
		 getAvailableTickets();
		 
		 
		
		 function getPrice(){
			
			event.preventDefault();			
			let seatType = document.querySelector("#seat").value;
			let tickets = document.querySelector("#tickets").value;
			const queryParams = "?seatType=" + seatType + "&tickets=" + tickets;
			let url = "GetPriceServlet" + queryParams ;				
			fetch(url).then(res=> res.json()).then(res=>{				
				let result=res;								
				if(result!= 0){
					document.querySelector("#price").value = result;
				}else{
					document.querySelector("#price").value =0;
				}
			
			
		});
		}
 		 
 		 
 		 function getShowDetails(){
 			let movie = JSON.parse(localStorage.getItem('MOVIE'));			
 			let showDate = localStorage.getItem('DATE');
 			let showTime = localStorage.getItem('TIME');
 			let seatType = localStorage.getItem('SEAT');
 			document.querySelector("#date").value = showDate;
 			document.querySelector("#time").value = showTime;
 			document.querySelector("#seat").value = seatType;
 			document.querySelector("#name").value = movie.name;
 			document.querySelector("#actor").value = movie.actor;
 			document.querySelector("#screen").value = movie.screen;
 			document.querySelector("#movieId").value = movie.id;
  		 }
 		 
 		 function book(){
 			 
 			event.preventDefault();				 
 			let movieId = document.querySelector("#movieId").value; 
 			let showDate = document.querySelector("#date").value;
 			let showTime = document.querySelector("#time").value;
 			let seatType = document.querySelector("#seat").value;
 			let tickets = document.querySelector("#tickets").value;
 			let price  =  document.querySelector("#price").value;
 			let screen = document.querySelector("#screen").value ;
 			let ticket={
				    "movieId" : movieId,
				    "noOfTickets" : tickets,
				    "totalPrice" : price,
				    "showDate" : showDate,
				    "seatType" : seatType,
				    "screen" : screen,
				    "showTime" : showTime
				};
 			let url = "BookMovieServlet";
 			 let content="";
 			axios.post(url,ticket).then(res=>{
				console.log("Success");
				let data = res.data;
				console.log(data);
				content+=data.infoMessage;
				alert(content);
			}).catch(err=>{
				console.log("Error");
				let data = err.response.data;
				console.log(data);	
				content+=data.errorMessage;
				alert(content);				
			});
 		 }
 		 
 		 function getAvailableTickets(){ 			 
 			let movie = JSON.parse(localStorage.getItem('MOVIE'));
 			 let movieId = movie.id.toString();
 			 let availableTicketsObj = JSON.parse(localStorage.getItem('TICKETS_AVAILABLE'));
 		    let availableTicketsMap = new Map(Object.entries(availableTicketsObj));
 		   let availableTickets = availableTicketsMap.get(movieId);
 		  document.querySelector("#tickets").setAttribute("max", availableTickets);
 		   
 		 }
 		 
 		
		</script>


	</main>
</body>
</html>
