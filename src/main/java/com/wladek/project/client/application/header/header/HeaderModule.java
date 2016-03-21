package com.wladek.project.client.application.header.header;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.wladek.project.client.application.home.HomeModule;
import com.wladek.project.client.application.header.header.movieitem.MovieItemModule;
import com.wladek.project.client.application.header.header.third.ThirdModule;

public class HeaderModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
		install(new ThirdModule());
		install(new MovieItemModule());
		install(new HomeModule());
        bindPresenter(HeaderPresenter.class, HeaderPresenter.MyView.class, HeaderView.class, HeaderPresenter.MyProxy.class);
    }
}