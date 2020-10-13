package com.api.movies;

import java.util.List;
import com.api.movies.models.Movie;

/*
 * The ApiResponse is the container for the api's response message.
 * */
public class ApiResponse {
	
	private Integer status;
	private String message;
	private List<Movie> data;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<Movie> getData() {
		return data;
	}
	public void setData(List<Movie> data) {
		this.data = data;
	}
	
}
