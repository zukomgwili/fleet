package com.thlight.Fleet;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Slf4j
@Service
@RequiredArgsConstructor
public class Workshop {
    private final Garage garage;
    public Flux<Vehicle> doFullService(String make){
        return garage.findByMake(make)
                .flatMap(this::checkWheelAlignment)
                .flatMap(this::changeSparkPlugs)
                .flatMap(this::checkBrakes)
                .flatMap(this::changeFilter)
                .flatMap(this::changeEngineOil);
    }

    private Mono<Vehicle> checkWheelAlignment(Vehicle vehicle) {
        log.info("Changing wheel alignment...");
        return Mono.just(vehicle);
    }

    private Mono<Vehicle> changeSparkPlugs(Vehicle vehicle) {
        log.info("Changing spark plugs...");
        return Mono.just(vehicle);
    }

    private Mono<Vehicle> checkBrakes(Vehicle vehicle) {
        log.info("Changing brakes...");
        return Mono.just(vehicle);
    }

    private Mono<Vehicle> changeFilter(Vehicle vehicle) {
        log.info("Changing filter...");
        return Mono.just(vehicle);
    }

    private Mono<Vehicle> changeEngineOil(Vehicle vehicle) {
        log.info("Changing engine oil...");
        return Mono.just(vehicle);
    }
}
