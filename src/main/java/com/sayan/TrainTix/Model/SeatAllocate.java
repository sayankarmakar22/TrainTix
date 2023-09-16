package com.sayan.TrainTix.Model;

import ch.qos.logback.core.joran.action.ActionUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "SeatAllocate")
public class SeatAllocate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int serialId;

    @Column(length = 15)
    private String status;

    @Column(length = 50)
    private String seatNumber;

    @Column(length = 100)
    private String departureDateTime;

    @ManyToOne
    @JoinColumn(name = "trainNumber")
    private Train train;

    @OneToOne
    @JoinColumn(name = "userId")
    private Passengers passengers;
}
