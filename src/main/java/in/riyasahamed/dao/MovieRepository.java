package in.riyasahamed.dao;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.riyasahamed.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie ,Integer>{
	
	@Query("select s.name from screens s where s.status = :status")
	Iterable<String> getInActiveScreens(@Param("status")String status); 
	
	@Modifying
	@Query("update movies set status= :status where id = :id")
	void updateMovieStatus(@Param("id") Integer id ,@Param("status")String status);
	
	@Modifying
	@Query("update movies set screen= :screen where id = :id")
	void updateScreenName(@Param("id") Integer id ,@Param("screen")String screen);

}
