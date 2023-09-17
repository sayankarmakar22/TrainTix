package com.sayan.TrainTix.Helper;

import com.sayan.TrainTix.DTO.AdminResponse;
import com.sayan.TrainTix.DTO.RegisterPassengersResponse;
import com.sayan.TrainTix.Model.Admin;
import com.sayan.TrainTix.Model.Passengers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Component
public class AdminBasicHelper {

    public AdminResponse setAdminResponse(AdminResponse adminResponse, Admin admin){
        adminResponse.setName(admin.getName());
        adminResponse.setPhone(admin.getPhone());
        adminResponse.setEmail(admin.getEmail());
        adminResponse.setAdminId(admin.getAdminId());
        adminResponse.setUsername(admin.getUsername());
        return adminResponse;
    }
}
