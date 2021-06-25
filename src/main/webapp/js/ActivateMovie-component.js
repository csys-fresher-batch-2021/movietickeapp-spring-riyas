		let id = localStorage.getItem("id");
		let name= localStorage.getItem("name");
		document.querySelector("#name").value=name;
		document.querySelector("#id").value=id;
		
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
		
		function activateMovie(){
			event.preventDefault();
			let id = document.querySelector("#id").value;
			let screen = document.querySelector("#screen").value;
			const queryParams = "?id=" + id + "&screen=" + screen;
			let url = "activate" + queryParams ;	
			console.log(url);
			content="";
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
