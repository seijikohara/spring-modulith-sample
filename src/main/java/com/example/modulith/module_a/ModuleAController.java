package com.example.modulith.module_a;

import com.example.modulith.module_a.ModuleAService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TriggerEventController {

    private final ModuleAService moduleAService;

    public TriggerEventController(ModuleAService moduleAService) {
        this.moduleAService = moduleAService;
    }

    @GetMapping("/trigger-event")
    public Mono<String> triggerEvent(@RequestParam String message) {
        return Mono.fromCallable(() -> {
            moduleAService.createAndPublishEvent(message);
            return "イベント発行 (非同期): " + message;
        });
    }
}