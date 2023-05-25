package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authorization.event.AuthorizationDeniedEvent;
import org.springframework.security.authorization.event.AuthorizationGrantedEvent;
import org.springframework.stereotype.Component;


@Component
public class DefaultAuthorizationEventListener {

    private final Logger logger;

    public DefaultAuthorizationEventListener() {
        this.logger = LoggerFactory.getLogger("authLogger");
    }


    @EventListener
    public void handleAuthorizationGrantedEvent(AuthorizationGrantedEvent<?> authorizationGrantedEvent) {
        logger.info("successfully accessed privileged resource");
    }

    @EventListener
    public void handleAuthorizationDeniedEvent(AuthorizationDeniedEvent<?> authorizationDeniedEvent) {
        logger.info("rejected access to privileged resource");
    }
}
