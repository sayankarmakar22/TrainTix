package com.sayan.TrainTix.Services;


import com.sayan.TrainTix.DTO.AdminRequestForUpdation;
import com.sayan.TrainTix.DTO.AdminResponse;
import com.sayan.TrainTix.Model.Admin;

public interface AdminServices {
    AdminResponse registerAdmin(Admin admin);
    AdminResponse updateAdmin(AdminRequestForUpdation adminRequestForUpdation);
    AdminResponse viewAdmin(String adminId);
    String deleteAdmin(String adminId);
}
