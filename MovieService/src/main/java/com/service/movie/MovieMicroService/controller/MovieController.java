package com.service.movie.MovieMicroService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.movie.MovieMicroService.model.Movie;
import com.service.movie.MovieMicroService.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	MovieService movieService;

	@GetMapping("/all")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	@GetMapping("/genre/{id}")
	public List<Movie> getMovieById(@PathVariable Long id) {
		return movieService.getMoviesByGenreId(id);
	}
	
}
