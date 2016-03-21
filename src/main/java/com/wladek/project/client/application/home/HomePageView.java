package com.wladek.project.client.application.home;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class HomePageView extends ViewImpl implements HomePagePresenter.MyView {
	interface Binder extends UiBinder<Widget, HomePageView> {
	}

	@UiField
	Label firstLabel;
	@UiField
	TextBox firstTextBox;
	@UiField
	Button firstButton;
	@UiField
	HTMLPanel moviesList;

	@Inject
	HomePageView(final Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public Label getFirstLabel() {
		return firstLabel;
	}

	public TextBox getFirstTextBox() {
		return firstTextBox;
	}

	public Button getFirstButton() {
		return firstButton;
	}

	@Override
	public void addToSlot(Object slot, IsWidget content) {
		if (slot == HomePagePresenter.SLOT_MOVIES) {
			
			if (content != null) {
				moviesList.add(content);
			}
			
		} else {
			super.addToSlot(slot, content);
		}
	}

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == HomePagePresenter.SLOT_MOVIES) {
			moviesList.clear();

			if (content != null) {
				moviesList.add(content);
			}
			
		} else {
			super.setInSlot(slot, content);
		}
	}

}