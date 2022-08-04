package com.service.movie.MovieMicroService.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.service.movie.MovieMicroService.dao.MovieDAO;
import com.service.movie.MovieMicroService.model.Movie;

@Repository
public class MovieDAOImpl implements MovieDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Movie> getAllMovies() {
		return jdbcTemplate.query("select * from movie", BeanPropertyRowMapper.newInstance(Movie.class));
	}

	@Override
	public List<Movie> getMoviesByGenreId(Long genreId) {
		return jdbcTemplate.query("select * from movie where genre_id=?", (rs, rowNum) -> {
			Movie m = new Movie();
			m.setId(rs.getLong(1));
			m.setName(rs.getString(2));
			m.setYear(rs.getInt(3));
			m.setGenreId(rs.getLong(4));

			return m;
		}, genreId);
	}

}
