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
@Table(name = "Admin")
public class Admin {
    @Id
    private String adminId;

    @Column(length = 100)
    private String name;

    @Column(length = 12)
    private String phone;

    @Column(length = 50)
    private String email;

    @Column(length = 10)
    private String role;

    @Column(length = 30)
    private String username;

    @Column(length = 1500)
    private String password;
}
