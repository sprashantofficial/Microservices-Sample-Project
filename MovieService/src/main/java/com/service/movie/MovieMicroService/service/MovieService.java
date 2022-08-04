package com.service.movie.MovieMicroService.service;

import java.util.List;

import com.service.movie.MovieMicroService.model.Movie;

public interface MovieService {

	List<Movie> getAllMovies();

	List<Movie> getMoviesByGenreId(Long genreId);

}
