package in.riyasahamed.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(value="seat_types")
public class Seat {
	
	@Column("seat_type")
	private String seatType;
	
	private Integer price;

}
