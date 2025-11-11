package org.example.findmygate.weatherdto;

import org.springframework.beans.factory.annotation.Value;

public class WeatherRequestDTO {

    private String query;

    @Value("${weather.api.key}")
    private String key;

    public WeatherRequestDTO(String query, String key) {
        this.query = query;
        this.key = key;
    }

    public String getQuery() {
        return query;
    }

    public String getKey() {
        return key;
    }
}
