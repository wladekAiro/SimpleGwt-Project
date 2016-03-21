package com.wladek.project.server.shared.response;

import java.util.List;

import com.gwtplatform.dispatch.rpc.shared.Result;
import com.wladek.project.server.models.shared.MoviesDto;

public class GetMoviesResponse implements Result{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<MoviesDto> moviesDtos;
	
	public GetMoviesResponse(){
	}

	public List<MoviesDto> getMoviesDtos() {
		return moviesDtos;
	}

	public void setMoviesDtos(List<MoviesDto> moviesDtos) {
		this.moviesDtos = moviesDtos;
	}
}
