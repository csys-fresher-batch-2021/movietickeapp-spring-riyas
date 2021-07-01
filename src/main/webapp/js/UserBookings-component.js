let url = "userBookings";
fetch(url).then(res => res.json()).then(res => {
	let data = [];
	data = res;
	let content = "";
	let j = 0;
	let i;
	$("#bookingsTable tbody").empty();
	if (data.length != 0) {
		for (i = 0; i < data.length; i++) {
			let movie = data[i];
			let bookingDate = movie.bookingDate.substr(0, 10);
			let bookedDatearr = bookingDate.split('-');
			let bookedDateStr = bookedDatearr[2] + "-" + bookedDatearr[1] + "-" + bookedDatearr[0];
			let showTime = movie.showTime.substr(0, 5);
			content += "<tr><td>" + ++j + "</td><td>" + movie.id + "</td>";
			content += "<td>" + data[i].movie.name + "</td><td>" + bookedDateStr + "</td>";
			let arr = data[i].showDate.split('-');
			let showDate = arr[2] + "-" + arr[1] + "-" + arr[0];
			content += "<td>" + showDate + "</td><td>" + showTime + "</td>";
			content += "<td>" + data[i].screen + "</td><td>" + data[i].seat.seatType + "</td>";
			content += "<td>" + data[i].noOfTickets + "</td><td>" + data[i].totalPrice + "</td>";
			content += "<td>";
			if (data[i].status == "BOOKED") {
				content += "<span class='badge badge-success'>";
			} else if (data[i].status == "CANCELLED") {
				content += "<span class='badge  badge-danger'>";
			} else if (data[i].status == "FINISHED") {
				content += "<span class='badge badge-primary'>";
			}
			content += data[i].status + "</span></td>";
			let date = new Date();
			let today = date.toJSON().substring(0, 10);
			if (data[i].showDate > today && data[i].status == "BOOKED") {
				content += "<td><button class = 'btn btn-danger' onclick=\"cancel(" + data[i].id + ")\">Cancel</button</td></tr>";
			} else {
				content += "<td><button class = 'btn btn-danger' disabled>Cancel</button</td></tr>";
			}
		}
	} else {
		content += "<tr><td colspan=14 class='text-center'>" + "No Records Found" + "</td></tr>";
	}

	$("#bookingsTable tbody").append(content);
	$('#bookingsTable').DataTable();

});

function cancel(id) {
	event.preventDefault();
	const queryParams = "?id=" + id;
	let url = "cancel" + queryParams;
	console.log(url);
	let content = "";
	fetch(url).then(res => res.json()).then(res => {
		console.log("Success");
		let data = res;
		console.log(data);
		content += data.infoMessage;
		alert(content);
		window.location.href = "UserBookings.jsp";
	}).catch(err => {
		console.log("Error");
		let data = err.response;
		console.log(data);
		content += data.errorMessage;
		document.querySelector("#message").innerHTML = content;

	});
}


