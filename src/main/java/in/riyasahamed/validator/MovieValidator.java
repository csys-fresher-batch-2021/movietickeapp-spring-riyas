package in.riyasahamed.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.riyasahamed.exceptions.ValidationException;
import in.riyasahamed.model.Movie;
import in.riyasahamed.service.MovieService;

@Component
public class MovieValidator {
	
	
	@Autowired
	MovieService service;

	
	public  void validateMovieDetails(String name, String actor, Float rating) {
		
		Iterable<Movie> movies = service.getAllMovies();
		
		for (Movie movie : movies) {
			if (name == null || name.trim().equals("")) {
				throw new ValidationException("Invalid Movie Name");
			} else if (actor == null || actor.trim().equals("")) {
				throw new ValidationException("Invalid Actor Name");
			} else if (rating < 0 || rating > 10) {
				throw new ValidationException("Invalid Rating - Rating Must be 1 to 10");
			} else if (name.equalsIgnoreCase(movie.getName()) && actor.equalsIgnoreCase(movie.getActor())) {
				throw new ValidationException("Movie Already Added");
			}
		}
	}
}
