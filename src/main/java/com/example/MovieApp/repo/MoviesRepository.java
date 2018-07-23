package com.example.MovieApp.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.MovieApp.model.Movies;

public interface MoviesRepository extends CrudRepository <Movies,Long> {
	List<Movies> findByimdb(float imdb);
}
