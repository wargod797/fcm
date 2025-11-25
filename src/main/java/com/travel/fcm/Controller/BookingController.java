package com.travel.fcm.Controller;

import com.travel.fcm.Dto.BookingRequest;
import com.travel.fcm.Dto.BookingResponse;
import com.travel.fcm.Model.Booking;
import com.travel.fcm.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(
             @RequestBody BookingRequest request) {

        Booking booking = bookingService.createBooking(request);

        BookingResponse response = new BookingResponse(
                booking.getId(),
                booking.getStatus().name(),
                booking.getTotalAmount(),
                booking.getFlightId()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
