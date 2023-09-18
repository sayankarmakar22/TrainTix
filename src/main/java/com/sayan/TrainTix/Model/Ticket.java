package com.sayan.TrainTix.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    private String ticketNumber;

    private String trainNumber;

    @Column(length = 100)
    private String sourceStation;

    @Column(length = 100)
    private String destinationStation;

    private int fare;

    @Column(length = 5)
    private String coachType;

    private Date bookingTime;

    private long seatNumber;

    private String passengerId;

}
