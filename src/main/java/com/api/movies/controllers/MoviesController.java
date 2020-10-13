package com.api.movies.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.movies.APIConstants;
import com.api.movies.ApiResponse;
import com.api.movies.MoviesNotFoundException;
import com.api.movies.models.Movie;
import com.api.movies.services.MoviesService;

@RestController
@RequestMapping("/api/v1")
public class MoviesController {

	@Autowired
	private MoviesService movieService;
	
	// A get endpoint that returns the list of movies according to the genre.
	@GetMapping(path="/movies/{genre}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ApiResponse getMoviesByGenre(@PathVariable(value="genre") String genre) {
		
		List<Movie> movies = movieService.getMoviesByGenre(genre.trim());
		
		if(movies.size()<=0) {
			throw new MoviesNotFoundException(genre);
		}
		
		ApiResponse response = new ApiResponse();
		response.setData(movies);
		response.setStatus(HttpStatus.OK.value());
		response.setMessage(genre+" "+APIConstants.MOVIES_FOUND_SUCCESSFULLY);
		
		return response;
	}
	
}