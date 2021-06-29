package in.riyasahamed.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.riyasahamed.model.Movie;
import in.riyasahamed.model.Seat;
import in.riyasahamed.model.Ticket;
import in.riyasahamed.model.User;

@Repository
public class TicketDAOImpl {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Ticket> findAll() {

		String sql = "select * from booking_details_vw order by status asc";
		return jdbcTemplate.query(sql, (rs, rowNo) -> {
			return toRow(rs);
		});
	}

	public List<Ticket> findByUserId(Integer userId) {
		
		String sql = "select * from booking_details_vw where user_id = ? order by status asc";
		Object[] params = { userId };
		return jdbcTemplate.query(sql, (rs, rowNo) -> {
			return toRow(rs);
		}, params);
	}
	
	public void remove(Integer id) {
		String sql = "update booking_details set status = 'CANCELLED' where id = ?";
		Object[] params = { id };
		jdbcTemplate.update(sql, params);
	}

	private Ticket toRow(ResultSet result) throws SQLException {
		Ticket ticket = new Ticket();
		Movie movie = new Movie();
		Seat seat = new Seat();
		User user = new User();
		Integer bookigId = result.getInt("id");
		String name = result.getString("user");
		Integer movieId = result.getInt("movie_id");
		String movieName = result.getString("movie_name");
		Long mobileNumber = result.getLong("mobile_number");
		Timestamp bookingDate = result.getTimestamp("booking_date");
		LocalDateTime bDate = bookingDate.toLocalDateTime();
		Date showDate = result.getDate("showdate");
		LocalDate sDate = showDate.toLocalDate();
		Time showTime = result.getTime("show_time");
		LocalTime sTime = showTime.toLocalTime();
		String seatType = result.getString("seat_type");
		Integer noOftickets = result.getInt("tickets");
		Float price = result.getFloat("total_price");
		String status = result.getString("status");
		String screen = result.getString("screen");
		user.setName(name);
		user.setMobileNumber(mobileNumber);
		seat.setSeatType(seatType);
		movie.setName(movieName);
		movie.setId(movieId);
		ticket.setId(bookigId);
		ticket.setBookingDate(bDate);
		ticket.setNoOfTickets(noOftickets);
		ticket.setShowDate(sDate);
		ticket.setShowTime(sTime);
		ticket.setTotalPrice(price);
		ticket.setStatus(status);
		ticket.setMovie(movie);
		ticket.setSeat(seat);
		ticket.setUser(user);
		ticket.setScreen(screen);

		return ticket;
	}

}
