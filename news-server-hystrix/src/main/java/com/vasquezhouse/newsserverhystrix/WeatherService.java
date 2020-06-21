package com.vasquezhouse.newsserverhystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getWeatherFallback")
    public String getWeather() {
        return restTemplate.getForEntity("http://weather-server/weather", String.class).getBody();
    }

    public String getWeatherFallback() {
        return "unknown";
    }

    private final RestTemplate restTemplate;
}
