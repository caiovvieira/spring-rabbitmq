package io.github.caiovvieira.demo_worker;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWorkerApplication.class, args);
	}

}
