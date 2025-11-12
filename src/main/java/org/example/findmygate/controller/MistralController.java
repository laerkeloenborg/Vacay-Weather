package org.example.findmygate.controller;
import org.example.findmygate.service.MistralService;
import org.example.findmygate.service.WeatherService;
import org.example.findmygate.weatherdto.WeatherRequestDTO;
import org.example.findmygate.weatherdto.WeatherResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
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

    /*
    @GetMapping("/packinglist")
    public Map<String, Object> packinglist(@RequestParam String location) {
        WeatherRequestDTO request = new WeatherRequestDTO(location, weatherKey);
        WeatherResponseDTO weatherResponse = weatherService.forecast(request).block();
        Map<String, Object> mistralResponse = mistralService.promptMistral(weatherResponse);

        Map<String, Object> result = new HashMap<>();
        result.put("weather", weatherResponse);
        result.put("ai", mistralResponse);
        return result;
    }

     */
    @GetMapping("/packinglist")
    public ResponseEntity<?> packinglist(@RequestParam String location) {
        try {
            // Hent vejrudsigten
            WeatherRequestDTO request = new WeatherRequestDTO(location, weatherKey);
            WeatherResponseDTO weatherResponse = weatherService.forecast(request).block();

            if (weatherResponse == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Weather response was null for location: " + location);
            }

            // Hent AI response
            Map<String, Object> mistralResponse;
            try {
                mistralResponse = mistralService.promptMistral(weatherResponse);
            } catch (Exception e) {
                e.printStackTrace(); // print stack trace til konsollen
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error calling Mistral service: " + e.getMessage());
            }

            // Returner samlet resultat
            Map<String, Object> result = new HashMap<>();
            result.put("weather", weatherResponse);
            result.put("ai", mistralResponse);
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            e.printStackTrace(); // print stack trace til konsollen
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Unexpected error: " + e.getMessage());
        }
    }

}
