package com.sayan.TrainTix.Controllers;

import com.sayan.TrainTix.DTO.RegisterPassengersRequest;
import com.sayan.TrainTix.DTO.RegisterPassengersResponse;
import com.sayan.TrainTix.Model.Passengers;
import com.sayan.TrainTix.Services.Implementations.PassengersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TrainTix/passengers")
public class PassengersBasicControllers {
    @Autowired
    private PassengersServiceImpl passengersService;

    @PostMapping("/register")
    public ResponseEntity<RegisterPassengersResponse> registerPassengers(@RequestBody Passengers passengers) throws Exception {
            return new ResponseEntity<>(passengersService.registerPassengers(passengers), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-account")
    public ResponseEntity<String> deleteAccount(@RequestParam String userId){
        return new ResponseEntity<>(passengersService.deletePassengersProfile(userId),HttpStatus.OK);
    }
    @PutMapping("/update-account-details")
    public ResponseEntity<RegisterPassengersResponse> updateAccountDetails(@RequestBody RegisterPassengersRequest registerPassengersRequest){
        return new ResponseEntity<>(passengersService.updatePassengersDetails(registerPassengersRequest),HttpStatus.ACCEPTED);
    }
    @GetMapping("/view-account")
    public ResponseEntity<RegisterPassengersResponse> viewAccount(@RequestParam String username){
        return new ResponseEntity<>(passengersService.viewRegisterPassengers(username),HttpStatus.FOUND);
    }
}
