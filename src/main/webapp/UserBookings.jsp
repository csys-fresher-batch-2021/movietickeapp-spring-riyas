<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bookings</title>
</head>
<body onload="filterDetails()">
	<jsp:include page="Header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>My Bookings</h3>
		<p id="message"></p>
		<form>
			<br> <input type="date" id="date" name="date"
				onchange="filterDetails()"> <input type="text" id="movie"
				name="movie" oninput="filterDetails()" placeholder="Movie Name">
			<select id="status" name="status" onchange="filterDetails()">
				<option value="" selected>All</option>
				<option value="BOOKED">Booked</option>
				<option value="CANCELLED">Cancelled</option>
				<option value="FINISHED">FINISHED</option>
			</select>
			<button type="reset" class="btn btn-primary" onclick="clearFilters()">Clear
				Filters</button>
		</form>
		<table class="table table-bordered">
			<caption>This Table is for Showing Booking Details</caption>
			<thead>
				<tr>
					<th id="S.no">S.no</th>
					<th id="bookingId">Booking ID</th>
					<th id="user">Name of the User</th>
					<th id="mobileNumber">Mobile Number</th>
					<th id="movieId">Movie ID</th>
					<th id="movieName">Movie Name</th>
					<th id="bookedDate">Booked Date</th>
					<th id="showDate">Show Date</th>
					<th id="showTime">Show Time</th>
					<th id="screen">Screen</th>
					<th id="seatType">Seat Type</th>
					<th id="tickets">Number of Tickets</th>
					<th id="price">Total Price</th>
					<th id="status">Status</th>
					<th id="action">Cancel</th>
				</tr>
			</thead>
			<tbody id="bookings">

			</tbody>
		</table>

		<script type="text/javascript">
		
		
		function filterDetails(){
			
			event.preventDefault();			
			let filterDate = document.querySelector("#date").value;
			console.log(filterDate);
			let movie = document.querySelector("#movie").value;
			console.log(movie);
			let status = document.querySelector("#status").value;
			console.log(status);		
			let url = "userBookings";
			fetch(url).then(res=>res.json()).then(res=>{
			let data = [];			
			data = res;			
			if(movie!=""){
				data=filterMovies(data,movie);
			}
			if(status!=""){
				data=filterStatus(data,status);
			}
			
		 	if(filterDate!=""){
				data= dateFilter(data,filterDate);
		} 		
			displayDetails(data);
			});
			}
			
		  function filterMovies(res,movie){	
			 data = res.filter(res =>  res.movie.name.toLowerCase().includes(movie.toLowerCase()));
			 return data;		 
			 } 
		
			 function filterStatus(res,status){
				 data = res.filter(res =>  res.status.toLowerCase().includes(status.toLowerCase()));
				 return data;
			 }
			
			 function dateFilter(res,filterDate){
			 data = res.filter(res => JSON.stringify(res.showDate).includes(filterDate));
			 return data;
			 }
			 
			 function clearFilters(){
				 
				 event.preventDefault();
				 	 document.querySelector("#date").value = "";
					document.querySelector("#movie").value = "";
					 document.querySelector("#status").value ="";					
					filterDetails();
			 }
			 
		function displayDetails(data){				
			let content="";		
			let j=0;
			if(data.length != 0){
			 for(i = 0; i < data.length; i++){				 
				content+="<tr><td>"+ ++j + "</td><td>" + data[i].id + "</td><td>" + data[i].user.name  + "</td>";
				content+="<td>" + data[i].user.mobileNumber + "</td><td>" + data[i].movie.id + "</td>";
				content+="<td>" + data[i].movie.name + "</td><td>" + data[i].bookingDate + "</td>";
				content+="<td>" + data[i].showDate + "</td><td>" + data[i].showTime + "</td>";
				content+="<td>" + data[i].screen + "</td><td>" + data[i].seat.seatType + "</td>";
				content+="<td>" + data[i].noOfTickets + "</td><td>" + data[i].totalPrice + "</td>";
				content+="<td>" + data[i].status + "</td>";
				content+="<td><button class = 'btn btn-danger' onclick=\"cancel("+data[i].id +")\">Cancel</button</td></tr>";
			}}else{
				content+="<tr><td colspan=14 class='text-center'>" + "No Records Found" + "</td></tr>"; 
			}
			document.querySelector("#bookings").innerHTML= content;
			}
		
		function cancel(id){
			event.preventDefault();
			const queryParams = "?id="+id;
			let url = "cancel" + queryParams ;	
			console.log(url);
			content="";
			fetch(url).then(res=> res.json()).then(res=>{
				console.log("Success");
				let data = res;
				console.log(data);
				content+=data.infoMessage;
				alert(content);
				window.location.href = "UserBookings.jsp";
			}).catch(err=>{
				console.log("Error");
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
