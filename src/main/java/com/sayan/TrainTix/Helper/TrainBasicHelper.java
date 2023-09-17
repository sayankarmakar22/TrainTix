package com.sayan.TrainTix.Helper;

import com.sayan.TrainTix.DTO.TrainRegisterRequest;
import com.sayan.TrainTix.DTO.TrainRegisterResponse;
import com.sayan.TrainTix.Model.Train;
import org.springframework.stereotype.Component;

@Component
public class TrainBasicHelper {

    public Train setTrain(TrainRegisterRequest trainRegisterRequest,Train train){
        train.setTrainNumber(trainRegisterRequest.getTrainNumber());
        train.setTrainName(trainRegisterRequest.getTrainName());
        train.setTotalSeat(trainRegisterRequest.getTotalSeat());
        train.setTotalCoach(trainRegisterRequest.getTotalCoach());
        train.setSourceStation(trainRegisterRequest.getSourceStation());
        train.setDestinationStation(trainRegisterRequest.getDestinationStation());
        train.setCoachType(trainRegisterRequest.getCoachType());
        train.setFare(trainRegisterRequest.getFare());
        return train;
    }

    public TrainRegisterResponse setTrainRegisterResponse(TrainRegisterResponse trainRegisterResponse,Train train){
        trainRegisterResponse.setTrainName(train.getTrainName());
        trainRegisterResponse.setTrainNumber(train.getTrainNumber());
        trainRegisterResponse.setTotalSeat(train.getTotalSeat());
        trainRegisterResponse.setTotalCoach(train.getTotalCoach());
        trainRegisterResponse.setSourceStation(train.getSourceStation());
        trainRegisterResponse.setDestinationStation(train.getDestinationStation());
        trainRegisterResponse.setCoachType(train.getCoachType());
        trainRegisterResponse.setFare(train.getFare());
        return trainRegisterResponse;
    }
}
