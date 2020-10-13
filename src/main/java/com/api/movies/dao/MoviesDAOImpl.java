package com.api.movies.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.api.movies.models.Movie;

@Repository
public class MoviesDAOImpl implements MoviesDAO {
	
	private static Movies ListOfMovies = new Movies();
	
	static {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		ListOfMovies.getMoviesList().add(new Movie(1, "Historical Movie", formatter.format(date), "historical", "Director1", "Producer1"));
		ListOfMovies.getMoviesList().add(new Movie(2, "Horror Movie", formatter.format(date), "horror", "Director1", "Producer1"));
		ListOfMovies.getMoviesList().add(new Movie(3, "Historical Movie 1", formatter.format(date), "historical", "Director1", "Producer1"));
		ListOfMovies.getMoviesList().add(new Movie(4, "Action Movie", formatter.format(date), "Action", "Director1", "Producer1"));
		ListOfMovies.getMoviesList().add(new Movie(5, "ScienceFiction Movie", formatter.format(date), "Sciencefiction", "Director1", "Producer1"));
		ListOfMovies.getMoviesList().add(new Movie(6, "Thriller Movie", formatter.format(date), "thriller", "Director1", "Producer1"));
		ListOfMovies.getMoviesList().add(new Movie(7, "Adventure Movie", formatter.format(date), "Adventure", "Director1", "Producer1"));
		ListOfMovies.getMoviesList().add(new Movie(8, "Adventure Movie 1", formatter.format(date), "Adventure", "Director1", "Producer1"));
		ListOfMovies.getMoviesList().add(new Movie(9, "Adventure Movie 2", formatter.format(date), "Adventure", "Director1", "Producer1"));
		ListOfMovies.getMoviesList().add(new Movie(10, "Historical Movie 2", formatter.format(date), "historical", "Director1", "Producer1"));
		
	}
	
	@Override
	public List<Movie> getMoviesByGenre(String genre) {
		
		List<Movie> movies = ListOfMovies.getMoviesList();
		Stream<Movie> moviesStream = movies.stream();
		
		moviesStream = moviesStream.filter(movie -> movie.getGenre().equalsIgnoreCase(genre));
		movies = moviesStream.collect(Collectors.toList());
		
		return movies;
	}

}