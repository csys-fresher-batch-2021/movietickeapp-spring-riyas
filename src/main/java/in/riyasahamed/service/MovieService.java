package in.riyasahamed.service;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.riyasahamed.dao.MovieRepository;
import in.riyasahamed.dao.ScreenRepository;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.model.Movie;
import in.riyasahamed.validator.MovieValidator;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepo;
	
	@Autowired
	MovieValidator validator;
	
	@Autowired
	ScreenRepository screenRepo;
	
	

	/**
	 * This Method returns all the Active Screens
	 * @param status
	 * @return
	 */
	public Iterable<String> getInActiveScreens(String status) {		
		return movieRepo.getInActiveScreens(status);
	}
	
	/**
	 * This Method returns all the Movies
	 * @return
	 */
	public Iterable<Movie> getAllMovies() {		
		return movieRepo.findAll();
	}
	
	/**
	 * This method Adds the Movie Details
	 * @param movie
	 */
	public void addMovie(Movie movie) {
		try {
			 
			validator.validateMovieDetails(movie.getName(), movie.getActor(), movie.getRating());
			movieRepo.save(movie);
			updateScreenStatus(movie.getScreen(),"ACTIVE");
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	
	}
	
	public void updateMovieStatus(Integer id , String status) {		
		try {
			 movieRepo.updateMovieStatus(id ,status);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		
	}
	
	public void updateScreenStatus(String screen , String status) {		
		try {
			 screenRepo.updateScreenStatus(screen , status);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		
	}
	
	public void updateScreenName(Integer id , String screen) {
		try {
			 movieRepo.updateScreenName(id, screen);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		
	}
	
	public Iterable<LocalTime> getAllShowTimes() {
		return screenRepo.getAllShowTimes();
	}
	

}
