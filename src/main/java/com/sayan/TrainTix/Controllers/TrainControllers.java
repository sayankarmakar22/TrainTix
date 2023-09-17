package com.sayan.TrainTix.Controllers;

import com.sayan.TrainTix.DTO.TrainRegisterRequest;
import com.sayan.TrainTix.DTO.TrainRegisterResponse;
import com.sayan.TrainTix.Services.Implementations.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TrainTix/Train")
public class TrainControllers {
    @Autowired
    private TrainServiceImpl trainService;

    @PostMapping("/register-train")
    public ResponseEntity<TrainRegisterResponse> registerTrain(@RequestBody TrainRegisterRequest trainRegisterRequest){
        return new ResponseEntity<>(trainService.addTrain(trainRegisterRequest), HttpStatus.CREATED);
    }
    @GetMapping("/view-train")
    public ResponseEntity<TrainRegisterResponse> getTrain(@RequestParam String trainNumber){
        return new ResponseEntity<>(trainService.viewTrain(trainNumber), HttpStatus.FOUND);
    }
    @PutMapping("/update-train")
    public ResponseEntity<TrainRegisterResponse> updateTrain(@RequestBody TrainRegisterRequest trainRegisterRequest){
        return new ResponseEntity<>(trainService.updateTrain(trainRegisterRequest), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/remove-train")
    public ResponseEntity<String> deleteTrain(@RequestParam String trainNumber){
        return new ResponseEntity<>(trainService.removeTrain(trainNumber), HttpStatus.OK);
    }
}
