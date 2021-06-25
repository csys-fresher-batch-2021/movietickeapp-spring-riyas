
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
				console.log(typeof data[i].showDate);
				let date = new Date();
				let today = date.toJSON().substring(0, 10);
				content+="<td>" + data[i].screen + "</td><td>" + data[i].seat.seatType + "</td>";
				content+="<td>" + data[i].noOfTickets + "</td><td>" + data[i].totalPrice + "</td>";
				content+="<td>" + data[i].status + "</td>";
				if(data[i].showDate > today && data[i].status == "BOOKED"){
				content+="<td><button class = 'btn btn-danger' onclick=\"cancel("+data[i].id +")\">Cancel</button</td></tr>";
				}}}else{
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
		
