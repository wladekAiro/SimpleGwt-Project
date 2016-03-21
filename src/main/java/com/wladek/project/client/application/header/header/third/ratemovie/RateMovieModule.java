package com.wladek.project.client.application.header.header.third.ratemovie;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.wladek.project.client.application.header.header.third.ratemovie.whynot.WhyNotModule;

public class RateMovieModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
            install(new WhyNotModule());
			bindPresenterWidget(RateMoviePresenter.class, RateMoviePresenter.MyView.class, RateMovieView.class);
    }
}