package org.example.findmygate.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MistralController {

    @Value("${open.mistral.api.key}")
    private String openapikey;

}
