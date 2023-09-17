package com.sayan.TrainTix.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainRegisterResponse {
    private String trainNumber;

    private String trainName;

    private int totalSeat;

    private int totalCoach;

    private String sourceStation;

    private String destinationStation;

    private String coachType;

    private int fare;
}
