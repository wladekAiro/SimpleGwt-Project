package com.wladek.project.server.models.dao;

import com.wladek.project.server.models.Movies;

public class MoviesDao extends BaseDao{
	
	public Movies create(Movies moviesPO){
		return (Movies) save(moviesPO);
	}
	
	public Movies getOne(Long id){
		return findById(id, Movies.class);
	}
	
	public void delete(Long id){
		delete(getOne(id));
	}
}
