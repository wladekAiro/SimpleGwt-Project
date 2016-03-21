package com.wladek.project.client.application.header.header;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.wladek.project.client.application.header.header.UserEmotionEvent.UserEmotionHandler;

@SuppressWarnings("deprecation")
public class HeaderPresenter extends Presenter<HeaderPresenter.MyView, HeaderPresenter.MyProxy> {
	interface MyView extends View {
		Label getEmotionLabel();
	}

	/*
	 * Custom event handler
	 */
	private final UserEmotionHandler emotionHandler = new UserEmotionHandler() {
		
		@Override
		public void onUserEmotion(UserEmotionEvent event) {
			getView().getEmotionLabel().setText(event.getMessage());
		}
	};
	
	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_CONTENT = new Type<RevealContentHandler<?>>();

	@ProxyStandard
	interface MyProxy extends Proxy<HeaderPresenter> {
	}

	@Inject
	HeaderPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);
	}
	
	@Override
	public void onBind(){
		super.onBind();
		
		/*
		 * Binding the emotion handler inside register handler
		 */
		registerHandler(getEventBus().addHandler(UserEmotionEvent.getType(), emotionHandler));
	}

}