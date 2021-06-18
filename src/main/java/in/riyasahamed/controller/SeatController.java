package in.riyasahamed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.riyasahamed.model.Seat;
import in.riyasahamed.service.SeatService;

@RestController
public class SeatController {
	@Autowired
	SeatService seatService;
	
	@GetMapping("SeatDetailsServlet")
	public Iterable<Seat> findAll() {
		 return seatService.findAll();		
	}

}
