package com.api.movies;

/*
 * The MoviesNotFoundException is a custom exception class for If no movies present for a specified genre.
 * */
public class MoviesNotFoundException extends RuntimeException {

	public MoviesNotFoundException(String genre) {
		super("No "+genre+" movies found.");
	}
	
}
