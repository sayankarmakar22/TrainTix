package com.sayan.TrainTix.Services.Implementations;

import com.sayan.TrainTix.DTO.TicketRequest;
import com.sayan.TrainTix.DTO.TicketResponse;
import com.sayan.TrainTix.Helper.TicketHelper;
import com.sayan.TrainTix.Model.Passengers;
import com.sayan.TrainTix.Model.Ticket;
import com.sayan.TrainTix.Model.Train;
import com.sayan.TrainTix.Repository.PassengersRepo;
import com.sayan.TrainTix.Repository.TicketRepo;
import com.sayan.TrainTix.Repository.TrainRepo;
import com.sayan.TrainTix.Services.TicketService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TrainRepo trainRepo;

    @Autowired
    private PassengersRepo passengersRepo;
    @Autowired
    private TicketHelper ticketHelper;

    @Autowired
    private TicketRepo ticketRepo;

    @Transactional
    @Override
    public synchronized TicketResponse  bookTicket(TicketRequest ticketRequest) {
        Train foundTrainFromDb = trainRepo.findBytrainNumber(ticketRequest.getTrainNumber());
        Passengers foundPassengerFromDb = passengersRepo.findByuserId(ticketRequest.getPassengerId());
        TicketResponse ticketResponse = new TicketResponse();
        if(((foundTrainFromDb.getTrainNumber().equals(ticketRequest.getTrainNumber())) && (foundPassengerFromDb.getUserId().equals(ticketRequest.getPassengerId()))) ){

            if(ticketHelper.validateTrainNumberAndPassengerId(ticketRequest.getTrainNumber(),ticketRequest.getPassengerId())){
                int seatsLeft = ticketHelper.findLeftSeat(ticketRequest.getTrainNumber());

                if((seatsLeft == 0) && (foundTrainFromDb.getCoachType().equals("AC"))){
                    int curYear = Integer.parseInt(ticketRequest.getTrainNumber());
                    int acCoachNumber = 13;
                    int lastThreeDigit = 1;
                    String seatNumber = String.valueOf(curYear) + String.valueOf(acCoachNumber) + String.valueOf(lastThreeDigit);
                    long finalSeatNumber = Long.parseLong(seatNumber);
                    Passengers passengers = new Passengers();
                    passengers.setUserId(ticketRequest.getPassengerId());
                    Ticket ticket = new Ticket();
                    Ticket mappingTicket = ticketHelper.setTicketForBooking(ticket, ticketRequest, foundTrainFromDb, foundPassengerFromDb, finalSeatNumber, passengers);
                    Ticket savedTicket = ticketRepo.save(mappingTicket);
                    return ticketHelper.setTicketResponse(ticketResponse,passengers,finalSeatNumber,foundTrainFromDb,foundPassengerFromDb,savedTicket);
                }
                else if( (seatsLeft > 0) && (foundTrainFromDb.getCoachType().equals("AC")) && (seatsLeft < foundTrainFromDb.getTotalSeat())){
                    int curYear = Integer.parseInt(ticketRequest.getTrainNumber());
                    int acCoachNumber = 13;
                    int lastThreeDigit = ticketHelper.findLeftSeat(ticketRequest.getTrainNumber()) + 1;
                    String seatNumber = String.valueOf(curYear) + String.valueOf(acCoachNumber) + String.valueOf(lastThreeDigit);
                    long finalSeatNumber = Long.parseLong(seatNumber);
                    Passengers passengers = new Passengers();
                    passengers.setUserId(ticketRequest.getPassengerId());
                    Ticket ticket = new Ticket();
                    Ticket mappingTicket = ticketHelper.setTicketForBooking(ticket, ticketRequest, foundTrainFromDb, foundPassengerFromDb, finalSeatNumber, passengers);
                    Ticket savedTicket = ticketRepo.save(mappingTicket);
                    return ticketHelper.setTicketResponse(ticketResponse,passengers,finalSeatNumber,foundTrainFromDb,foundPassengerFromDb,savedTicket);
                }
                else if((seatsLeft == 0) && (foundTrainFromDb.getCoachType().equals("GEN"))){
                    int curYear = Integer.parseInt(ticketRequest.getTrainNumber());
                    int acCoachNumber = 75;
                    int lastThreeDigit = 1;
                    String seatNumber = String.valueOf(curYear) + String.valueOf(acCoachNumber) + String.valueOf(lastThreeDigit);
                    long finalSeatNumber = Long.parseLong(seatNumber);
                    Passengers passengers = new Passengers();
                    passengers.setUserId(ticketRequest.getPassengerId());
                    Ticket ticket = new Ticket();
                    Ticket mappingTicket = ticketHelper.setTicketForBooking(ticket, ticketRequest, foundTrainFromDb, foundPassengerFromDb, finalSeatNumber, passengers);
                    Ticket savedTicket = ticketRepo.save(mappingTicket);
                    return ticketHelper.setTicketResponse(ticketResponse,passengers,finalSeatNumber,foundTrainFromDb,foundPassengerFromDb,savedTicket);
                }
                else if((seatsLeft > 0) && (foundTrainFromDb.getCoachType().equals("AC")) && (seatsLeft < foundTrainFromDb.getTotalSeat())){
                    int curYear = Integer.parseInt(ticketRequest.getTrainNumber());
                    int acCoachNumber = 75;
                    int lastThreeDigit = ticketHelper.findLeftSeat(ticketRequest.getTrainNumber()) + 1;
                    String seatNumber = String.valueOf(curYear) + String.valueOf(acCoachNumber) + String.valueOf(lastThreeDigit);
                    long finalSeatNumber = Long.parseLong(seatNumber);
                    Passengers passengers = new Passengers();
                    passengers.setUserId(ticketRequest.getPassengerId());
                    Ticket ticket = new Ticket();
                    Ticket mappingTicket = ticketHelper.setTicketForBooking(ticket, ticketRequest, foundTrainFromDb, foundPassengerFromDb, finalSeatNumber, passengers);
                    Ticket savedTicket = ticketRepo.save(mappingTicket);
                    return ticketHelper.setTicketResponse(ticketResponse,passengers,finalSeatNumber,foundTrainFromDb,foundPassengerFromDb,savedTicket);
                }
            }

        }
        throw new RuntimeException("multiple ticket not allowed for individual passenger!!");
    }

    @Override
    public TicketResponse viewTicket(String ticketNumber) {
        Ticket foundBookedTicket = ticketRepo.viewBookedTicket(ticketNumber);
        TicketResponse ticketResponse = new TicketResponse();

        Train foundSavedTrain = trainRepo.findBytrainNumber(foundBookedTicket.getTrainNumber());
        Passengers foundSavedPassenger = passengersRepo.findByuserId(foundBookedTicket.getPassengerId());

        ticketResponse.setTicketNumber(foundBookedTicket.getTicketNumber());
        ticketResponse.setTrainNumber(foundBookedTicket.getTrainNumber());
        ticketResponse.setTrainName(foundSavedTrain.getTrainName());
        ticketResponse.setSeatNumber(foundBookedTicket.getSeatNumber());
        ticketResponse.setPassengerId(foundBookedTicket.getPassengerId());
        ticketResponse.setPassengerName(foundSavedPassenger.getName());
        ticketResponse.setPassengerPhone(foundSavedPassenger.getPhone());
        ticketResponse.setSourceStation(foundBookedTicket.getSourceStation());
        ticketResponse.setDestinationStation(foundBookedTicket.getDestinationStation());
        ticketResponse.setCoachType(foundSavedTrain.getCoachType());
        ticketResponse.setFare(foundSavedTrain.getFare());
        ticketResponse.setBookingDateAndTime(foundBookedTicket.getBookingTime());
        return ticketResponse;
    }

    @Override
    public List<Ticket> listAllBooking(String trainNumber) {
        return ticketRepo.listAllBooking(trainNumber);
    }
}
