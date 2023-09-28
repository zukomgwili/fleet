package com.thlight.Fleet;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface Garage extends ReactiveCrudRepository<Vehicle, Long> {
    @Query("SELECT * FROM vehicle WHERE make = :make")
    Flux<Vehicle> findByMake(String make);
}
