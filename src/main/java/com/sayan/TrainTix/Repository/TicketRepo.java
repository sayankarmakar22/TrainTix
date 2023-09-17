package com.sayan.TrainTix.Repository;

import com.sayan.TrainTix.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,String> {
}
