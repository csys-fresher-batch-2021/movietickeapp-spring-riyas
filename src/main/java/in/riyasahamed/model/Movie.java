package in.riyasahamed.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(value = "movies")
public class Movie {

	@Column("movie_name")
	private String name;

	private Float rating;

	@Id
	private Integer id;

	@Column("actor_name")
	private String actor;

	private String screen;
	

	private String status = "ACTIVE";

}
