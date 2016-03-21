package com.wladek.project.client.application.home.movie;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.wladek.project.server.models.shared.MoviesDto;

class MovieView extends ViewWithUiHandlers<MovieUiHandlers> implements MoviePresenter.MyView {
    interface Binder extends UiBinder<Widget, MovieView> {
    }

    @UiField
    Label movieId;
    
//    MoviesDto movie;
    
    @Inject
    MovieView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        movieId.setText(" Presenter widget ");
    }

	public Label getMovieId() {
		return movieId;
	}	
}