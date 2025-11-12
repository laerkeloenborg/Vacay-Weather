package org.example.findmygate.service;

import org.example.findmygate.weatherdto.WeatherRequestDTO;
import org.example.findmygate.weatherdto.WeatherResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

    private final WebClient webClient;

    @Autowired
    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.weatherstack.com/").build();
    }

    public Mono<WeatherResponseDTO> forecast(WeatherRequestDTO weatherRequestDTO) {
        return webClient
                .get()
                // ✅ Use .uri() properly with query params
                .uri(uriBuilder -> uriBuilder
                        .path("/forecast")
                        .queryParam("query", weatherRequestDTO.getQuery())
                        .queryParam("access_key", weatherRequestDTO.getKey())
                        .build())
                .retrieve()
                .bodyToMono(WeatherResponseDTO.class);
    }
}
