package in.riyasahamed.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.riyasahamed.dao.TicketDTORepository;
import in.riyasahamed.dto.BookedTicketsDTO;

@Service
public class TicketService {
	
	@Autowired
	TicketDTORepository ticketRepo;
	
	public Map<Integer, Integer> getBookedTickets(LocalDate showDate , LocalTime showTime , String seatType) {
		List<BookedTicketsDTO> bookedTickets = ticketRepo.getBookedTickets(showDate, showTime, seatType);
		System.out.println(bookedTickets);
		Map<Integer,Integer> bookingDetailsMap = new HashMap<>();
		bookingDetailsMap = bookedTickets.stream().collect(Collectors.toMap(BookedTicketsDTO :: getMovieId, BookedTicketsDTO :: getTotalTickets));
		System.out.println(bookingDetailsMap);
		return bookingDetailsMap;
	}

}
