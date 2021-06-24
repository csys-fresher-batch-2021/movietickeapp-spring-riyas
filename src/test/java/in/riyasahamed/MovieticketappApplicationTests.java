package in.riyasahamed;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import in.riyasahamed.service.TicketService;

@SpringBootTest
class MovieticketappApplicationTests {
	
	@Autowired
	TicketService ticket;

	@Test
	void contextLoads() {
	
	}

}
