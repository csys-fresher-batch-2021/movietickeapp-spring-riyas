function addUser(){
		
		event.preventDefault();
		let name = document.querySelector("#name").value;
		let userName = document.querySelector("#userName").value;
		let password = document.querySelector("#password").value;
		let email = document.querySelector("#email").value;
		let mobileNumber = document.querySelector("#mobileNumber").value;
		let user={
			    "name" : name,
			    "userName" : userName,
			    "password" : password,
			    "mobileNumber" : mobileNumber,
			    "email" : email
			};
		
		console.log(user);				
		let url = "register";
		let content="";
		axios.post(url,user).then(res=>{
			let data = res.data;
			content+=data.infoMessage;
			document.querySelector("#message").innerHTML= content;
		}).catch(err=>{
			let data = err.response.data;
			content+=data.errorMessage;
			document.querySelector("#message").innerHTML= content;
			
		});
		
		
}	
	