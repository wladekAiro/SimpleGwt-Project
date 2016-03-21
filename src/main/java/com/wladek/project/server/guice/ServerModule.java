package com.wladek.project.server.guice;

import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;
import com.wladek.project.server.shared.handlers.GetMoviesRequestHandler;
import com.wladek.project.server.shared.requests.GetMoviesRequest;

public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
    	bindHandler(GetMoviesRequest.class, GetMoviesRequestHandler.class);
    }
}