package com.travel.fcm.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Flight {

    private String id;          // e.g. "AI202"
    private String airline;     // "Air India"
    private String from;        // "BLR"
    private String to;          // "DEL"
    private LocalDate date;     // flight date
    private double price;
    private int availableSeats;
}
