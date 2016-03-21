package com.wladek.project.client.application.header.header.third.ratemovie.whynot;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewImpl;

class WhyNotView extends PopupViewImpl implements WhyNotPresenter.MyView {
    interface Binder extends UiBinder<Widget, WhyNotView> {
    }

    @UiField
    Button okBtn;

    @Inject
    WhyNotView(EventBus eventBus, Binder uiBinder) {
        super(eventBus);
    
        initWidget(uiBinder.createAndBindUi(this));
    }

	public Button getOkBtn() {
		return okBtn;
	}
}