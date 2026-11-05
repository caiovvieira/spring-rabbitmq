package io.github.caiovvieira.demo_backend;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBackendApplication.class, args);
	}

}
