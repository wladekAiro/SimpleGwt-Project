package com.wladek.project.server.shared.handlers;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;
import com.wladek.project.server.models.dao.helpers.MoviesDaoHelper;
import com.wladek.project.server.shared.requests.GetMoviesRequest;
import com.wladek.project.server.shared.response.GetMoviesResponse;

public class GetMoviesRequestHandler implements ActionHandler<GetMoviesRequest, GetMoviesResponse> {

	@Inject
	MoviesDaoHelper daoHelper;

	@Override
	public GetMoviesResponse execute(GetMoviesRequest arg0, ExecutionContext arg1) throws ActionException {
		GetMoviesResponse resp = (GetMoviesResponse) arg1;
		resp.setMoviesDtos(daoHelper.getAll());
		return resp;
	}

	@Override
	public Class<GetMoviesRequest> getActionType() {
		return GetMoviesRequest.class;
	}

	@Override
	public void undo(GetMoviesRequest arg0, GetMoviesResponse arg1, ExecutionContext arg2) throws ActionException {
		// TODO Auto-generated method stub

	}

}
