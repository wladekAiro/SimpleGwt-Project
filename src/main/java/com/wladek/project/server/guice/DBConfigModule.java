//package com.wladek.project.server.guice;
//
//import com.google.inject.persist.PersistFilter;
//import com.google.inject.persist.jpa.JpaPersistModule;
//import com.google.inject.servlet.ServletModule;
//
//public class DBConfigModule extends ServletModule{
//	@Override
//	protected void configureServlets() {
//		super.configureServlets();
//		
//		install(new JpaPersistModule("movies_pu"));
//		
//		filter("/*").through(PersistFilter.class);
//	}
//
//}
