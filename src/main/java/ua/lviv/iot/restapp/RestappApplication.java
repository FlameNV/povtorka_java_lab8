package ua.lviv.iot.restapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"ua.lviv.iot.restapp.business",
				"ua.lviv.iot.restapp.dataaccess",
				"ua.lviv.iot.restapp.controller"})
@EnableJpaRepositories({"ua.lviv.iot.restapp.dataaccess"})
@EntityScan("ua.lviv.iot.restapp.model")
public class RestappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestappApplication.class, args);
	}

}
