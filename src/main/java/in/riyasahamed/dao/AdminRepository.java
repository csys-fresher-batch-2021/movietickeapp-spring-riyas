package in.riyasahamed.dao;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.riyasahamed.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {
	

	@Query("Select * from admins a  where a.user_name =:userName and a.password =:password")
	Optional<Admin> findByUserNameAndPassWord(@Param("userName") String userName , @Param("password") String password);

}
