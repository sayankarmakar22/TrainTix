package com.sayan.TrainTix.Services;

import com.sayan.TrainTix.DTO.TicketRequest;
import com.sayan.TrainTix.DTO.TicketResponse;
import com.sayan.TrainTix.Model.Ticket;

import java.util.List;

public interface TicketService {

    TicketResponse bookTicket(TicketRequest ticketRequest);
    TicketResponse viewTicket(String ticketNumber);

    List<Ticket> listAllBooking(String trainNumber);
}
