package org.example.findmygate.service;

import org.example.findmygate.mistraldto.*;
import org.example.findmygate.weatherdto.WeatherResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MistralService {
    private final WebClient webClient;

    @Autowired
    public MistralService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.mistral.ai/v1/chat/completions").build();
    }

    @Value("${open.mistral.api.key}")
    private String openapikey;

    public Map<String, Object> promptMistral(WeatherResponseDTO weatherResponse) {
        String weatherSummary = String.format(
                "In %s it's currently %d°C and %s.",
                weatherResponse.getLocation().getName(),
                weatherResponse.getCurrent().getTemperature(),
                String.join(", ", weatherResponse.getCurrent().getWeatherDescriptions())
        );

        String userPrompt = "Generate a summary about: " + weatherSummary +
                " Also, give packing advice based on this weather. Do not list in numbers and the text should not contain" +
                "special letters nor signs" +
                "I want headlines like, Layers, outerwear, sun protection and footwear" +
                "remove this headline: Packing Advice";

        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setModel("mistral-small-latest");
        requestDTO.setTemperature(1.0);
        requestDTO.setMaxTokens(400);

        List<Message> lstMessages = new ArrayList<>(); //en liste af messages med roller
        lstMessages.add(new Message("system", "You are a helpful assistant."));
        lstMessages.add(new Message("user", userPrompt));
        requestDTO.setMessages(lstMessages);
        ResponseDTO response = webClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .headers(h -> h.setBearerAuth(openapikey))
                .bodyValue(requestDTO)
                .retrieve()
                .bodyToMono(ResponseDTO.class)
                .block();

        List<Choice> lst = response.getChoices();
        Usage usg = response.getUsage();
        Map<String, Object> map = new HashMap<>();
        map.put("Usage", usg);
        map.put("Choices", lst);
        return map;
    }
}