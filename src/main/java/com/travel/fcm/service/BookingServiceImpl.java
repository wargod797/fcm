package com.travel.fcm.service;

import com.travel.fcm.Dto.BookingRequest;
import com.travel.fcm.Model.Booking;
import com.travel.fcm.Model.BookingStatus;
import com.travel.fcm.Model.Flight;
import com.travel.fcm.exceptions.BusinessException;
import com.travel.fcm.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final FlightService flightService;
    private final List<Booking> bookings = new ArrayList<>();
    private final Long idGenerator = Long.valueOf(1);

    public BookingServiceImpl(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    public Booking createBooking(BookingRequest request) {

        // 1. Fetch flight by ID
        Flight selectedFlight = flightService.getFlightById(request.getFlightId())
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found"));

        // 2. Validate seat availability
        if (selectedFlight.getAvailableSeats() < request.getSeats()) {
            throw new BusinessException("Not enough seats available");
        }

        // 3. Update available seats
        selectedFlight.setAvailableSeats(
                selectedFlight.getAvailableSeats() - request.getSeats()
        );

        // 4. Calculate amount
        double totalAmount = request.getSeats() * selectedFlight.getPrice();

        // 5. Create booking object
        Booking booking = new Booking(
                idGenerator,
                request.getCustomerName(),
                request.getFlightId(),
                request.getSeats(),
                totalAmount,
                BookingStatus.CONFIRMED
        );

        // Save in-memory list temperory
        bookings.add(booking);

        return booking;
    }
}

