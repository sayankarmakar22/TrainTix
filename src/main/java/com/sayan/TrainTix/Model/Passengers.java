package com.sayan.TrainTix.Model;

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
@Table(name = "Passengers")
public class Passengers {
    @Id
    private String userId;

    @Column(length = 100)
    private String name;

    @Column(length = 10)
    private String dob;

    @Column(length = 12)
    private String phone;

    @Column(length = 50)
    private String email;

    @Column(length = 100)
    private String address;

    @Column(length = 10)
    private String role;

    @Column(length = 30)
    private String username;

    @Column(length = 1500)
    private String password;


}
