package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Movie;
import com.springrest.springrest.exception.ResourceNotFound;

@Service
public class MovieServiceImpl implements MovieService {
	
	List <Movie> list;

	public MovieServiceImpl() {
		 list=new ArrayList<>();
		 list.add(new Movie(200,"ABCD","Dance"));
		 list.add(new Movie(201,"John Wick","Action"));
		 list.add(new Movie(202,"21 Jump Street","Comedy"));
		 list.add(new Movie(203,"Avengers","Fantasy"));
	}

	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Movie getMovie(long movieId) throws ResourceNotFound{
		Movie m= null;
		for(Movie movie:list) {
			if(movie.getId()==movieId) {
				m=movie;
				break;
			}
			else
				throw new ResourceNotFound("No movie found here");
		}
		return m;
	}

	@Override
	public Movie addMovie(Movie movie) {
		list.add(movie);
		return movie;
	}

	@Override
	public Movie updateMovie(Movie movie) {
		list.forEach(e -> {
			if(e.getId()==movie.getId()) {
				e.setTitle(movie.getTitle());
				e.setDescription(movie.getDescription());
			}
		});
		return movie;
	}

	@Override
	public List<Movie> deleteMovie(long movieId) {
		list=this.list.stream().filter(e -> e.getId()!=movieId).collect(Collectors.toList());
		return list;
	}

}
