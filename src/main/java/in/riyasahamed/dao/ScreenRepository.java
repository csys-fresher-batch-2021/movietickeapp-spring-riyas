package in.riyasahamed.dao;

import java.time.LocalTime;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.riyasahamed.model.Screen;

@Repository
public interface ScreenRepository extends CrudRepository<Screen ,Integer> {
	
	@Modifying
	@Query("update  screens   set status= :status where name = :name")
	void updateScreenStatus(@Param("name") String name ,@Param("status")String status);
	
	@Query("select show_time from show_times")
	Iterable<LocalTime> getAllShowTimes();
	
	

}
