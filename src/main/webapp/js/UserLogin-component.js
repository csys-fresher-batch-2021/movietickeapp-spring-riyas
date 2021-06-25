	
	function userLogin(){			
			event.preventDefault();
			let userName = document.querySelector("#userName").value;
			let password = document.querySelector("#password").value;
			localStorage.setItem("role","USER");
			let user={
				    "userName" : userName,
				    "password" : password					    
				};
			
			console.log(user);				
			let url = "userLogin";
			content="";
			axios.post(url,user).then(res=>{
				let data = res.data;
				console.log(data.infoMessage);
				toastr.success(data.infoMessage);
				setTimeout(function() {
				window.location.href = "index.jsp";
					},1000);
			}).catch(err=>{
				console.log("Error");
				let data = err.response.data;
				console.log(data);	
				content+=data.errorMessage;
				toastr.error(data.errorMessage);				
			});		
	}
	
	