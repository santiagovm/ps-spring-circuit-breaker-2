# Spring Circuit Breaker PoC
This is a Proof-of-Concept of the Circuit Breaker pattern using Spring Cloud Netflix Hystrix.

## ports

- `8761 | discovery-server`: Eureka Server
- `8081 | weather-server`: Eureka Client, exposes REST endpoint `/weather`
- `8082 | news-server-hystrix`: Eureka Client, exposes REST endpoint `/news`. Calls `/weather` and protects with Hystrix-based circuit breaker
- `8083 | dashboard-hystrix`: Hystrix Dashboard, exposed at `/hystrix` 

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
