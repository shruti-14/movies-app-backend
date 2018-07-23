package com.example.MovieApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "movies")
public class Movies implements Serializable {
	private static final long serialVersionUID = -3009157732242241606L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@Column(name="moviename")
	private String movieName;
	
	@Column(name="Imdb")
	private float imdb;
	
	@Column(name="Poster")
	private String poster;
	
	protected Movies() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public float getImdb() {
		return imdb;
	}

	public void setImdb(float imdb) {
		this.imdb = imdb;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	public Movies(String movieName, float imdb, String poster ) {
		this.movieName = movieName;
		this.imdb = imdb;
		this.poster= poster;
		
	}
	
	@Override
	public String toString() {
		return String.format("Movie[id=%d, movieName='%s', imdb=%f, poster='%s']", id, movieName, imdb,poster);
	}
}
