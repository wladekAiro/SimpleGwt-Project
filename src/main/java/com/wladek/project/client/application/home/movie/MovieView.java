package com.wladek.project.client.application.home.movie;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.wladek.project.client.models.MoviesDto;

class MovieView extends ViewWithUiHandlers<MovieUiHandlers> implements MoviePresenter.MyView {
    interface Binder extends UiBinder<Widget, MovieView> {
    }

    @UiField
    Label movieId;
    @UiField
    Button btnCheckMe;
    
    private MoviesDto movie;
    
    @Inject
    MovieView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

	public Label getMovieId() {
		return movieId;
	}

	public MoviesDto getMovie() {
		return movie;
	}

	public void setMovie(MoviesDto movie2) {
		this.movie = movie2;
		movieId.setText(movie.getName());
	}

	public Button getBtnCheckMe() {
		return btnCheckMe;
	}
	
	
}