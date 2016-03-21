package com.wladek.project.client.application.header.header.third;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.wladek.project.client.application.header.header.third.ratemovie.RateMovieModule;

public class ThirdModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
		install(new RateMovieModule());
		bindPresenter(ThirdPresenter.class, ThirdPresenter.MyView.class, ThirdView.class, ThirdPresenter.MyProxy.class);
    }
}