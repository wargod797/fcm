package com.travel.fcm.service;

import com.travel.fcm.Model.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    private final List<Flight> flights = new ArrayList<>();

    public FlightServiceImpl() {
        flights.add(new Flight("AI202", "Air India", "BLR", "DEL",
                LocalDate.of(2025, 2, 1), 5200, 40));
        flights.add(new Flight("6E101", "Indigo", "BLR", "BOM",
                LocalDate.of(2025, 2, 1), 4500, 30));
    }

    @Override
    public List<Flight> searchFlights(String from, String to, LocalDate date) {

        return flights.stream()
                .filter(f -> f.getFrom().equalsIgnoreCase(from))
                .filter(f -> f.getTo().equalsIgnoreCase(to))
                .filter(f -> f.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Flight> getFlightById(String flightId) {
        return flights.stream()
                .filter(flight -> flight.getId().equalsIgnoreCase(flightId))
                .findFirst();
    }
}

