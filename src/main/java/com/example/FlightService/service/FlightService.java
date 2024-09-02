package com.example.FlightService.service;

import com.example.FlightService.model.Flight;
import com.example.FlightService.repository.FlightRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flux<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Mono<Flight> getFlightById(String id) {
        return flightRepository.findById(id);
    }

    public Flux<Flight> findFlights(String origin, String destination) {
        return flightRepository.findByOriginAndDestination(origin, destination);
    }

    public Mono<Flight> saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Mono<Void> deleteFlight(String id) {
        return flightRepository.deleteById(id);
    }
}
