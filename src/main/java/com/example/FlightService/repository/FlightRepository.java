package com.example.FlightService.repository;

import com.example.FlightService.model.Flight;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface FlightRepository extends ReactiveMongoRepository<Flight, String> {
    Flux<Flight> findByOriginAndDestination(String origin, String destination);
}
