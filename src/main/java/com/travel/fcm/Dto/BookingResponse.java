package com.travel.fcm.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookingResponse {
    private Long bookingId;
    private String status;
    private double amount;
    private String flightId;
}
