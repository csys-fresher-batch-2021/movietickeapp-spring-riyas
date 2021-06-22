package in.riyasahamed.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.riyasahamed.dao.SeatRepository;
import in.riyasahamed.dao.TicketDTORepository;
import in.riyasahamed.dto.BookedTicketsDTO;
import in.riyasahamed.dto.TicketDTO;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.model.Seat;

@Service
public class TicketService {

	@Autowired
	TicketDTORepository ticketRepo;

	@Autowired
	SeatRepository seatRepo;

	public Map<Integer, Integer> getBookedTickets(LocalDate showDate, LocalTime showTime, String seatType) {
		List<BookedTicketsDTO> bookedTickets = ticketRepo.getBookedTickets(showDate, showTime, seatType);
		Map<Integer, Integer> bookingDetailsMap = new HashMap<>();
		bookingDetailsMap = bookedTickets.stream()
				.collect(Collectors.toMap(BookedTicketsDTO::getMovieId, BookedTicketsDTO::getTotalTickets));
		return bookingDetailsMap;
	}

	public float getPrice(String seatType, Integer noOfTickets) {		
		Float totalPrice = (float) 0;
		if(noOfTickets  != null ) {
		try {
			Iterable<Seat> seats = seatRepo.findAll();
			int price = 0;
			for (Seat seat : seats) {
				if (seatType.equalsIgnoreCase(seat.getSeatType())) {
					price = seat.getPrice();
					break;
				}
			}
			
			int baseFare = price * noOfTickets;
			totalPrice = (float) (baseFare + (baseFare * 0.18));
		} catch (Exception e) {
			throw new ServiceException("Unable to Calculate Price");
		}
		
	}
		return totalPrice;
	}
	
	public void bookMovie(TicketDTO ticket) {
		try {
			ticket.setBookingDate(LocalDateTime.now());
			ticket.setStatus("BOOKED");
			ticketRepo.save(ticket);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable To Book Movie");
		}
	}

}
