package org.example.findmygate.controller;

import org.example.findmygate.service.MistralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MistralController {

    @Autowired
    private MistralService mistralService;

    @GetMapping("/test")
    public Map<String, Object> test() {
        Map<String, Object> testmap = mistralService.promptMistral();
        return testmap;
    }
}
