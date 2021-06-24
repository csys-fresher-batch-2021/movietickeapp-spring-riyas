package in.riyasahamed.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import in.riyasahamed.service.TicketService;

@Component
public class UpdateBookingScheduler {
	
	@Autowired
	TicketService ticketService;
	
	@Scheduled(cron = "0 5 10,14,18,22 * * * ")
	public void updateBookings() {
		ticketService.updateBookings();
	}	
}
