package com.wladek.project.client.application.header.header.movieitem;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.wladek.project.client.application.header.header.movieitem.moviepopup.MoviePopUpModule;

public class MovieItemModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new MoviePopUpModule());
		bindPresenter(MovieItemPresenter.class, MovieItemPresenter.MyView.class, MovieItemView.class, MovieItemPresenter.MyProxy.class);
    }
}