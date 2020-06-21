# Spring Circuit Breaker PoC
This is a Proof-of-Concept of the Circuit Breaker pattern using Spring Cloud Netflix Hystrix.

## ports

- `8761 | discovery-server`: Eureka Server
- `8081 | weather-server`: Eureka Client, exposes REST endpoint `/weather`

## running application

```
./gradlew bootRun --parallel
```

## killing process running listening on port

```
kill $(lsof -t -i:8080)
```
