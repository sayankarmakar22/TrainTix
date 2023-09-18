package com.sayan.TrainTix.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class TicketResponse {
    private String ticketNumber;
    private String trainNumber;
    private String trainName;
    private long seatNumber;
    private String passengerId;
    private String passengerName;
    private String passengerPhone;
    private String sourceStation;
    private String destinationStation;
    private String coachType;
    private int fare;
    private Date bookingDateAndTime;
}
