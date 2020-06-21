package com.vasquezhouse.newsserverhystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrafficService {

    public TrafficService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getTrafficFallback")
    public String getTraffic() {
        return restTemplate.getForEntity("http://traffic-server/traffic", String.class).getBody();
    }

    public String getTrafficFallback() {
        return "unknown";
    }

    private final RestTemplate restTemplate;
}
