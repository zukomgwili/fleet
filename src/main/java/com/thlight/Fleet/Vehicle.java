package com.thlight.Fleet;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Vehicle {
    @Id
    private Long id;
    private String make;
    private String model;
    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format("Vehicle[id=%d, make=%s, model=%s]", id, make, model);
    }
}
