package com.api.movies.dao;

import java.util.List;

import com.api.movies.models.Movie;

public interface MoviesDAO {
	public List<Movie> getMoviesByGenre(String genre);
}
