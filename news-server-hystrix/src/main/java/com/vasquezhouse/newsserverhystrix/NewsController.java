package com.vasquezhouse.newsserverhystrix;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    public NewsController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/news")
    public String getNews() {
        String weather = weatherService.getWeather();
        return String.format("the weather is: [%s]", weather);
    }

    private final WeatherService weatherService;
}
