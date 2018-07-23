package com.example.MovieApp.service.implementation;

import org.springframework.stereotype.Service;

import com.example.MovieApp.service.IValidationService;

@Service
public class ValidationServiceImpl implements IValidationService {
	@Override
	public Boolean validateImdb(float imdb) {
		// TODO Auto-generated method stub
		if(imdb>0.0 && imdb<=10.0)
		{
			return true;
		}
		return false;
	}
}
