package in.riyasahamed.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.riyasahamed.dao.TicketDTORepository;
import in.riyasahamed.dto.BookedTicketsDTO;

@Service
public class TicketService {
	
	@Autowired
	TicketDTORepository ticketRepo;
	
	public Iterable<BookedTicketsDTO> getBookedTickets(LocalDate showDate , LocalTime showTime , String seatType) {
		Iterable<BookedTicketsDTO> bookedTickets = ticketRepo.getBookedTickets(showDate, showTime, seatType);
		System.out.println(bookedTickets);
		return ticketRepo.getBookedTickets(showDate, showTime, seatType);
	}

}
