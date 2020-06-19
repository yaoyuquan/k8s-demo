package com.utry.k8s.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @GetMapping
    public String producer() {
        long timestamp = System.currentTimeMillis();
        return "send producer time : " + timestamp;
    }

}
