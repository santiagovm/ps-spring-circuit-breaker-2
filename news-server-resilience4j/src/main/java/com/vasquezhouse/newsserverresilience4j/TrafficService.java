package com.vasquezhouse.newsserverresilience4j;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrafficService {

    public TrafficService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "default", fallbackMethod = "getTrafficFallback")
    public String getTraffic() {
        return restTemplate.getForEntity("http://traffic-server/traffic", String.class).getBody();
    }

    public String getTrafficFallback(Throwable throwable) {
        return "unknown";
    }

    private final RestTemplate restTemplate;
}
