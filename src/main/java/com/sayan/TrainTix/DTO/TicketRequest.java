package com.sayan.TrainTix.DTO;

import lombok.Data;

@Data
public class TicketRequest {
    private String passengerId;
    private String trainNumber;
    private String sourceStation;
    private String destinationStation;
}
