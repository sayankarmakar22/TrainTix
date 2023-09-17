package com.sayan.TrainTix.Services.Implementations;

import com.sayan.TrainTix.DTO.AdminRequestForUpdation;
import com.sayan.TrainTix.DTO.AdminResponse;
import com.sayan.TrainTix.DTO.RegisterPassengersResponse;
import com.sayan.TrainTix.Helper.AdminBasicHelper;
import com.sayan.TrainTix.Model.Admin;
import com.sayan.TrainTix.Model.Passengers;
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
        if(adminRepo.existsByadminId(adminRequestForUpdation.getAdmin_id())){
            Admin foundSavedAdmin = adminRepo.findByadminId(adminRequestForUpdation.getAdmin_id());
            //update the passengers
            foundSavedAdmin.setPhone(adminRequestForUpdation.getPhone());
            foundSavedAdmin.setEmail(adminRequestForUpdation.getEmail());
            Admin savedUpdatedAdmin = adminRepo.save(foundSavedAdmin);
            AdminResponse adminResponse = new AdminResponse();
            return adminBasicHelper.setAdminResponse(adminResponse,savedUpdatedAdmin);
        }
        throw new RuntimeException("admin not valid!");
    }

    @Override
    public AdminResponse viewAdmin(String adminId) {
        if(adminRepo.existsByadminId(adminId)){
            Admin foundAdminFromDb = adminRepo.findByadminId(adminId);
            AdminResponse adminResponse = new AdminResponse();
            return adminBasicHelper.setAdminResponse(adminResponse,foundAdminFromDb);
        }
        throw new RuntimeException("admin not found!!");
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
