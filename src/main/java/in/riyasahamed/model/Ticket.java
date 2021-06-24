package in.riyasahamed.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

@Data
public class Ticket {

	private Integer id;

	private LocalDateTime bookingDate;

	private Integer noOfTickets;

	private float totalPrice;

	private LocalDate showDate;

	private Movie movie;

	private Seat seat;

	private User user;

	private String screen;

	private LocalTime showTime;

	private String status;

}
