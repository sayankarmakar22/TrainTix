package com.sayan.TrainTix.Services;

import com.sayan.TrainTix.DTO.TrainRegisterRequest;
import com.sayan.TrainTix.DTO.TrainRegisterResponse;
import com.sayan.TrainTix.Model.Train;

import java.util.List;

public interface TrainServices {
    TrainRegisterResponse addTrain(TrainRegisterRequest trainRegisterRequest);
    TrainRegisterResponse updateTrain(TrainRegisterRequest trainRegisterRequest);
    TrainRegisterResponse viewTrain(String trainNumber);
    String removeTrain(String trainNumber);
    

    List<Train> getAllTrain();

}
