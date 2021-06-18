package in.riyasahamed.controller;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.riyasahamed.dao.TicketDTORepository;
import in.riyasahamed.dto.BookedTicketsDTO;
import in.riyasahamed.dto.TicketDTO;
import in.riyasahamed.service.MovieService;
import in.riyasahamed.service.TicketService;

@RestController
public class TicketController {
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	TicketService ticketService;
	
	@Autowired
	TicketDTORepository ticketRepo;
	
	@GetMapping("/ShowTimesServlet")
	public Iterable<LocalTime> getAllShowtimes() {
		 	return movieService.getAllShowTimes();
	}
	
	@PostMapping("/BookedTicketsServlet")
	public Iterable<BookedTicketsDTO> test2(@RequestBody TicketDTO ticketDTO) {
		return ticketService.getBookedTickets(ticketDTO.getShowDate(), ticketDTO.getShowTime(), ticketDTO.getSeatType());
	}
	
	@GetMapping("/GetBookings")
	public Iterable<TicketDTO> getAllBookings() {
		return ticketRepo.findAll();
	}
	
}

