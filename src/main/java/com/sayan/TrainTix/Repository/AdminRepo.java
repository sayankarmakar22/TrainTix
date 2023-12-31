package com.sayan.TrainTix.Repository;

import com.sayan.TrainTix.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,String> {
    Boolean existsByadminId(String adminId);
    Admin findByadminId(String adminId);
}
