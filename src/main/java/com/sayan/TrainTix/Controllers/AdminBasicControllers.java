package com.sayan.TrainTix.Controllers;

import com.sayan.TrainTix.DTO.AdminRequestForUpdation;
import com.sayan.TrainTix.DTO.AdminResponse;
import com.sayan.TrainTix.Model.Admin;
import com.sayan.TrainTix.Services.Implementations.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TrainTix/Admin")
public class AdminBasicControllers {
    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("/register-admin")
    public ResponseEntity<AdminResponse> registerAdmin(@RequestBody Admin admin){
        return new ResponseEntity<>(adminService.registerAdmin(admin), HttpStatus.CREATED);

    }
    @GetMapping("/view-admin")
    public ResponseEntity<AdminResponse> getAdminDetails(@RequestParam String adminID){
        return new ResponseEntity<>(adminService.viewAdmin(adminID), HttpStatus.FOUND);
    }
    @PostMapping("/update-admin")
    public ResponseEntity<AdminResponse> updateAdminDetails(@RequestBody AdminRequestForUpdation adminRequestForUpdation){
        return new ResponseEntity<>(adminService.updateAdmin(adminRequestForUpdation), HttpStatus.ACCEPTED);

    }
    @DeleteMapping("/delete-admin")
    public ResponseEntity<String> delete(@RequestParam String adminId){
        return new ResponseEntity<>(adminService.deleteAdmin(adminId), HttpStatus.CREATED);

    }
}
