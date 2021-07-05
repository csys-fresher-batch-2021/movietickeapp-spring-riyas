		let id = localStorage.getItem("id");
		let name= localStorage.getItem("name");
		document.querySelector("#name").value=name;
		document.querySelector("#id").value=id;
		
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
		
		function activateMovie(){
			event.preventDefault();
			let id = document.querySelector("#id").value;
			let screen = document.querySelector("#screen").value;
			const queryParams = "?id=" + id + "&screen=" + screen;
			let url = "activate" + queryParams ;	
			console.log(url);
			let content="";
			fetch(url).then(res=> res.json()).then(res=>{
				let data = res;
				content+=data.infoMessage;
				alert(content);
				window.location.href="ListMovies.jsp";
			}).catch(err=>{
				let data = err.response;
				console.log(data);	
				content+=data.errorMessage;
				document.querySelector("#message").innerHTML= content;				
			}); 
		}	
