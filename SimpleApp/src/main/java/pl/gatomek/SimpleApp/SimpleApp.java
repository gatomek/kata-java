package pl.gatomek.SimpleApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SimpleApp {

	public static void main(String[] args) {
		SpringApplication.run(SimpleApp.class, args);
	}

}
