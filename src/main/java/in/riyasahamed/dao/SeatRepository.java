package in.riyasahamed.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.riyasahamed.model.Seat;

@Repository
public interface SeatRepository extends CrudRepository<Seat, Integer> {

}
