package com.wladek.project.server.models.dao.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.inject.Inject;
import com.wladek.project.client.models.MoviesDto;
import com.wladek.project.server.models.dao.MoviesDao;

public class MoviesDaoHelper {
   Logger logger = Logger.getLogger("MOVIES DAO HELPER");
   
   @Inject
   MoviesDao dao;
   
   public List<MoviesDto> getAll(){
	   List<MoviesDto> movies = new ArrayList<MoviesDto>();
	    
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
	   
	   logger.info(" ++++ GET SINGLE MOVIE ++++ "+id);
	   
	   logger.info(" ++++ TOTAL ++++ "+getAll().size());
	   
	   for(MoviesDto dto : getAll()){
		   if(dto.getId() == id){
			   logger.info(" +++++ MOVIE NAME ++++ "+dto.getName());
			   return dto;
		   }
	   }
	   
	   return null;
   }
}
