package com.travel.fcm.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookingRequest {

    private String customerName;

    private String flightId;

    private int seats;
}

