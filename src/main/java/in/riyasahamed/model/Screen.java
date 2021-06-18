package in.riyasahamed.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(value = "screens")
public class Screen {

	@Id
	private Integer id;
	
	private String name;
	
	private String status;
}
