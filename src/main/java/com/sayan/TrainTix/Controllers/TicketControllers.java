package com.sayan.TrainTix.Controllers;

import com.sayan.TrainTix.DTO.TicketRequest;
import com.sayan.TrainTix.DTO.TicketResponse;
import com.sayan.TrainTix.Services.Implementations.TicketServiceImpl;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TrainTix/ticket")
public class TicketControllers {
    @Autowired
    private TicketServiceImpl ticketService;

    @PostMapping("/book")
    public ResponseEntity<TicketResponse> bookTicket(@RequestBody TicketRequest ticketRequest) {
        return new ResponseEntity<>(ticketService.bookTicket(ticketRequest), HttpStatus.CREATED);
    }

    @GetMapping("/view")
    public ResponseEntity<TicketResponse> viewTicket(@RequestParam String ticketNumber) {
        return new ResponseEntity<>(ticketService.viewTicket(ticketNumber), HttpStatus.FOUND);
    }

}