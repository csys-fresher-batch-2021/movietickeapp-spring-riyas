function getAvailableScreens(){
			let url = "screens";
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
				let url = "save";
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
			

