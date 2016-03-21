package com.wladek.project.client.application.header.header.third.ratemovie;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class RateMovieView extends ViewWithUiHandlers<RateMovieUiHandlers> implements RateMoviePresenter.MyView {
    interface Binder extends UiBinder<Widget, RateMovieView> {
    }

    @UiField
    Button yesBtn;
    @UiField
    Button noBtn;

    @Inject
    RateMovieView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

	public Button getYesBtn() {
		return yesBtn;
	}

	public Button getNoBtn() {
		return noBtn;
	}
}