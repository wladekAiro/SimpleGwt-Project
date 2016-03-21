package com.wladek.project.client.application.home.movie;

import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
    import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.wladek.project.server.models.shared.MoviesDto;
import com.gwtplatform.mvp.client.HasUiHandlers;
public class MoviePresenter extends PresenterWidget<MoviePresenter.MyView> implements MovieUiHandlers {
    interface MyView extends View , HasUiHandlers<MovieUiHandlers> {
    	Label getMovieId();
    }

    @Inject
    MoviePresenter(
            EventBus eventBus,
            MyView view) {
        super(eventBus, view);
        
        getView().setUiHandlers(this);
    }
    
    @Override
    public void onBind(){
    }
}