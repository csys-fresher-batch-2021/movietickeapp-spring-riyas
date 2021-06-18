package in.riyasahamed.dao;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.riyasahamed.dto.BookedTicketsDTO;
import in.riyasahamed.dto.TicketDTO;

@Repository
public interface TicketDTORepository extends CrudRepository<TicketDTO, Integer>{
	@Query("select  b.movie_id , SUM(b.tickets) AS total_tickets  from booking_details b, movies m where b.status !='CANCELLED' and showdate = :showDate and show_time = :showTime and seat_type = :seatType and b.movie_id = m.id group by b.movie_id")
	Iterable<BookedTicketsDTO> getBookedTickets(@Param("showDate") LocalDate showDate ,@Param("showTime") LocalTime showTime ,@Param("seatType") String seatType );

}
