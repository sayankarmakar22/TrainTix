package com.sayan.TrainTix.Helper;

import com.sayan.TrainTix.DTO.TicketRequest;
import com.sayan.TrainTix.DTO.TicketResponse;
import com.sayan.TrainTix.Model.Passengers;
import com.sayan.TrainTix.Model.Ticket;
import com.sayan.TrainTix.Model.Train;
import com.sayan.TrainTix.Repository.PassengersRepo;
import com.sayan.TrainTix.Repository.TrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class TicketHelper {
    @Autowired
    private TrainRepo trainRepo;
    @Autowired
    private PassengersRepo passengersRepo;


    public Boolean validateTrainNumberAndPassengerId(String trainNumber,String passengerId){
        return (passengersRepo.existsByuserId(passengerId) && (trainRepo.existsBytrainNumber(trainNumber)));
    }
    public int findLeftSeat(String trainNumber){
        return trainRepo.getLeftSeat(trainNumber);
    }

    public TicketResponse setTicketResponse(TicketResponse ticketResponse,
                                            Passengers passengers,
                                            long seatNumber,
                                            Train foundTrainFromDb,
                                            Passengers foundPassengerFromDb,
                                            Ticket savedTicket)
    {
        ticketResponse.setTicketNumber(savedTicket.getTicketNumber());
        ticketResponse.setTrainNumber(foundTrainFromDb.getTrainNumber());
        ticketResponse.setTrainName(foundTrainFromDb.getTrainName());
        ticketResponse.setSeatNumber(seatNumber);
        ticketResponse.setPassengerId(foundPassengerFromDb.getUserId());
        ticketResponse.setPassengerName(foundPassengerFromDb.getName());
        ticketResponse.setPassengerPhone(foundPassengerFromDb.getPhone());
        ticketResponse.setSourceStation(savedTicket.getSourceStation());
        ticketResponse.setDestinationStation(savedTicket.getDestinationStation());
        ticketResponse.setCoachType(foundTrainFromDb.getCoachType());
        ticketResponse.setFare(foundTrainFromDb.getFare());
        ticketResponse.setBookingDateAndTime(savedTicket.getBookingTime());
        return ticketResponse;
    }

    public Ticket setTicketForBooking(Ticket ticket,
                                      TicketRequest ticketRequest,
                                      Train foundTrainFromDb,
                                      Passengers foundPassengerFromDb,
                                      long seatNumber,
                                      Passengers passengers){
        ticket.setTicketNumber(String.valueOf(UUID.randomUUID()).substring(0,8));
        ticket.setTrainNumber(ticketRequest.getTrainNumber());
        ticket.setSourceStation(ticketRequest.getSourceStation());
        ticket.setDestinationStation(ticketRequest.getDestinationStation());
        ticket.setFare(foundTrainFromDb.getFare());
        ticket.setCoachType(foundTrainFromDb.getCoachType());
        ticket.setBookingTime(new Date());
        ticket.setSeatNumber(seatNumber);
        ticket.setPassengerId(ticketRequest.getPassengerId());
        return ticket;
    }

    public long lastSeatBookedNumber(String trainNumber){
        return trainRepo.getLastSeatBook(trainNumber);
    }
}
