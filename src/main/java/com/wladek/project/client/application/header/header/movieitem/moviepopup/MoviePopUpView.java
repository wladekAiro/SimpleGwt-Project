package com.wladek.project.client.application.header.header.movieitem.moviepopup;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewImpl;
import com.wladek.project.client.models.MoviesDto;

class MoviePopUpView extends PopupViewImpl implements MoviePopUpPresenter.MyView {
    interface Binder extends UiBinder<Widget, MoviePopUpView> {
    }

    @UiField
    Label lblMovie;
    @UiField
    TextArea txtDescription;
    @UiField
    Button btnOk;
    @UiField
    Button btnCancel;
    
    @Inject
    MoviePopUpView(EventBus eventBus, Binder uiBinder) {
        super(eventBus);
    
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    private MoviesDto movie;

	public MoviesDto getMovie() {
		return movie;
	}

	public void setMovie(MoviesDto movie) {
		this.movie = movie;
		lblMovie.setText(movie.getName());
		txtDescription.setText(movie.getDescription());
	}

	public Label getLblMovie() {
		return lblMovie;
	}

	public TextArea getTxtDescription() {
		return txtDescription;
	}

	public Button getBtnOk() {
		return btnOk;
	}

	public Button getBtnCancel() {
		return btnCancel;
	}
    
}