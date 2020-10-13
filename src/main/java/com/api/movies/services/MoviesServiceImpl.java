package com.api.movies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.movies.dao.MoviesDAO;
import com.api.movies.models.Movie;

@Service
public class MoviesServiceImpl implements MoviesService {

	@Autowired
	private MoviesDAO moviesDAO;
	
	// A service method that returns the list of movies w.r.t genre
	@Override
	public List<Movie> getMoviesByGenre(String genre) {
		return moviesDAO.getMoviesByGenre(genre);
	}

}