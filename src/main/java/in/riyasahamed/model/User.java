package in.riyasahamed.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(value = "users")
public class User {
	
	@Id
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	@Column("user_name")
	private String userName;
	
	@Column("mobile_number")
	private Long mobileNumber;
	
	

}
