package in.riyasahamed.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieReportDTO {

	private LocalDate showDate;

	private Integer morningShowTickets;

	private Integer afterNoonShowTickets;

	private Integer eveningShowTickets;
	
	private Integer nightShowTickets;

}
