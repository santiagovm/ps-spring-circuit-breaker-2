# Spring Circuit Breaker PoC
This is a Proof-of-Concept of the Circuit Breaker pattern using Spring Cloud Netflix Hystrix.

## ports

- `3000 | grafana-server`: Grafana Server with dashboard connected to `prometheus-server`. Dashboard at http://localhost:3000/d/cT25vjTZz/resilience4j-dashboard  
- `8081 | weather-server`: Eureka Client, exposes REST endpoint http://localhost:8081/weather
- `8082 | news-server-hystrix`: Eureka Client, exposes REST endpoint http://localhost:8082/news. Calls `weather-server` and `traffic-server` with Hystrix-based circuit breakers
- `8083 | dashboard-hystrix`: Hystrix Dashboard, exposed at http://localhost:8083/hystrix. Then enter the location of hystrix stream http://localhost:8082/actuator/hystrix.stream
- `8084 | traffic-server`: Eureka Client, exposes REST endpoint http://localhost:8084/traffic
- `8085 | news-server-resilience4j`: Eureka Client, exposes REST endpoint http://localhost:8085/news. Calls `weather-server` and `traffic-server` with Resilience4j-based circuit breakers
- `8761 | discovery-server`: Eureka Server http://localhost:8761
- `9090 | prometheus-server`: Prometheus Server scraping metrics from `news-server-resilience4j`, exposes UI at http://localhost:9090/targets

## running application

```
foreman start
```

Using `Foreman` and `Procfile` to script starting the application processes.

To install Foreman use:

```
gem install foreman
```

More info:

- http://ddollar.github.io/foreman/
- http://blog.daviddollar.org/2011/05/06/introducing-foreman.html

## loading hystrix dashboard

- point browser to `http://localhost:8083/hystrix/`
- enter news server hystrix stream: `http://localhost:8082/actuator/hystrix.stream`

## killing process running listening on port

```
kill $(lsof -t -i:8080)
```

## reference

- https://github.com/spring-cloud-samples/spring-cloud-circuitbreaker-demo
- https://www.infoq.com/articles/spring-cloud-hystrix/
- https://github.com/RajeshBhojwani/springboot-resilience4j
- https://github.com/resilience4j/resilience4j-spring-boot2-demo
