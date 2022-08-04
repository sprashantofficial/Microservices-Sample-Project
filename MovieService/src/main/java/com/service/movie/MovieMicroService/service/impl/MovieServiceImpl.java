package com.service.movie.MovieMicroService.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.movie.MovieMicroService.dao.MovieDAO;
import com.service.movie.MovieMicroService.model.Movie;
import com.service.movie.MovieMicroService.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDAO movieDAO;
	
	@Override
	public List<Movie> getAllMovies() {
		return movieDAO.getAllMovies();
	}

	@Override
	public List<Movie> getMoviesByGenreId(Long genreId) {
		return movieDAO.getMoviesByGenreId(genreId);
	}

}
