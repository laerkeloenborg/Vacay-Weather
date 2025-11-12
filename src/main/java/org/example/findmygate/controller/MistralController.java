package org.example.findmygate.controller;
import org.example.findmygate.service.MistralService;
import org.example.findmygate.service.WeatherService;
import org.example.findmygate.weatherdto.WeatherRequestDTO;
import org.example.findmygate.weatherdto.WeatherResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class MistralController {

    private MistralService mistralService;
    private WeatherService weatherService;
    private String weatherKey;

    public MistralController(MistralService mistralService, WeatherService weatherService, @Value("${weather.api.key}")
    String weatherkey) {
        this.mistralService = mistralService;
        this.weatherService = weatherService;
        this.weatherKey = weatherkey;
    }

    @GetMapping("/packinglist")
    public Map<String, Object>packinglist(@RequestParam String location){
        WeatherRequestDTO request = new WeatherRequestDTO(location, weatherKey);
        WeatherResponseDTO response = weatherService.forecast(request).block();
        return mistralService.promptMistral(response);
    }
}
