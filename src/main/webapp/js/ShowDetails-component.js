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
				console.log(typeof date1);
				let url = "showtimes";
				fetch(url).then(res=> res.json()).then(res=>{
				let showTimes=res;
				let content="<br/>Show Time :" +"  ";	
				for(let time of showTimes){
					let showHour = parseInt(time.split(":")[0]);
					let todayDate = new Date();
					let hour = todayDate.getHours();
					let todayStr = todayDate.toJSON().substring(0, 10);
					if(todayStr == date1){
					if(showHour > hour){

						content+=
				    	 "<input type=\"radio\" name=\"showTiming\" id=\"showTiming\""+
						"value =\""+time+"\" required >" + showHour + ":00 " ;
				    	console.log(time);
					} }else{
						content+=
					    	"<input type=\"radio\" name=\"showTiming\" id=\"showTiming\""+
							"value =\""+time+"\" required >" + showHour + ":00 " ;
					}
				}
				document.querySelector("#showTimes").innerHTML= content;
				});
			}
			
			function getSeatTypes(){
				let url = "seats";
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
				let url = "movies";
				fetch(url).then(res=> res.json()).then(res=>{
				let movies=res;				
				let content="";				
				let i = 0;
				let role = localStorage.getItem("role");
				console.log(role);
				content+="<br/><table class='table table-bordered'>";
				content+="<thead><tr><th>S.No</th><th>Movie Name</th><th>Actor Name</th><th>Screen</th><th>Available Tickets</th><th>Book</th></tr></thead>";
				content+="<tbody id='movie-detail-tbody'>";
				for(let movie of movies){
					
					if(movie.status == "ACTIVE"){
					content+="<tr><td>"+ ++i + "</td><td>" + movie.name  + "</td><td>" + movie.actor + "</td><td>"+ movie.screen + "</td><td id='ticket-available' data-movie-id=" + movie.id + ">Loading</td>";
					let obj = JSON.stringify(movie);
					content+="<td><button class = 'btn btn-primary' onclick='book("+obj+")'>Book</button</td></tr>"
					}
					}
				content+="</tbody></table>";
				document.querySelector("#movie").innerHTML= content;
				getBookedTickets();
				});	
				
				
			}
				
			
			function getBookedTickets(){
				
				let showDate = document.querySelector("#showDate").value;
				localStorage.setItem("DATE",showDate);
				let showTimeOptions = document.querySelectorAll("#showTiming");
				let showTime;
				showTimeOptions.forEach(r=> {				
				if (r.checked){
				  console.log(r.value);
					 showTime = r.value;
				   localStorage.setItem("TIME",showTime);
				}
				});	
				 let seatType;
				let seatTypeOptions = document.querySelectorAll("#seatType");
				seatTypeOptions.forEach(r=> {
				if (r.checked){
				  console.log(r.value);
				 seatType = r.value;
				  localStorage.setItem("SEAT",seatType);
				}
				});
				let ticket={
					    "showDate" : showDate,
					    "showTime" : showTime,
					    "seatType" : seatType,				    
					};	
				let url = "bookedTickets";
				let ticketsAvailable=0;
				
				axios.post(url,ticket).then(res=>{
					let tickets = res.data;
					let ticketAvailableMap = {};
					
					if(seatType == "Gold"){
						ticketsAvailable = 50;
					}else if(seatType == "Silver"){
						ticketsAvailable = 20;
					}else if(seatType == "Platinum"){
						ticketsAvailable = 80;
					}
				    let ticketsMap = new Map(Object.entries(tickets));				    										
				//Find tds
					let tds = document.querySelectorAll("#ticket-available");
					tds.forEach(td=>{
						let movieId = td.getAttribute("data-movie-id"); 
						
						let sum = ticketsMap.has(movieId)? ticketsMap.get(movieId): 0;
						
						ticketsAvailable = ticketsAvailable - sum;
						ticketAvailableMap[movieId]= ticketsAvailable;
						td.innerHTML =ticketsAvailable;  
						});
					localStorage.setItem("TICKETS_AVAILABLE", JSON.stringify(ticketAvailableMap));
				}).
				catch(err =>{
					console.log("Error", err);
					let data = err.response.data;
					console.log(data);	
					
				
				});
				
			}
			
			function book(movie){
				event.preventDefault();
				localStorage.setItem("MOVIE",JSON.stringify(movie));				
				window.location.href = "Booking.jsp";
			}
			
			
						
