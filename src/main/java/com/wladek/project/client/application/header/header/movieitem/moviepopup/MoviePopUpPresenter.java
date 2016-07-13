package com.wladek.project.client.application.header.header.movieitem.moviepopup;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.wladek.project.client.models.MoviesDto;
import com.gwtplatform.mvp.client.PopupView;

public class MoviePopUpPresenter extends PresenterWidget<MoviePopUpPresenter.MyView> {
	interface MyView extends PopupView {
		void setMovie(MoviesDto movie);
		Button getBtnOk();
		Button getBtnCancel();
	}

	@Inject
	MoviePopUpPresenter(EventBus eventBus, MyView view) {
		super(eventBus, view);

	}

	public void bindMovie(MoviesDto movie) {
		getView().setMovie(movie);
	}

	@Override
	public void onBind() {

		getView().getBtnOk().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				getView().hide();
			}
		});
		
		getView().getBtnCancel().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				getView().hide();
			}
		});
	}

}