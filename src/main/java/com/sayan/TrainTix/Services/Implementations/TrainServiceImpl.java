package com.sayan.TrainTix.Services.Implementations;

import com.sayan.TrainTix.DTO.TrainRegisterRequest;
import com.sayan.TrainTix.DTO.TrainRegisterResponse;
import com.sayan.TrainTix.Helper.TrainBasicHelper;
import com.sayan.TrainTix.Model.Train;
import com.sayan.TrainTix.Repository.TrainRepo;
import com.sayan.TrainTix.Services.TrainServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainServiceImpl implements TrainServices {
    @Autowired
    private TrainRepo trainRepo;
    @Autowired
    private TrainBasicHelper trainBasicHelper;
    @Override
    public TrainRegisterResponse addTrain(TrainRegisterRequest trainRegisterRequest) {
        if(!trainRepo.existsBytrainNumber(trainRegisterRequest.getTrainNumber())){
            Train train = new Train();
            Train mappingTrainValue = trainBasicHelper.setTrain(trainRegisterRequest, train);
            Train savedTrain = trainRepo.save(mappingTrainValue);
            TrainRegisterResponse trainRegisterResponse = new TrainRegisterResponse();
            return trainBasicHelper.setTrainRegisterResponse(trainRegisterResponse,savedTrain);
        }
        throw new RuntimeException("user exists");
    }

    @Override
    public TrainRegisterResponse updateTrain(TrainRegisterRequest trainRegisterRequest) {
        if(trainRepo.existsBytrainNumber(trainRegisterRequest.getTrainNumber())){
            Train foundSavedTrain = trainRepo.findBytrainNumber(trainRegisterRequest.getTrainNumber());
            foundSavedTrain.setFare(trainRegisterRequest.getFare());
            foundSavedTrain.setDestinationStation(trainRegisterRequest.getDestinationStation());
            foundSavedTrain.setSourceStation(trainRegisterRequest.getSourceStation());
            Train updatedTrain = trainRepo.save(foundSavedTrain);
            TrainRegisterResponse trainRegisterResponse = new TrainRegisterResponse();
            return trainBasicHelper.setTrainRegisterResponse(trainRegisterResponse,updatedTrain);
        }
        throw new RuntimeException("you have tried to update an non-existing train");
    }

    @Override
    public TrainRegisterResponse viewTrain(String trainNumber) {
        Train foundTrainFromDb = trainRepo.findBytrainNumber(trainNumber);
        TrainRegisterResponse trainRegisterResponse = new TrainRegisterResponse();
        return trainBasicHelper.setTrainRegisterResponse(trainRegisterResponse,foundTrainFromDb);
    }


    @Override
    public String removeTrain(String trainNumber) {
        trainRepo.deleteById(trainNumber);
        return trainNumber + " has been deleted!!";
    }

    @Override
    public List<Train> getAllTrain() {
        return trainRepo.findAll();
    }
}
