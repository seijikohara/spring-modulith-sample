package com.example.modulith.module.a;

import com.example.modulith.common.CustomEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ModuleAService {

    private final ApplicationEventPublisher eventPublisher;

    public ModuleAService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void createAndPublishEvent(String message) {
        CustomEvent event = new CustomEvent(this, message);
        eventPublisher.publishEvent(event);
    }
}