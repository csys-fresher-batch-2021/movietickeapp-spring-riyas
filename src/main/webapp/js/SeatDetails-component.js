function getSeatTypes() {
				let url = "seats";
				fetch(url).then(res=> res.json()).then(res=>{
				let seatTypes=res;				
				let content="";				
				let i = 0;
				for(let seat of seatTypes){
					content+="<tr><td>"+ ++i + "</td><td>" + seat.seatType + "</td><td> Rs. " + seat.price + "</td></tr>";	
				}				
				document.querySelector("#seat").innerHTML= content;
				});		
			}
			
			getSeatTypes();
