package in.riyasahamed.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(value="booking_details")
public class TicketDTO {
	
	@Id
	private Integer id;

	@Column("booking_date")
	private LocalDateTime bookingDate;

	@Column("tickets")
	private Integer noOfTickets;

	@Column("total_price")
	private float totalPrice;

	@Column("showdate")
	private LocalDate showDate;
	
	@Column("movie_id")
	private Integer movieId;
	
	@Column("seat_type")
	private String seatType;
	
	@Column("user_id")
	private Integer userId;
	
	private String screen;
	
	@Column("show_time")
	private LocalTime showTime;
	
	private String status;

}
