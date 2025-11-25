package com.travel.fcm.service;

import com.travel.fcm.Model.Flight;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FlightService {

    List<Flight> searchFlights(String from, String to, LocalDate date);

    Optional<Flight> getFlightById(String flightId);
}
