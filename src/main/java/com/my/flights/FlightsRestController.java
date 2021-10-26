package com.my.flights;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/flights")
public class FlightsRestController {

    private FlightsService flightsService;

    @Autowired
    public FlightsRestController(FlightsService flightsService) {
        this.flightsService = flightsService;
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightsService.getAllFlights();
    }

    @GetMapping(value="getFlightById/{id}")
    public Flight getFlightById(@PathVariable long id) {
        return flightsService.getFlightById(id);
    }

    @PostMapping(value = "/singleFlight")
    public ResponseEntity<String> postFlight(@RequestBody Flight flight){
        flightsService.persistFlight(flight);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }

    @PostMapping
    public void postFlights(@RequestBody List<Flight> flights) {
        flightsService.persistFlightsList(flights);
    }

    @PutMapping(value="/update/{id}")
    public void putFlights(@PathVariable long id, @RequestParam int emptySeats, @RequestParam int totalSeats) {
            flightsService.updateFlight(id, emptySeats, totalSeats);
    }
}