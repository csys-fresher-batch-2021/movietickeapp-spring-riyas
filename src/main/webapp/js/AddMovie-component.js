function getAvailableScreens(){
			let url = "screens";
			fetch(url).then(res=> res.json()).then(res=>{
			let screens=res;
			if (Object.keys(screens).length === 0) {
				alert("No Screens Available");
				window.location.href="ListMovies.jsp";
				}						
			let content="";	
			content+=" <div class='form-group row'>";
			content+="<label for='screen'class='col-sm-4 col-form-label'>Select Screen</label>";
			content+="<div class='input-group col-sm-8'>";	
			content+="<div class='input-group-prepend'><span class='input-group-text'><em class='fas fa-tv'></em>";
			content+="</span></div>";		
			content+= "<select name='screen' id='screen' class='form-control' required>";
			content+="<option disabled selected>Select Screen</option>";				
			for(let screen of screens){
				console.log(screen);
				console.log("OK");
				content+="<option value = '" + screen + "' class='form-control' > "+ screen + "</option>";	
			}				
			content+="</select></div></div>";	
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
				let content="";
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
			

