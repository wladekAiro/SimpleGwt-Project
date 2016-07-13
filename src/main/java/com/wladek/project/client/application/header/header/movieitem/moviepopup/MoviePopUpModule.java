package com.wladek.project.client.application.header.header.movieitem.moviepopup;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class MoviePopUpModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
            bindPresenterWidget(MoviePopUpPresenter.class, MoviePopUpPresenter.MyView.class, MoviePopUpView.class);
    }
}