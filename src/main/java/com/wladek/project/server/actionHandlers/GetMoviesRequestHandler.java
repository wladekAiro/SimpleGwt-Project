package com.wladek.project.server.actionHandlers;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;
import com.wladek.project.client.requests.GetMoviesRequest;
import com.wladek.project.client.responses.GetMoviesResponse;
import com.wladek.project.server.models.dao.helpers.MoviesDaoHelper;

public class GetMoviesRequestHandler implements ActionHandler<GetMoviesRequest, GetMoviesResponse> {

	@Inject
	MoviesDaoHelper daoHelper;

	@Override
	public GetMoviesResponse execute(GetMoviesRequest request, ExecutionContext arg1) throws ActionException {
		String action = request.getMethod();
		
		GetMoviesResponse response = null;
		if(action != null){
			if(action.equals("ALL")){
				response = new GetMoviesResponse(daoHelper.getAll());
			}
		}else{
			if(request.getMovieId() != null){
				response = new GetMoviesResponse(daoHelper.getOne(request.getMovieId()));
			}
		}
		
		return response;
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
