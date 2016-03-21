package com.wladek.project.client.application.header.header.third;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.wladek.project.client.application.header.header.HeaderPresenter;
import com.wladek.project.client.application.header.header.third.ratemovie.RateMoviePresenter;
import com.wladek.project.client.place.NameTokens;

public class ThirdPresenter extends Presenter<ThirdPresenter.MyView, ThirdPresenter.MyProxy>
		implements ThirdUiHandlers {

	public static final Object SLOT_RATE = new Object();

	interface MyView extends View, HasUiHandlers<ThirdUiHandlers> {
	}

	@NameToken(NameTokens.third)
	@ProxyCodeSplit
	interface MyProxy extends ProxyPlace<ThirdPresenter> {
	}

	@Inject
	ThirdPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy);

		getView().setUiHandlers(this);
	}

	@Inject
	RateMoviePresenter ratePresenter;

	@Override
	public void revealInParent() {
		RevealContentEvent.fire(this, HeaderPresenter.SLOT_CONTENT, this);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onReset() {
		super.onReset();
		setInSlot(SLOT_RATE, ratePresenter);
	}
}