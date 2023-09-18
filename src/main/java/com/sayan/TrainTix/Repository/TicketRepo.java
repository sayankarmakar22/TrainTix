package com.sayan.TrainTix.Repository;

import com.sayan.TrainTix.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,String> {
    @Query(value = "select * from ticket where ticket_number =:ticketNumber",nativeQuery = true)
    Ticket viewBookedTicket(String ticketNumber);

    @Query(value = "select * from ticket where train_number =:trainNumber",nativeQuery = true)
    List<Ticket> listAllBooking(String trainNumber);
}
