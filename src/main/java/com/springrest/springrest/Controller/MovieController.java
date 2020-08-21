package com.springrest.springrest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.springrest.springrest.ErrorResponse;
import com.springrest.springrest.entities.Movie;
import com.springrest.springrest.service.MovieService;

import io.swagger.annotations.ApiOperation;

@ApiOperation(value="/movies",tags="Movie Controller")
@RestController
public class MovieController {
	
	@Autowired
	private MovieService s;
	
	@ApiOperation(value="Fetch all movies",response=Iterable.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "SUCCESS", response = Movie.class),
			@ApiResponse(code = 401, message = "UNAUTHORIZED!", response = ErrorResponse.class),
			@ApiResponse(code = 403, message = "FORBIDDEN!", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "NOT FOUND")
})
	@GetMapping("/movies")
	public List<Movie> getMovies() {
		return this.s.getMovies();
	}
	
	@ApiOperation(value="Fetch movie by id",response=Movie.class)
	@GetMapping("/movies/{movieId}")
	public Movie getMovie(@PathVariable long movieId) {
		 return this.s.getMovie(movieId);
	}
	
	@ApiOperation(value="Add new movie",response=Movie.class)
	@PostMapping("/movies")
	public Movie addMovie(@RequestBody Movie movie) {
		return this.s.addMovie(movie);
	}
	
	@ApiOperation(value="Update any movie",response=Movie.class)
	@PutMapping("/movies")
	public Movie updateMovie(@RequestBody Movie movie) {
		return this.s.updateMovie(movie);
	}
	
	@ApiOperation(value="Delete movie by id",response=Iterable.class)
	@DeleteMapping("movies/{movieId}")
	public List<Movie> deleteMovie(@PathVariable long movieId){
		 return this.s.deleteMovie(movieId);
	}

}
