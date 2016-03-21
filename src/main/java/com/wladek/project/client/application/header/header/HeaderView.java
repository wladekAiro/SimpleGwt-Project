package com.wladek.project.client.application.header.header;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class HeaderView extends ViewImpl implements HeaderPresenter.MyView {
    interface Binder extends UiBinder<Widget, HeaderView> {
    }

    @UiField
    HTMLPanel contentPanel;
    @UiField Label emotionLabel;

    @Inject
    HeaderView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		
		if(slot == HeaderPresenter.SLOT_CONTENT){
			contentPanel.clear();
			
			if(content != null){
				contentPanel.add(content);
			}
		}else{
			super.setInSlot(slot, content);
		}
	}

	public Label getEmotionLabel() {
		return emotionLabel;
	}
	
}