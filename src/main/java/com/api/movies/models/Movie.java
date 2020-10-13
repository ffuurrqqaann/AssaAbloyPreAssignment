package com.api.movies.models;

import java.util.Date;

public class Movie {
	
	public Movie() {}
	
	public Movie(
			Integer id, String name, String releaseDate,
			String genre, String directorName, String producerName) {
		
		super();
		
		this.id = id;
		this.name = name;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.directorName = directorName;
		this.producerName = producerName;
	}
	
	private Integer id;
	private String name;
	private String releaseDate;
	private String genre;
	private String directorName;
	private String producerName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	
	public String getProducerName() {
		return producerName;
	}
	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}
	
}