package in.riyasahamed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.riyasahamed.model.Movie;
import in.riyasahamed.service.MovieService;
import in.riyasahamed.util.Message;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@GetMapping("/ListMoviesServlet")
	public Iterable<Movie> list() {		
		return movieService.getAllMovies();	
	}	
	
	@GetMapping("/ListScreenServlet")
	public Iterable<String> listScreens() {		
		return movieService.getInActiveScreens("INACTIVE");	
	}	
	
	@PostMapping("/AddMovieServlet")
	public ResponseEntity<Message> addMovie(@RequestBody Movie movie) {
		try {
			movieService.addMovie(movie);
			Message message = new Message();
			message.setInfoMessage("Successfully Added Movie");
			return new ResponseEntity<>( message, HttpStatus.OK);
		} catch (Exception e) {
			Message message = new Message();
			message.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/RemoveMovieServlet")
	public ResponseEntity<Message> removeMovie(@Param("id") Integer id , @Param("screen") String screen){
		try {
			movieService.updateMovieStatus(id, "INACTIVE");
			movieService.updateScreenStatus(screen, "INACTIVE");		
			Message message = new Message();
			message.setInfoMessage("Successfully Removed Movie");
			return new ResponseEntity<>( message, HttpStatus.OK);
		} catch (Exception e) {
			Message message = new Message();
			message.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/ActivateMovieServlet")
	public ResponseEntity<Message> activateMovie(@Param("id") Integer id , @Param("screen") String screen){
		try {
			movieService.updateMovieStatus(id, "ACTIVE");
			movieService.updateScreenStatus(screen, "ACTIVE");	
			movieService.updateScreenName(id, screen);
			Message message = new Message();
			message.setInfoMessage("Successfully Activated Movie");
			return new ResponseEntity<>( message, HttpStatus.OK);
		} catch (Exception e) {
			Message message = new Message();
			message.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
