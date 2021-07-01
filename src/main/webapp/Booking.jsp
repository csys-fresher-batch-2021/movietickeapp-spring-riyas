<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Booking</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>

	<main class="container-fluid">

		<div class="row">
			<div class="col sm-2"></div>
			<div class="col sm-8">
				<div class=" mt-4 card">
					<div class="card-header text-center">
						<h4>Booking Details</h4>
					</div>
					<div class="card-body">		
			<form onsubmit="book()">
				<input type="hidden" name="movieId" id="movieId" class="form-control" required readonly />
				 <div class="form-group row">
				 <label for="name" class="col-sm-4 col-form-label">Movie Name: </label> 
				 <div class="input-group col-sm-8">
					<div class="input-group-prepend">
						<span class="input-group-text">
							<em class="fas fa-film"></em>
						</span>
					</div>
				 <input type="text" name="name" id="name" class="form-control" readonly>
				 </div></div>
				 <div class="form-group row">
				 <label	for="actor" class="col-sm-4 col-form-label">Actor Name: </label> 
				 <div class="input-group col-sm-8">
					<div class="input-group-prepend">
						<span class="input-group-text">
							<em class="far fa-user"></em>
						</span>
					</div>
				 <input type="text" name="actor" id="actor" class="form-control" readonly>
				 </div></div>
				 <div class="form-group row"> 
				 <label for="date" class="col-sm-4 col-form-label">	Date: </label> 
				 <div class="input-group col-sm-8">
					<div class="input-group-prepend">
						<span class="input-group-text">
							<em class="fas fa-calendar-week"></em>
						</span>
					</div>
				 <input type="date" id="date" name="date" class="form-control" required readonly>
				  </div></div>
				 <div class="form-group row">
				<label for="time" class="col-sm-4 col-form-label"> Show Time: </label> 
				<div class="input-group col-sm-8">
					<div class="input-group-prepend">
						<span class="input-group-text">
							<em class="far fa-user"></em>
						</span>
					</div>
				<input type="time" id="time" name="time" class="form-control" required readonly>
				</div></div>
				 <div class="form-group row">
				<label for="seat" class="col-sm-4 col-form-label"> Seat Type: </label> 
				<div class="input-group col-sm-8">
					<div class="input-group-prepend">
						<span class="input-group-text">
							<em class="fas fa-clock"></em>
						</span>
					</div>
				<input type="text" id="seat" name="seat" class="form-control" required readonly>
				</div></div>
				 <div class="form-group row">
				<label for="screen" class="col-sm-4 col-form-label"> Screen: </label> 
				<div class="input-group col-sm-8">
					<div class="input-group-prepend">
						<span class="input-group-text">
							<em class="fas fa-tv"></em>
						</span>
					</div>
				<input type="text" id="screen" name="screen" class="form-control" required readonly> 
				</div></div>
				 <div class="form-group row">
				<label 	for="tickets" class="col-sm-4 col-form-label">Tickets : </label>
					<div class="input-group col-sm-8">
					<div class="input-group-prepend">
						<span class="input-group-text">
							<em class="fas fa-ticket-alt"></em>
						</span>
					</div>
					 <input type="number" name="tickets" id="tickets" min=1 oninput="getPrice()" class="form-control" required>
					</div></div>
					 <div class="form-group row">
					 <label for="price" class="col-sm-4 col-form-label">Total Price: </label>
					 <div class="input-group col-sm-8">
					<div class="input-group-prepend">
						<span class="input-group-text">
							<em class="fas fa-rupee-sign"></em>
						</span>
					</div>
					  <input type="number" name="price" id="price" class="form-control" required readonly>
					  </div></div>
					   <div class="form-group text-center">
				<button class="btn btn-primary" type="submit" class="form-control">
				<em class="fas fa-bookmark"></em>
				Book</button>
				<a class="btn btn-danger" href="index.jsp " type="reset" class="form-control">
				<em class="fas fa-trash-restore"></em>
				Cancel</a>
				</div>
			</form>
			</div>
			</div>
			</div>
			<div class="col sm-2"></div>
		</div>
		<script src="js/Booking-component.js"></script>
</main>
</body>
</html>
