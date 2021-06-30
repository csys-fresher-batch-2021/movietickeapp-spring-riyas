package in.riyasahamed.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.riyasahamed.dao.SeatRepository;
import in.riyasahamed.dao.TicketDAOImpl;
import in.riyasahamed.dao.TicketDTORepository;
import in.riyasahamed.dto.BookedTicketsDTO;
import in.riyasahamed.dto.MovieReportDTO;
import in.riyasahamed.dto.TicketDTO;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.model.Seat;
import in.riyasahamed.model.Ticket;

@Service
public class TicketService {

	@Autowired
	TicketDTORepository ticketRepo;

	@Autowired
	SeatRepository seatRepo;

	@Autowired
	TicketDAOImpl ticket;
	
	/**
	 * This Method is used to get the booked tickets of the movie.
	 * @param showDate
	 * @param showTime
	 * @param seatType
	 * @return map of movie id as key and booked tickets as value
	 */
	public Map<Integer, Integer> getBookedTickets(LocalDate showDate, LocalTime showTime, String seatType) {
		List<BookedTicketsDTO> bookedTickets = ticketRepo.getBookedTickets(showDate, showTime, seatType);
		return bookedTickets.stream()
				.collect(Collectors.toMap(BookedTicketsDTO::getMovieId, BookedTicketsDTO::getTotalTickets));
	}

	/**
	 * This Method is used to calculate the price for given seat type and number of tickets
	 * @param seatType
	 * @param noOfTickets
	 * @return
	 */
	public float getPrice(String seatType, Integer noOfTickets) {
		Float totalPrice = (float) 0;
		if (noOfTickets != null) {
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
	
	/**
	 * This Method is used to store the booking details in the data base
	 * @param ticket
	 */
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

	/**
	 * This Method is used to get booking details of all users
	 * @return List of Booking Details
	 */
	public List<Ticket> getAllBookings() {

		List<Ticket> tickets = null;
		try {
			tickets = ticket.findAll();
		} catch (Exception e) {
			throw new ServiceException("Unable to Get Booking Details");
		}

		return tickets;
	}
	
	/**
	 * This Method is used to get booking details of a Particular Users
	 * @param userId
	 * @return List of Booking Details of a particular User
	 */
	public List<Ticket> getUserBookings(Integer userId) {

		List<Ticket> tickets = null;
		try {
			tickets = ticket.findByUserId(userId);
		} catch (Exception e) {
			throw new ServiceException("Unable to Get Booking Details");
		}

		return tickets;
	}

	/**
	 * This Method is used to cancel the booking
	 * @param id
	 */
	public void cancelBooking(Integer id) {
		try {
			ticket.remove(id);
		} catch (Exception e) {
			throw new ServiceException("Unable to Cancel Movie");
		}

	}
	
	/**
	 * This Method is used to update the booking status after the show is finished
	 */
	public void updateBookings() {
		List<TicketDTO> tickets = (List<TicketDTO>) ticketRepo.findAll();
		for (TicketDTO ticketDTO : tickets) {
			if (ticketDTO.getStatus().equalsIgnoreCase("BOOKED")) {
				if (ticketDTO.getShowDate().equals(LocalDate.now())) {
					if (ticketDTO.getShowTime().isBefore(LocalTime.now())) {
						ticketDTO.setStatus("FINISHED");
						ticketRepo.save(ticketDTO);
					}
				} else if (ticketDTO.getShowDate().isBefore(LocalDate.now())) {
					ticketDTO.setStatus("FINISHED");
					ticketRepo.save(ticketDTO);
				}
			}
		}
	}
	
	public List<MovieReportDTO> getMovieReport(Integer movieId) {		
		return  ticket.findReportsByMovieId(movieId);
	}
}
