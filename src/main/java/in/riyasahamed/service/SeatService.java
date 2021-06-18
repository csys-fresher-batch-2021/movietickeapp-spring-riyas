package in.riyasahamed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.riyasahamed.dao.SeatRepository;
import in.riyasahamed.model.Seat;

@Service
public class SeatService {
	
	@Autowired
	SeatRepository seatRepo;
	
	public Iterable<Seat> findAll() {		
		return seatRepo.findAll();
	}

}
