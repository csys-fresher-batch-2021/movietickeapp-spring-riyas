<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Movie</title>
</head>
<body onload="getAvailableScreens()">
	<jsp:include page="Header.jsp"></jsp:include>
	<main class="container-fluid">
		 <div class="row">
			<div class="col sm-2"></div>
			<div class="col sm-8">
				<div class=" mt-4 card">
					<div class="card-header text-center">
						<h4>Add Movie</h4>
					</div>
					<div class="card-body">	    
			<form method="post" onsubmit="addMovie()">
			<p id="message"></p> 
			<div class="form-group row">
			<label for="name" class="col-sm-4 col-form-label">Movie Name :</label> 
			<div class="input-group col-sm-8">
					<div class="input-group-prepend">
						<span class="input-group-text">
							<em class="fas fa-film"></em>
						</span>
					</div>			
				<input type="text" name="movie" id="movie" autocomplete="off" class="form-control" required placeholder="Enter Movie Name" autofocus> 
				</div></div>
				 <div class="form-group row">
				<label for="name" class="col-sm-4 col-form-label">Actor:</label> 
				 <div class="input-group col-sm-8">
					<div class="input-group-prepend">
						<span class="input-group-text">
							<em class="far fa-user"></em>
						</span>
					</div>
				<input type="text" name="actor" id="actor" autocomplete="off" class="form-control"  required placeholder="Enter Actor Name">
				</div></div>
				 <div class="form-group row">
				<label for="name" class="col-sm-4 col-form-label">Rating:</label> 
				 <div class="input-group col-sm-8">
					<div class="input-group-prepend">
						<span class="input-group-text">
						<em class="fas fa-star"></em>	
						</span>
					</div>
				<input type="number" name="rating" id="rating" class="form-control"  required placeholder="Enter Rating" step="0.01">
				</div></div>
				<p id ="screens"></p>	
			 <div class="form-group text-center">			
			<button class="btn btn-primary" type="submit">
			<em class="fas fa-bookmark"></em>
			Add Movie</button>
			<button class="btn btn-danger" type="reset">Reset</button>
			</div>			
		</form>
		</div>
			</div>
			</div>
			<div class="col sm-2"></div>
		</div>
	</main>
	<script src="js/AddMovie-component.js"></script>
</body>
</html>
