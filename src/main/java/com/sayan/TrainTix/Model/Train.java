package com.sayan.TrainTix.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Train")
public class Train {
    @Id
    private String trainNumber;

    @Column(length = 50)
    private String trainName;

    private int totalSeat;

    private int totalCoach;

    @Column(length = 50)
    private String sourceStation;

    @Column(length = 50)
    private String destinationStation;
}
