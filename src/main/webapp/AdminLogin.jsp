<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Administrator Login</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<main class="container-fluid">
	<p id="message"></p>
		 <div class="row">
        <div class="col-md-4 mx-auto">
          <div class="card mt-5">
          <div class="card-header text-center">
          <h5>Administrator Login</h5>
          </div>
            <div class="card-body">
              <form method="post" onsubmit="adminLogin()">
                <div class="form-group row">		
				 <label for="userName" class="col-sm-4 col-form-label">User Name :</label> 
				 <div class="input-group col-sm-8">
				<div class="input-group-prepend">
				<span class="input-group-text">
				<em class="far fa-user"></em>
				</span>
				</div>				
				<input type="text" name="userName" id="userName"  class="form-control" required placeholder="Enter User Name" autofocus> 
				  </div>
                </div>
                <div class="form-group row">
				<label for="password" class="col-sm-4 col-form-label">Password : </label> 
				 <div class="input-group col-sm-8">
				<div class="input-group-prepend">
				<span class="input-group-text">
				<em class="fas fa-key"></em>
				</span>
				</div>
				<input type="password" name="password" id="password" class="form-control" required placeholder="Enter Password">
				</div>
                </div>
                 <div class="form-group row">
                  <div class="col-sm-3"></div>
                  <div class="col-sm-9">
				<button class="btn btn-success" type="submit">
				<em class="fa fa-unlock-alt mr-2"></em>
				Submit</button>
				<button class="btn btn-secondary" type="reset">Reset</button>
				</div>
                </div>
		</form>
		 </div>
          </div>
        </div>
      </div>
	</main>
	<script src="js/AdminLogin-component.js"></script>
</body>
</html>
