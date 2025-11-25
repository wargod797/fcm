package com.travel.fcm.service;

import com.travel.fcm.Dto.BookingRequest;
import com.travel.fcm.Model.Booking;

public interface BookingService {
    Booking createBooking(BookingRequest request);
}
