package com.wladek.project.client.application.header.header.third.ratemovie;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.wladek.project.client.application.header.header.UserEmotionEvent;
import com.wladek.project.client.application.header.header.third.ratemovie.whynot.WhyNotPresenter;
import com.gwtplatform.mvp.client.HasUiHandlers;

public class RateMoviePresenter extends PresenterWidget<RateMoviePresenter.MyView> implements RateMovieUiHandlers {
	interface MyView extends View, HasUiHandlers<RateMovieUiHandlers> {
		Button getYesBtn();

		Button getNoBtn();
	}

	@Inject
	WhyNotPresenter whyNotPresenter;
	
	private EventBus eventBus;

	@Inject
	RateMoviePresenter(EventBus eventBus, MyView view) {
		super(eventBus, view);
		this.eventBus = eventBus;
		getView().setUiHandlers(this);
	}

	@Override
	public void onBind() {
		super.onBind();

		getView().getYesBtn().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Window.alert(" Thank you. Am glad to hear that");
			}
		});

		getView().getNoBtn().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				/*
				 * Instatiating and firing an event
				 */
				UserEmotionEvent  emotionevent = new UserEmotionEvent(" Bored with this staff !!!!!");
				RateMoviePresenter.this.eventBus.fireEvent(emotionevent);
				addToPopupSlot(whyNotPresenter);
			}
		});
	}

}