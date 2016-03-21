package com.wladek.project.client.application.header.header;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class UserEmotionEvent extends GwtEvent<UserEmotionEvent.UserEmotionHandler> {
    private static Type<UserEmotionHandler> TYPE = new Type<UserEmotionHandler>();
    
    public interface UserEmotionHandler extends EventHandler {
        void onUserEmotion(UserEmotionEvent event);
    }
    
    
    private final String message;
   
    public UserEmotionEvent(final String message) {
        this.message = message;
    }

    public static Type<UserEmotionHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final UserEmotionHandler handler) {
        handler.onUserEmotion(this);
    }

    @Override
    public Type<UserEmotionHandler> getAssociatedType() {
        return TYPE;
    }
    
    public String getMessage() {
        return this.message;
    }
}