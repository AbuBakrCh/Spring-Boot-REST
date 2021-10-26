package com.my.flights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FlightsService {

    private FlightsDAO flightsDAO;

    @Autowired
    public FlightsService(FlightsDAO flightsDAO) {
        this.flightsDAO = flightsDAO;
    }

    public List<Flight> getAllFlights() {
        return flightsDAO.findAll();
    }

    public void persistFlightsList(List<Flight> flights) {
        flightsDAO.saveAll(flights);
    }

    public void persistFlight(Flight flight) {
        flightsDAO.save(flight);
    }

    public Flight getFlightById(long id) {
        Optional flight =  flightsDAO.findById(id);
        if(flight.isPresent()) {
            return (Flight) flight.get();
        }
        return null;
    }

    @Transactional
    public void updateFlight(long id, int emptySeats, int totalSeats) {
        Optional flightOptional = flightsDAO.findById(id);
        Flight flight = (Flight) flightOptional.get();

        flight.setEmptySeats(emptySeats);
        flight.setTotalSeats(totalSeats);
    }
}