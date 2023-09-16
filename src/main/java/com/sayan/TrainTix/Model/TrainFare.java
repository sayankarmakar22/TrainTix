package com.sayan.TrainTix.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "TrainFare")
public class TrainFare {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int serialNumber;
    @Column(length = 5)
    private String coachType;
    private int fare;

    @ManyToOne
    @JoinColumn(name = "trainNumber")
    private Train train;
}
