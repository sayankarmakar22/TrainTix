package com.sayan.TrainTix.Services.Implementations;

import com.sayan.TrainTix.DTO.RegisterPassengersRequest;
import com.sayan.TrainTix.DTO.RegisterPassengersResponse;
import com.sayan.TrainTix.Helper.PassengersBasicHelper;
import com.sayan.TrainTix.Model.Passengers;
import com.sayan.TrainTix.Repository.PassengersRepo;
import com.sayan.TrainTix.Services.PassengersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PassengersServiceImpl implements PassengersServices {

    @Autowired
    private PassengersRepo passengersRepo;

    @Autowired
    private PassengersBasicHelper passengersBasicHelper;
    @Override
    public RegisterPassengersResponse registerPassengers(Passengers passengers) {
        if(!passengersBasicHelper.checkUsernameExistsOrNot(passengers.getUsername())){
            Passengers savedPassengers = passengersRepo.save(passengers);
            RegisterPassengersResponse registerPassengersResponse = new RegisterPassengersResponse();
            return passengersBasicHelper.setRegisterPassengersResponse(registerPassengersResponse,passengers);
        }
        throw new RuntimeException("entered existing username");
    }

    @Override
    public RegisterPassengersResponse updatePassengersDetails(RegisterPassengersRequest registerPassengersRequest) {
        if(passengersRepo.existsByuserId(registerPassengersRequest.getUseId())){
            Passengers foundSavedPassengers = passengersRepo.findByuserId(registerPassengersRequest.getUseId());
            //update the passengers
            foundSavedPassengers.setPhone(registerPassengersRequest.getPhone());
            foundSavedPassengers.setEmail(registerPassengersRequest.getEmail());
            foundSavedPassengers.setAddress(registerPassengersRequest.getAddress());
            Passengers savedUpdatedPassenger = passengersRepo.save(foundSavedPassengers);
            RegisterPassengersResponse registerPassengersResponse = new RegisterPassengersResponse();
            return passengersBasicHelper.setRegisterPassengersResponse(registerPassengersResponse,savedUpdatedPassenger);
        }
        throw new RuntimeException("user not valid!");
    }

    @Override
    public RegisterPassengersResponse viewRegisterPassengers(String username) {

        if(passengersRepo.existsByusername(username)){
            Passengers foundPassengersFromDb = passengersRepo.findByusername(username);
            RegisterPassengersResponse registerPassengersResponse = new RegisterPassengersResponse();
            return passengersBasicHelper.setRegisterPassengersResponse(registerPassengersResponse,foundPassengersFromDb);
        }
        throw new RuntimeException("user not found!!");
    }

    @Override
    public String deletePassengersProfile(String userId) {
        String response = null;
       try{
           if(passengersRepo.existsByuserId(userId)){
               passengersRepo.deleteById(userId);
               response = userId + " has been deleted!!";
           }
           else{
               response = "you have tried to delete an non-existing account!!";
           }
       }
       catch (RuntimeException runtimeException){
           runtimeException.printStackTrace();
       }
       return response;
    }

    @Override
    public List<Map<String,Object>> getAllPassengers() {
        return passengersRepo.getAllPassengers();
    }
}
