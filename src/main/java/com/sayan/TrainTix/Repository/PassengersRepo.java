package com.sayan.TrainTix.Repository;

import com.sayan.TrainTix.DTO.RegisterPassengersResponse;
import com.sayan.TrainTix.Model.Passengers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PassengersRepo extends JpaRepository<Passengers,String> {
    Boolean existsByusername(String username);
    Boolean existsByuserId(String userId);

    Passengers findByusername(String username);
    Passengers findByuserId(String userId);

    @Query(value = "select user_id,address,dob,name,phone,username from passengers",nativeQuery = true)
    List<Map<String,Object>> getAllPassengers();
}
