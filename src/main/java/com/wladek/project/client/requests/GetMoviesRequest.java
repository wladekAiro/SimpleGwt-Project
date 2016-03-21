package com.wladek.project.client.requests;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.wladek.project.client.responses.GetMoviesResponse;

public class GetMoviesRequest extends  ActionImpl<GetMoviesResponse>{
	private String method;
	
	public GetMoviesRequest(){
	}
	
	@Override
	public boolean isSecured(){
		return false;
	}
	
	public GetMoviesRequest(String method){
		this.method = method;
	}
	
	public String getMethod() {
		return method;
	}
	
}
