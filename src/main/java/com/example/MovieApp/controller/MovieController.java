package com.example.MovieApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieApp.model.Movies;
import com.example.MovieApp.repo.MoviesRepository;
import com.example.MovieApp.service.IValidationService;

@RestController
public class MovieController {

	@Autowired
	MoviesRepository repository;
	
	@Autowired
	IValidationService iValidationService;

	
	@GetMapping(value="/movie",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Movies> getAllMovies() {
		List<Movies> list = new ArrayList<>();
		Iterable<Movies> movies = repository.findAll();
		movies.forEach(list::add);
		return list;
	
	}
	@PostMapping(value="/postmovie")
	public String postMovies(@RequestBody Movies movies) {
		if(iValidationService.validateImdb(movies.getImdb())) {
			repository.save(new Movies(movies.getMovieName(),movies.getImdb(),movies.getPoster()));
			return "Success";	
		}
		else {
			return "Failed";
		}
			
	}
	
	@GetMapping(value="/movie/{imdb}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Movies> findByImdb(@PathVariable float imdb){
		List<Movies> movie = repository.findByimdb(imdb);
		return movie;
	}
	
	@DeleteMapping(value="movie/{id}")
	public void deleteCustomer(@PathVariable long id) {
		repository.deleteById(id);
	}
}
