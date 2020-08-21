package com.springrest.springrest.service;

import java.util.List;

import com.springrest.springrest.entities.Movie;

public interface MovieService {
	
	public List<Movie> getMovies();
	
	public Movie getMovie(long movieId);
	
	public Movie addMovie(Movie movie);
	
	public Movie updateMovie(Movie movie);
	
	public List<Movie> deleteMovie(long movieId);
}
