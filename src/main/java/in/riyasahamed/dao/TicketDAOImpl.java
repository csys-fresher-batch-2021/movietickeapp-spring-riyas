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

import in.riyasahamed.dto.MovieReportDTO;
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
	
	public List<MovieReportDTO> findReportsByMovieId(Integer movieId) {
		
		StringBuilder str = new StringBuilder();
		str.append("SELECT showdate ,coalesce(morning,0) as morning, coalesce(afternoon,0) as afternoon,");
		str.append("coalesce(evening,0) as evening,coalesce(midnight,0) as night");
		str.append(" FROM crosstab('select showdate, show_time , sum(tickets) tickets  from booking_details");
		str.append(" where movie_id=");
		str.append(movieId);
		str.append(" and status !=''CANCELLED'' GROUP BY showdate, show_time  order by 1,2 asc')");
		str.append(" ct(showdate date, morning bigint, afternoon bigint, evening bigint , midnight bigint)");
		String sql = str.toString();
		System.out.println(sql);
		
		//String sql= "select * from report_vw";
		return jdbcTemplate.query(sql, (rs, rowNo) -> {
			MovieReportDTO report = new MovieReportDTO();
			Date showDate = rs.getDate("showdate");
			report.setShowDate(showDate.toLocalDate());
			report.setAfterNoonShowTickets(rs.getInt("afternoon"));
			report.setMorningShowTickets(rs.getInt("morning"));
			report.setEveningShowTickets(rs.getInt("evening"));
			report.setNightShowTickets(rs.getInt("night"));
			return report;
		});		
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
