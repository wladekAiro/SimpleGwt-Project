package com.wladek.project.client.responses;

import java.util.List;

import com.gwtplatform.dispatch.rpc.shared.Result;
import com.wladek.project.client.models.MoviesDto;

public class GetMoviesResponse implements Result{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<MoviesDto> moviesDtos;
	private MoviesDto movie;
	
	public GetMoviesResponse(){
	}

	public GetMoviesResponse(List<MoviesDto> moviesDtos){
		this.moviesDtos = moviesDtos;
	}
	
	public GetMoviesResponse(MoviesDto moviesDto){
		this.movie = moviesDto;
	}
	
	public List<MoviesDto> getMoviesDtos() {
		return moviesDtos;
	}

	public MoviesDto getMovie() {
		return movie;
	}
	
}
