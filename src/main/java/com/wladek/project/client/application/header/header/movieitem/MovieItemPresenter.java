package com.wladek.project.client.application.header.header.movieitem;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.wladek.project.client.application.header.header.HeaderPresenter;
import com.wladek.project.client.models.MoviesDto;
import com.wladek.project.client.place.NameTokens;
import com.wladek.project.client.requests.GetMoviesRequest;
import com.wladek.project.client.responses.GetMoviesResponse;

public class MovieItemPresenter extends Presenter<MovieItemPresenter.MyView, MovieItemPresenter.MyProxy> {
	interface MyView extends View {
		Label getMovieTitleLabel();
	}

	@NameToken(NameTokens.movieItem)
	@ProxyCodeSplit
	interface MyProxy extends ProxyPlace<MovieItemPresenter> {
	}
	
	@Inject
	DispatchAsync dispatcher;

	private MoviesDto moviesDto;
	
	@Inject
	MovieItemPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy);
	}
	
	@Override
	public void revealInParent(){
		RevealContentEvent.fire(this, HeaderPresenter.SLOT_CONTENT ,this);
	}
	
	private String name = "0";
	private Long id = null;

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		id = new Long(request.getParameter("id", name));
		bindMovieItem(id);
	}
	
	private void bindMovieItem(Long id) {
		GetMoviesRequest action = new GetMoviesRequest(id);
		
		dispatcher.execute(action, new AsyncCallback<GetMoviesResponse>() {

			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(GetMoviesResponse result) {
				moviesDto = result.getMovie();
				getView().getMovieTitleLabel().setText(result.getMovie().getName());
			}
		});
	}

	@Override
	public void onBind(){
		super.onBind();
	}
	
	@Override
	public void onReset(){
		super.onReset();
		getView().getMovieTitleLabel().setText(moviesDto.getName());
	}
	
}