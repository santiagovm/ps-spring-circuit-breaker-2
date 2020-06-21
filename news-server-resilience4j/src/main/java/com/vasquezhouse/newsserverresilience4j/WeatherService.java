package com.vasquezhouse.newsserverresilience4j;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "default", fallbackMethod = "getWeatherFallback")
    public String getWeather() {
        return restTemplate.getForEntity("http://weather-server/weather", String.class).getBody();
    }

    public String getWeatherFallback(Throwable throwable) {
        return "unknown";
    }

    private final RestTemplate restTemplate;
}
