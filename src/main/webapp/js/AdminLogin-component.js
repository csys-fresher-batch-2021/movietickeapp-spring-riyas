	function adminLogin(){
			
			event.preventDefault();
			let userName = document.querySelector("#userName").value;
			let password = document.querySelector("#password").value;
			localStorage.setItem("role","ADMIN");
			let admin={
				    "userName" : userName,
				    "password" : password					    
				};			
			console.log(admin);				
			let url = "adminLogin";
			let content="";
			axios.post(url,admin).then(res=>{
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
				toastr.error(content);				
			});		
	}
	
	
	