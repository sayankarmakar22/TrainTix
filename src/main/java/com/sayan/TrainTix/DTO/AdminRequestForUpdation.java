package com.sayan.TrainTix.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdminRequestForUpdation {
    private String admin_id;
    private String phone;
    private String email;
}
