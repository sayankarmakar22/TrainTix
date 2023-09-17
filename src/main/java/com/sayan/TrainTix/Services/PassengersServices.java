package com.sayan.TrainTix.Services;

import com.sayan.TrainTix.DTO.RegisterPassengersRequest;
import com.sayan.TrainTix.DTO.RegisterPassengersResponse;
import com.sayan.TrainTix.Model.Passengers;

import java.util.List;
import java.util.Map;

public interface PassengersServices {
    RegisterPassengersResponse registerPassengers(Passengers passengers);
    RegisterPassengersResponse updatePassengersDetails(RegisterPassengersRequest registerPassengersRequest);
    RegisterPassengersResponse viewRegisterPassengers(String username);
    String deletePassengersProfile(String userId);

    //for admin purpose

    List<Map<String,Object>> getAllPassengers();
}
