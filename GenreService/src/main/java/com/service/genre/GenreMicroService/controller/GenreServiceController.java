package com.service.genre.GenreMicroService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.service.genre.GenreMicroService.model.Genre;
import com.service.genre.GenreMicroService.model.Movie;
import com.service.genre.GenreMicroService.service.GenreService;

@RestController
public class GenreServiceController {
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/genre/all")
	private List<Genre> getAllGenres() {
		List<Genre> genreList = genreService.getAllGenres();
		
		for (Genre genre : genreList) {
			List<Movie> moviesList = restTemplate.getForObject("http://movie-service/movie/genre/" + genre.getId(), List.class);
			genre.setMovieList(moviesList);
		}
		
		return genreList;
	}
	
	@GetMapping("/genre/{id}")
	private Genre getGenreById(@PathVariable Long id) {
		Genre genre = genreService.getGenreById(id);
		
		/*
		 * ResponseEntity<Movie[]> response =
		 * restTemplate.getForEntity("http://localhost:9010/movie/genre/" + id,
		 * Movie[].class); Movie[] movies = response.getBody();
		 * 
		 * genre.setMovieList(Arrays.asList(movies));
		 * 
		 */
		
		List<Movie> moviesList = restTemplate.getForObject("http://movie-service/movie/genre/" + id, List.class);
		genre.setMovieList(moviesList);
		
		return genre;
	}
	
}
