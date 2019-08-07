package com.kingpra;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kingpra.model.Car;
import com.kingpra.repository.CarRepository;

@SpringBootApplication
public class OktaRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OktaRestApiApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CarRepository repository) {
		return args -> {
			Stream.of("Ferrari", "Jaguar F-type", "Porsche", "Lamborghini", "Bugatti", "AMC Gremlin", "Triumph Stag",
					"Ford Pinto", "Yugo GV").forEach(name -> {
						Car car = new Car();
						car.setName(name);
						repository.save(car);
					});
			repository.findAll().forEach(System.out::println);
		};
	}

}
