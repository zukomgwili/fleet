package com.thlight.Fleet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.util.List;

@Slf4j
@SpringBootApplication
public class FleetApplication {

    public static void main(String[] args) {
        SpringApplication.run(FleetApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(Workshop workshop, Garage garage) {
        return args -> {
            garage.saveAll(
                    List.of(
                            new Vehicle("Vauxhall", "Vivaro"),
                            new Vehicle("Vauxhall", "Tigra"),
                            new Vehicle("Vauxhall", "Mokka"),
                            new Vehicle("Jaguar", "XE"),
                            new Vehicle("Jaguar", "F-PACE"),
                            new Vehicle("Land Rover", "Freelander"),
                            new Vehicle("Land Rover", "Discovery")
                    )
            ).blockLast(Duration.ofSeconds(10));

            workshop.doFullService("Vauxhall")
                    .doOnNext(vehicle -> log.info(vehicle.toString())).blockLast();
        };
    }
}
