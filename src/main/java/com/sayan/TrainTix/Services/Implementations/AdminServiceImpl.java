package com.sayan.TrainTix.Services.Implementations;

import com.sayan.TrainTix.DTO.AdminRequestForUpdation;
import com.sayan.TrainTix.DTO.AdminResponse;
import com.sayan.TrainTix.Helper.AdminBasicHelper;
import com.sayan.TrainTix.Model.Admin;
import com.sayan.TrainTix.Repository.AdminRepo;
import com.sayan.TrainTix.Services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminServiceImpl implements AdminServices {
    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private AdminBasicHelper adminBasicHelper;
    @Override
    public AdminResponse registerAdmin(Admin admin) {
        if(!adminRepo.existsByadminId(admin.getAdminId())){
            Admin savedAdmin = adminRepo.save(admin);
            AdminResponse adminResponse = new AdminResponse();
            return adminBasicHelper.setAdminResponse(adminResponse,savedAdmin);
        }
        throw new RuntimeException("admin id already exists");
    }

    @Override
    public AdminResponse updateAdmin(AdminRequestForUpdation adminRequestForUpdation) {
        return null;
    }

    @Override
    public AdminResponse viewAdmin(String adminId) {
        return null;
    }

    @Override
    public String deleteAdmin(String adminId) {
        String response = null;
        try{
            if(adminRepo.existsByadminId(adminId)){
                adminRepo.deleteById(adminId);
                response = adminId + " has been deleted!!";
            }
            else{
                response = "you have tried to delete an non-existing account!!";
            }
        }
        catch (RuntimeException runtimeException){
            runtimeException.printStackTrace();
        }
        return response;
    }
}
