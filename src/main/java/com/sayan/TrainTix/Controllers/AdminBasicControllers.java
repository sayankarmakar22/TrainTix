package com.sayan.TrainTix.Controllers;

import com.sayan.TrainTix.DTO.AdminRequestForUpdation;
import com.sayan.TrainTix.DTO.AdminResponse;
import com.sayan.TrainTix.DTO.RegisterPassengersResponse;
import com.sayan.TrainTix.Model.Admin;
import com.sayan.TrainTix.Model.Ticket;
import com.sayan.TrainTix.Model.Train;
import com.sayan.TrainTix.Repository.TrainRepo;
import com.sayan.TrainTix.Services.Implementations.AdminServiceImpl;
import com.sayan.TrainTix.Services.Implementations.PassengersServiceImpl;
import com.sayan.TrainTix.Services.Implementations.TicketServiceImpl;
import com.sayan.TrainTix.Services.Implementations.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/TrainTix/Admin")
public class AdminBasicControllers {
    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private PassengersServiceImpl passengersService;

    @Autowired
    private TrainServiceImpl trainService;

    @Autowired
    private TicketServiceImpl ticketService;

    @PostMapping("/register-admin")
    public ResponseEntity<AdminResponse> registerAdmin(@RequestBody Admin admin){
        return new ResponseEntity<>(adminService.registerAdmin(admin), HttpStatus.CREATED);

    }
    @GetMapping("/view-admin")
    public ResponseEntity<AdminResponse> getAdminDetails(@RequestParam String adminID){
        return new ResponseEntity<>(adminService.viewAdmin(adminID), HttpStatus.FOUND);
    }
    @PutMapping("/update-admin")
    public ResponseEntity<AdminResponse> updateAdminDetails(@RequestBody AdminRequestForUpdation adminRequestForUpdation){
        return new ResponseEntity<>(adminService.updateAdmin(adminRequestForUpdation), HttpStatus.ACCEPTED);

    }
    @DeleteMapping("/delete-admin")
    public ResponseEntity<String> delete(@RequestParam String adminId){
        return new ResponseEntity<>(adminService.deleteAdmin(adminId), HttpStatus.CREATED);
    }

    @GetMapping("/list-all-passengers")
    public ResponseEntity<List<Map<String,Object>>> listAllPassengers(){
        return new ResponseEntity<>(passengersService.getAllPassengers(),HttpStatus.FOUND);
    }
    @GetMapping("/list-all-train")
    public ResponseEntity<List<Train>> listAllTrain(){
        return new ResponseEntity<>(trainService.getAllTrain(),HttpStatus.FOUND);
    }
    @GetMapping("/list-all-booking")
    public ResponseEntity<List<Ticket>> listAllBookingByTrainNumber(@RequestParam String trainNumber){
        return new ResponseEntity<>(ticketService.listAllBooking(trainNumber),HttpStatus.FOUND);
    }
}
