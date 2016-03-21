package com.wladek.project.client.application.header.header.third.ratemovie.whynot;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.PopupView;

public class WhyNotPresenter extends PresenterWidget<WhyNotPresenter.MyView> {
	interface MyView extends PopupView {
		Button getOkBtn();
	}

	@Inject
	WhyNotPresenter(EventBus eventBus, MyView view) {
		super(eventBus, view);

	}

	@Override
	public void onBind(){
		super.onBind();
		
		getView().getOkBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				getView().hide();
			}
		});
	}
}