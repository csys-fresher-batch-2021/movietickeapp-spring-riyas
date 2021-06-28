<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Register User</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="row">
			<div class="col sm-2"></div>
			<div class="col sm-8">
				<div class=" mt-4 card">
					<div class="card-header text-center">
						<h4>User Registration</h4>
					</div>
					<div class="card-body">
						<p id="message"></p>
						<form method="post" onsubmit="addUser()">
							<div class="form-group">
							<label for="name">Name :</label> 
							<div class="input-group">
							<div class="input-group-prepend">
							<span class="input-group-text">
							<em class="far fa-user"></em>
							</span>
							</div>
							<input type="text" name="name"	id="name" autocomplete="off" required
							    placeholder="Enter Your Name" class="form-control" autofocus>
							    </div>
							    </div>
							 <div class="form-group">
							<label 	for="name">Email:</label>
							<div class="input-group">
							<div class="input-group-prepend">
							<span class="input-group-text">
							<em class="far fa-envelope"></em>
							</span>
							</div>
							<input type="email" name="email" id="email" autocomplete="off" required
							    placeholder="Enter Your Email" class="form-control">
							 </div></div>
							  <div class="form-group">
							 <label for="name">Mobile Number:</label>
							 <div class="input-group">
							<div class="input-group-prepend">
							<span class="input-group-text">
							<em class="fas fa-phone"></em>
							</span>
							</div> 
							 <input type="number" name="mobileNumber" id="mobileNumber"	autocomplete="off" required
						    	placeholder="Enter Your Mobile Number" class="form-control">
						    	</div></div>
						     <div class="form-group">
							<label for="name">User Name :</label> 
							<div class="input-group">
							<div class="input-group-prepend">
							<span class="input-group-text">
							<em class="fas fa-users-cog"></em>
							</span>
							</div>
							<input type="text" name="userName" id="userName" autocomplete="off"	required
							     placeholder="Set Your User Name" class="form-control"	autofocus>
							</div></div>
							 <div class="form-group">
						  <label for="name">Password:</label>
						  <div class="input-group">
							<div class="input-group-prepend">
							<span class="input-group-text">
							<em class="fas fa-key"></em>
							</span>
							</div>
						  <input type="password" name="password" id="password" class="form-control" autocomplete="off" required
								 placeholder="Set Your Password" autofocus>
							</div></div>
                    <div class="ml-5 form-check">
                      <input type="checkbox" name="agreements" id="agreements" class="form-check-input"/>
               	       <label for="agreements" class="form-check-label">
                        I agree the Terms and Conditions.
                      </label>
                    </div><br/>
							 <div class="form-group text-center">
						<button class="btn btn-success" type="submit" class="form-control">Register</button>
						<button class="btn btn-secondary" type="reset" class="form-control">Reset</button>
							</div>
							</form>						
					</div>
				</div>
			</div>
			<div class="col sm-2"></div>
		</div>
		<br> <br>

	</main>
	<script src="js/RegisterUser-component.js"></script>
</body>
</html>
