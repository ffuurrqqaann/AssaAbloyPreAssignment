package com.api.movies.services;

import java.util.List;

import com.api.movies.models.Movie;

public interface MoviesService {
	public List<Movie> getMoviesByGenre(String genre);
}
