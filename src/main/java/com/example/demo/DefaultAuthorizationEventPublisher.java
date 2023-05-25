package com.example.demo;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationEventPublisher;
import org.springframework.security.authorization.event.AuthorizationDeniedEvent;
import org.springframework.security.authorization.event.AuthorizationGrantedEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class DefaultAuthorizationEventPublisher implements AuthorizationEventPublisher {
    private final ApplicationEventPublisher publisher;

    public DefaultAuthorizationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public <T> void publishAuthorizationEvent(
        Supplier<Authentication> authentication,
        T object,
        AuthorizationDecision decision
    ) {
        if (decision == null) {
            return;
        }
        var authorizationEvent = decision.isGranted() ?
            new AuthorizationGrantedEvent<>(authentication, object, decision) :
            new AuthorizationDeniedEvent<>(authentication, object, decision);
        publisher.publishEvent(authorizationEvent);
    }
}
