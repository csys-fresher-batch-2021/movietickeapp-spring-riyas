function filterDetails(){
			
			event.preventDefault();			
			let filterDate = document.querySelector("#date").value;
			console.log(filterDate);
			let movie = document.querySelector("#movie").value;
			console.log(movie);
			let status = document.querySelector("#status").value;
			console.log(status);		
			let url = "bookings";
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
			let i;
			 $("#bookingsTable tbody").empty();
			if(data.length != 0){
			 for(i = 0; i < data.length; i++){				 
				content+="<tr><td>"+ ++j + "</td><td>" + data[i].id + "</td><td>" + data[i].user.name  + "</td>";
				content+="<td>" + data[i].user.mobileNumber + "</td><td>" + data[i].movie.id + "</td>";
				let arr = data[i].bookingDate.split('-') ;
				let bookedDate = arr[2] + "-" + arr[1] + "-" + arr[0];
				content+="<td>" + data[i].movie.name + "</td><td>" + bookedDate + "</td>";
				let arr1 = data[i].showDate.split('-') ;
				let showDate = arr1[2] + "-" + arr1[1] + "-" + arr1[0];
				content+="<td>" + showDate + "</td><td>" + data[i].showTime + "</td>";
				content+="<td>" + data[i].screen + "</td><td>" + data[i].seat.seatType + "</td>";
				content+="<td>" + data[i].noOfTickets + "</td><td>" + data[i].totalPrice + "</td>";
				content+="<td>" + data[i].status + "</td></tr>";
			}}else{
				content+="<tr><td colspan=14 class='text-center'>" + "No Records Found" + "</td></tr>"; 
			}
			$("#bookingsTable tbody").append(content);
			  $('#bookingsTable').DataTable();
			
			//document.querySelector("#bookings").innerHTML= content;
			}		
		