package org.example.findmygate.controller;

import org.example.findmygate.service.WeatherService;
import org.example.findmygate.weatherdto.WeatherRequestDTO;
import org.example.findmygate.weatherdto.WeatherResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WeatherController {
    private final WeatherService weatherService;
    private final String weatherkey;

    public WeatherController(WeatherService weatherService,
                             @Value("${weather.api.key}")
                             String weatherkey) {
        this.weatherService = weatherService;
        this.weatherkey = weatherkey;
    }

    @GetMapping("/weathertest")
    public Mono<WeatherResponseDTO> getWeather() {
        // midlertidig test: hardcodet city
        WeatherRequestDTO request = new WeatherRequestDTO("London", weatherkey);
        return weatherService.forecast(request);
    }

    @GetMapping("/weather")
    public Mono<WeatherResponseDTO> getWeather(@RequestParam String city) {
        WeatherRequestDTO request = new WeatherRequestDTO(city, weatherkey);
        return weatherService.forecast(request);
    }
}
