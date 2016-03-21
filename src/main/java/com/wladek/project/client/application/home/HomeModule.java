package com.wladek.project.client.application.home;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.wladek.project.client.application.home.movie.MovieModule;

public class HomeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
		install(new MovieModule());
		bindPresenter(HomePagePresenter.class, HomePagePresenter.MyView.class, HomePageView.class,
                HomePagePresenter.MyProxy.class);
    }
}