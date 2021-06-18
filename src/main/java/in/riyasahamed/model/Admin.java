package in.riyasahamed.model;

import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;

@Data
public class Admin {
	
	private Integer id;
	
	@Column("user_name")
	private String userName;
	
	private String password;

}
