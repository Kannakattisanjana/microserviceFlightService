package com.example.FlightService.controller;

import com.example.FlightService.model.Flight;
import com.example.FlightService.service.FlightService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public Flux<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public Mono<Flight> getFlightById(@PathVariable String id) {
        return flightService.getFlightById(id);
    }

    @GetMapping("/search")
    public Flux<Flight> findFlights(@RequestParam String origin, @RequestParam String destination) {
        return flightService.findFlights(origin, destination);
    }

    @PostMapping
    public Mono<Flight> createFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteFlight(@PathVariable String id) {
        return flightService.deleteFlight(id);
    }
}
