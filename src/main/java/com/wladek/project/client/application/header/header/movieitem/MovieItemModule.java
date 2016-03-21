package com.wladek.project.client.application.header.header.movieitem;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class MovieItemModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(MovieItemPresenter.class, MovieItemPresenter.MyView.class, MovieItemView.class, MovieItemPresenter.MyProxy.class);
    }
}