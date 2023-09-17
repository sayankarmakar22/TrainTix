package com.sayan.TrainTix.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterPassengersRequest {
    private String useId;

    private String phone;

    private String email;

    private String address;
}
