package com.wladek.project.client.application.header.header.movieitem;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class MovieItemView extends ViewImpl implements MovieItemPresenter.MyView {
    interface Binder extends UiBinder<Widget, MovieItemView> {
    }
    
    @UiField
    Label movieTitleLabel;

    @Inject
    MovieItemView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

	public Label getMovieTitleLabel() {
		return movieTitleLabel;
	}
    
}