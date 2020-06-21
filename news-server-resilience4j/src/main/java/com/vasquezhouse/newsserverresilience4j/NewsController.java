package com.vasquezhouse.newsserverresilience4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    public NewsController(WeatherService weatherService, TrafficService trafficService) {
        this.weatherService = weatherService;
        this.trafficService = trafficService;
    }

    @GetMapping("/news")
    public String getNews() {
        String weather = weatherService.getWeather();
        String traffic = trafficService.getTraffic();
        return String.format("[resilience4j-circuit-breaker] the weather is: [%s], the traffic is: [%s]", weather, traffic);
    }

    private final WeatherService weatherService;
    private final TrafficService trafficService;
}
