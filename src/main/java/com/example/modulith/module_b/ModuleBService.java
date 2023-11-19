package com.example.modulith.module.b;

import com.example.modulith.common.CustomEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ModuleBService {

    @EventListener
    public void onCustomEvent(CustomEvent event) {
        System.out.println("イベント受信 in ModuleB: " + event.getMessage());
    }
}