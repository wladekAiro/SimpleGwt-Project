package com.wladek.project.server.models.dao.helpers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wladek.project.server.models.shared.MoviesDto;

public class MoviesDaoHelper {
   Logger logger = LoggerFactory.getLogger(MoviesDaoHelper.class);
   
   public List<MoviesDto> getAll(){
	   List<MoviesDto> movies = new ArrayList<>();
	    
	   MoviesDto dto = new MoviesDto();
	   dto.setId(new Long(1));
	   dto.setName("The god must be crazy");
	   dto.setDescription("African commedy acted in the kalahari desert");
	   movies.add(dto);
	   
	   dto = new MoviesDto();
	   dto.setId(new Long(2));
	   dto.setName("Kunfu panda 3");
	   dto.setDescription("Master the chi technique. Re-invention");
	   movies.add(dto);
	   
	   dto = new MoviesDto();
	   dto.setId(new Long(3));
	   dto.setName("Gods of egypt");
	   dto.setDescription("Ancient Egyptian epic. Egyptian gods battling for supremacy");
	   movies.add(dto);
	   
	   dto = new MoviesDto();
	   dto.setId(new Long(4));
	   dto.setName("Deadpool");
	   dto.setDescription("I am yet to watch this one. Checkout its trailers online");
	   movies.add(dto);
	   
	   return movies;
   }
   
   public MoviesDto getOne(Long id){
	   List<MoviesDto> movies = getAll();
	   
	   MoviesDto movie = null;
	   
	   for(MoviesDto dto : movies){
		   if(dto.getId() == id){
			   movie = dto;
		   }
	   }
	   
	   return movie;
   }
}
