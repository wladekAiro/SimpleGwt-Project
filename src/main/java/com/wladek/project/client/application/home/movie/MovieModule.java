package com.wladek.project.client.application.home.movie;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class MovieModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
            bindPresenterWidget(MoviePresenter.class, MoviePresenter.MyView.class, MovieView.class);
    }
}