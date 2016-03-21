package com.wladek.project.client.application.home;

import com.wladek.project.client.application.header.header.HeaderPresenter;
import com.wladek.project.client.application.home.movie.MoviePresenter;
import com.wladek.project.client.models.MoviesDto;
import com.wladek.project.client.place.NameTokens;
import com.wladek.project.client.requests.GetMoviesRequest;
import com.wladek.project.client.responses.GetMoviesResponse;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.common.client.IndirectProvider;
import com.gwtplatform.common.client.StandardProvider;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class HomePagePresenter extends Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> {
	interface MyView extends View {
		Label getFirstLabel();

		TextBox getFirstTextBox();

		Button getFirstButton();
	}

	@ProxyStandard
	@NameToken(NameTokens.home)
	interface MyProxy extends ProxyPlace<HomePagePresenter> {
	}

	@Inject
	PlaceManager placeManger;
	private DispatchAsync dyAsync;

	MoviesDto dto;

	private IndirectProvider<MoviePresenter> movieFactory;

	@Inject
	HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy, Provider<MoviePresenter> provider,
			final DispatchAsync dyAsync) {
		super(eventBus, view, proxy);

		this.movieFactory = new StandardProvider<>(provider);
		this.dyAsync = dyAsync;
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, HeaderPresenter.SLOT_CONTENT, this);
	}

	public static final Object SLOT_MOVIES = new Object();

	@SuppressWarnings("deprecation")
	@Override
	protected void onReset() {
		super.onReset();
		getView().getFirstTextBox().setText(" First text ");

		getView().getFirstButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				PlaceRequest placeRequest = new PlaceRequest(NameTokens.movieItem).with("name",
						getView().getFirstTextBox().getText());
				placeManger.revealPlace(placeRequest);
			}
		});

		setInSlot(SLOT_MOVIES, null);

		bindMovies();
	}

	private void bindMovies() {
		GetMoviesRequest action = new GetMoviesRequest("GET");
		
		dyAsync.execute(action, new AsyncCallback<GetMoviesResponse>() {

			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(GetMoviesResponse result) {
				
				for(final MoviesDto m : result.getMoviesDtos()){
					movieFactory.get(new AsyncCallback<MoviePresenter>() {

						@Override
						public void onSuccess(MoviePresenter result) {
							result.bindMovie(m);
							addToSlot(SLOT_MOVIES, result);
						}

						@Override
						public void onFailure(Throwable caught) {
						}
					});
				}
			}
		});
	}

	@Override
	public void onBind() {
	}

}