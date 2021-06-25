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
			content="";
			axios.post(url,admin).then(res=>{
				let data = res.data;
				console.log(data.infoMessage);
				alert(data.infoMessage);
				window.location.href="index.jsp";
			}).catch(err=>{
				console.log("Error");
				let data = err.response.data;
				console.log(data);	
				content+=data.errorMessage;
				document.querySelector("#message").innerHTML= content;
				
			});		
	}
	
	
	