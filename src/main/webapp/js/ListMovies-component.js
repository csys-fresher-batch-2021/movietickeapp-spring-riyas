function getAllMovies() {
				let url = "movies";
				fetch(url).then(res=> res.json()).then(res=>{
				let movies=res;				
				let content="";				
				let i = 0;
				let role = localStorage.getItem("role");
				for(let movie of movies){
					
					if(role == "ADMIN"){
						content+="<tr><td>"+ ++i + "</td><td>" + movie.name  + "</td><td>" + movie.actor + "</td><td>"+ movie.screen + "</td>";
					if(movie.status == "ACTIVE"){
					content+="<td><button class = 'btn btn-danger' onclick=\"remove("+movie.id + "," + "'" +movie.screen +"')\">Remove</button</td></tr>"; 
				}else{
					content+="<td><button class = 'btn btn-primary' onclick=\"activate("+movie.id + "," + "'" +movie.name +"')\">Activate</button</td></tr>";
				}
				}else{
					if(movie.status == "ACTIVE"){
						content+="<tr><td>"+ ++i + "</td><td>" + movie.name  + "</td><td>" + movie.actor + "</td><td>"+ movie.screen + "</td>";
					}
				}
				}
				document.querySelector("#movie").innerHTML= content;
				});		
			}
			
			function remove(id,screen){				
				const queryParams = "?id=" + id + "&screen=" + screen;
				let url = "remove" + queryParams ;	
				console.log(url);
				let content="";
				fetch(url).then(res=> res.json()).then(res=>{
					console.log("Success");
					let data = res;
					console.log(data);
					content+=data.infoMessage;
					alert(content);
					window.location.href = "ListMovies.jsp";
				}).catch(err=>{
					console.log("Error");
					let data = err.response;
					console.log(data);	
					content+=data.errorMessage;
					document.querySelector("#message").innerHTML= content;
					
				});
				}
				
			function activate(id,name){
				localStorage.setItem("name",name);
				localStorage.setItem("id",id);
				window.location.href="ActivateMovie.jsp";
				}	
					
getAllMovies();
