package com.wladek.project.client.application.header.header.third;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class ThirdView extends ViewWithUiHandlers<ThirdUiHandlers> implements ThirdPresenter.MyView {
	interface Binder extends UiBinder<Widget, ThirdView> {
	}

	@UiField
	HTMLPanel ratePanel;

	@Inject
	ThirdView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == ThirdPresenter.SLOT_RATE) {
			ratePanel.clear();

			if (content != null) {
				ratePanel.add(content);
			}
		} else {
			super.setInSlot(slot, content);
		}
	}

}