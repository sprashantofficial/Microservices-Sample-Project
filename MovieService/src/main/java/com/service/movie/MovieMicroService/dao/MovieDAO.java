package com.service.movie.MovieMicroService.dao;

import java.util.List;

import com.service.movie.MovieMicroService.model.Movie;

public interface MovieDAO {

	List<Movie> getAllMovies();

	List<Movie> getMoviesByGenreId(Long genreId);

}
