package com.travel.fcm.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Booking {
    private Long id;           // internal booking id
    private String customerName;
    private String flightId;
    private int seats;
    private double totalAmount;
    private BookingStatus status; // enum CONFIRMED, CANCELLED
}