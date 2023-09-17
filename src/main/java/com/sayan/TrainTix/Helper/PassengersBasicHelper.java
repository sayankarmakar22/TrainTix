package com.sayan.TrainTix.Helper;

import com.sayan.TrainTix.DTO.RegisterPassengersRequest;
import com.sayan.TrainTix.DTO.RegisterPassengersResponse;
import com.sayan.TrainTix.Model.Passengers;
import com.sayan.TrainTix.Repository.PassengersRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class PassengersBasicHelper {
    @Autowired
    private PassengersRepo passengersRepo;
    public  Boolean  checkUsernameExistsOrNot(String username){
        return passengersRepo.existsByusername(username);
    }

    public RegisterPassengersResponse setRegisterPassengersResponse(RegisterPassengersResponse registerPassengersResponse, Passengers passengers){
        registerPassengersResponse.setName(passengers.getName());
        registerPassengersResponse.setDob(passengers.getDob());
        registerPassengersResponse.setPhone(passengers.getPhone());
        registerPassengersResponse.setEmail(passengers.getEmail());
        registerPassengersResponse.setAddress(passengers.getAddress());
        registerPassengersResponse.setUser_id(passengers.getUserId());
        registerPassengersResponse.setUsername(passengers.getUsername());
        return registerPassengersResponse;
    }


}
