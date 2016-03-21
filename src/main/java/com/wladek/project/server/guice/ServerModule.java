package com.wladek.project.server.guice;

import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;
import com.wladek.project.client.requests.GetMoviesRequest;
import com.wladek.project.server.actionHandlers.GetMoviesRequestHandler;

public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
    	bindHandler(GetMoviesRequest.class, GetMoviesRequestHandler.class);
    }
}