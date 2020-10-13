package com.api.movies;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.movies.dao.MoviesDAO;
import com.api.movies.models.Movie;
import com.api.movies.services.MoviesService;
import com.api.movies.services.MoviesServiceImpl;

@SpringBootTest(classes = {MoviesService.class, MoviesServiceImpl.class})
@RunWith(SpringRunner.class)
public class MoviesServiceImplIntegrationTest {
	
	@TestConfiguration
	static class MoviesServiceImplTestContextConfiguration {

		@Bean
		public MoviesService moviesService() {
			return new MoviesServiceImpl();
		}
		
	}
	
	@Autowired
	private MoviesService moviesService;
	
	@MockBean
	private MoviesDAO moviesDAO;
	
	@BeforeEach
	public void setUp() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		List<Movie> listOfAdventureMovies = new ArrayList<>();
		listOfAdventureMovies.add(new Movie(7, "Adventure Movie", formatter.format(date), "Adventure", "Director1", "Producer1"));
		listOfAdventureMovies.add(new Movie(8, "Adventure Movie 1", formatter.format(date), "Adventure", "Director1", "Producer1"));
		listOfAdventureMovies.add(new Movie(9, "Adventure Movie 2", formatter.format(date), "Adventure", "Director1", "Producer1"));
		
		Mockito.when(moviesDAO.getMoviesByGenre("adventure")).thenReturn(listOfAdventureMovies);
		
	}
	
	@Test
	public void whenAValidGenreIsGiven_thenListOfMoviesShouldBeReturned() {
		String genre = "adventure";

		List<Movie> listOfScienceFictionMovies = moviesService.getMoviesByGenre(genre);
		
		System.out.println("size = "+listOfScienceFictionMovies.size());
		
		assertThat(listOfScienceFictionMovies.size()).isEqualTo(3);
	}
	
	@Test
	public void whenAnInvalidGenreIsGiven_thenSizeListOfMoviesShouldBeZero() {
		String genre = "horror";

		List<Movie> listOfScienceFictionMovies = moviesService.getMoviesByGenre(genre);
		
		assertThat(listOfScienceFictionMovies.size()).isEqualTo(0);
	}
	
	
}