package com.sayan.TrainTix.Services;

import com.sayan.TrainTix.DTO.RegisterPassengersRequest;
import com.sayan.TrainTix.DTO.RegisterPassengersResponse;
import com.sayan.TrainTix.Model.Passengers;

public interface PassengersServices {
    RegisterPassengersResponse registerPassengers(Passengers passengers);
    RegisterPassengersResponse updatePassengersDetails(RegisterPassengersRequest registerPassengersRequest);
    RegisterPassengersResponse viewRegisterPassengers(String username);
    String deletePassengersProfile(String userId);
}
