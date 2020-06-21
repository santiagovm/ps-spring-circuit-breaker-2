package com.vasquezhouse.trafficserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@SpringBootApplication
public class TrafficServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrafficServerApplication.class, args);
	}

	@GetMapping("/traffic")
	public String getTraffic() {
		int rand = ThreadLocalRandom.current().nextInt(0, 3);
		return trafficConditions[rand];
	}

	private final String[] trafficConditions = new String[] { "clear", "bumper-to-bumper", "heavy" };
}
