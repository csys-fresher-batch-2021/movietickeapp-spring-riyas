getShowDetails();
		 getAvailableTickets();
		 
		 
		
		 function getPrice(){
			
			event.preventDefault();			
			let seatType = document.querySelector("#seat").value;
			let tickets = document.querySelector("#tickets").value;
			const queryParams = "?seatType=" + seatType + "&tickets=" + tickets;
			let url = "price" + queryParams ;				
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
 			let url = "book";
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
 		 
 		
