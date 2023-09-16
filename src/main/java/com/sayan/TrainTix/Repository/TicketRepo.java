package com.sayan.TrainTix.Repository;

import com.sayan.TrainTix.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,String> {
}
