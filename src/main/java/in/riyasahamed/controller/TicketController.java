package in.riyasahamed.controller;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.riyasahamed.dao.TicketDTORepository;
import in.riyasahamed.dto.TicketDTO;
import in.riyasahamed.model.Ticket;
import in.riyasahamed.service.MovieService;
import in.riyasahamed.service.TicketService;
import in.riyasahamed.service.UserService;
import in.riyasahamed.util.Message;

@RestController
public class TicketController {

	@Autowired
	MovieService movieService;

	@Autowired
	TicketService ticketService;

	@Autowired
	TicketDTORepository ticketRepo;

	@Autowired
	UserService userService;

	@GetMapping("showtimes")
	public Iterable<LocalTime> getAllShowtimes() {
		return movieService.getAllShowTimes();
	}

	@GetMapping("bookings")
	public List<Ticket> getAllBookings() {
		return ticketService.getAllBookings();
	}

	@PostMapping("bookedTickets")
	public Map<Integer, Integer> getBookedTickets(@RequestBody TicketDTO ticketDTO) {
		return ticketService.getBookedTickets(ticketDTO.getShowDate(), ticketDTO.getShowTime(),
				ticketDTO.getSeatType());
	}

	@GetMapping("price")
	public float getPrice(@Param("tickets") Integer tickets, @Param("seatType") String seatType) {
		return ticketService.getPrice(seatType, tickets);
	}

	@PostMapping("book")
	public ResponseEntity<Message> bookMovie(@RequestBody TicketDTO ticketDTO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("LOGGED_IN_USER");
		Integer userId = userService.findByUserName(userName);
		ticketDTO.setUserId(userId);
		ticketService.bookMovie(ticketDTO);
		Message message = new Message();
		message.setInfoMessage("Successfully Booked Movie");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("userBookings")
	public List<Ticket> getUserBookings(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("LOGGED_IN_USER");
		Integer userId = userService.findByUserName(userName);
		return ticketService.getUserBookings(userId);
	}

	@GetMapping("cancel")
	public ResponseEntity<Message> cancelBooking(@Param("id") Integer id) {
		ticketService.cancelBooking(id);
		Message message = new Message();
		message.setInfoMessage("Successfully Cancelled Booking");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("update")
	public ResponseEntity<Message> updateBookings() {
		ticketService.updateBookings();
		Message message = new Message();
		message.setInfoMessage("Successfully Updated Bookings");
		return new ResponseEntity<>(message, HttpStatus.OK);

	}
}
