package in.riyasahamed.dao;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.riyasahamed.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query("Select * from users u  where u.user_name =:userName and u.password =:password")
	Optional<User> findByUserNameAndPassWord(@Param("userName") String userName , @Param("password") String password);
	
	@Query("Select id from users u  where u.user_name =:userName")
	Integer findByUserName(@Param("userName") String userName);
	
	@Query("Select * from users u  where u.user_name =:userName and u.password =:password")
	User findUserByUserNameAndPassWord(@Param("userName") String userName , @Param("password") String password);
	

}
