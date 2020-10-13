package com.api.movies.dao;

import java.util.ArrayList;
import java.util.List;

import com.api.movies.models.Movie;

public class Movies {
	
	private List<Movie> movieList;
	
	public List<Movie> getMoviesList() {
		
		if(movieList==null) {
			movieList = new ArrayList<>();
		}
		
		return movieList;
	}
	
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
}
