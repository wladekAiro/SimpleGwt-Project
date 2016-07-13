package com.wladek.project.client.application.home.movie;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.wladek.project.client.application.header.header.movieitem.moviepopup.MoviePopUpPresenter;
import com.wladek.project.client.models.MoviesDto;
import com.gwtplatform.mvp.client.HasUiHandlers;

public class MoviePresenter extends PresenterWidget<MoviePresenter.MyView> implements MovieUiHandlers {
	interface MyView extends View, HasUiHandlers<MovieUiHandlers> {
		Label getMovieId();

		void setMovie(MoviesDto movie);

		Button getBtnCheckMe();

		MoviesDto getMovie();
	}

	@Inject
	MoviePresenter(EventBus eventBus, MyView view) {
		super(eventBus, view);

		getView().setUiHandlers(this);
	}

	@Inject
	PlaceManager placeManger;
	
	@Inject
	MoviePopUpPresenter moviePopUp;

	@Override
	public void onBind() {
		getView().getBtnCheckMe().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				moviePopUp.bindMovie(getView().getMovie());
				addToPopupSlot(moviePopUp);
			}
		});
	}

	public void bindMovie(MoviesDto moviesDto) {
		getView().setMovie(moviesDto);
	}
}