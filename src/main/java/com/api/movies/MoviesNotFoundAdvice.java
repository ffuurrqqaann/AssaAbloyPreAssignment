package com.api.movies;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.api.movies.models.Movie;

@ControllerAdvice
public class MoviesNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(MoviesNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiResponse moviesNotFoundHandler(MoviesNotFoundException ex) {
		
		ApiResponse response = new ApiResponse();
		
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage(ex.getMessage());
		response.setData(new ArrayList<Movie>());
		
		return response;
	}
	
}