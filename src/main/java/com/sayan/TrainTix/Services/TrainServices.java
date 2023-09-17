package com.sayan.TrainTix.Services;

import com.sayan.TrainTix.DTO.TrainRegisterRequest;
import com.sayan.TrainTix.DTO.TrainRegisterResponse;

public interface TrainServices {
    TrainRegisterResponse addTrain(TrainRegisterRequest trainRegisterRequest);
    TrainRegisterResponse updateTrain(TrainRegisterRequest trainRegisterRequest);
    TrainRegisterResponse viewTrain(String trainNumber);
    String removeTrain(String trainNumber);

}
