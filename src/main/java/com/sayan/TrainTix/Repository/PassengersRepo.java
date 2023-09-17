package com.sayan.TrainTix.Repository;

import com.sayan.TrainTix.Model.Passengers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengersRepo extends JpaRepository<Passengers,String> {
    Boolean existsByusername(String username);
    Boolean existsByuserId(String userId);

    Passengers findByusername(String username);
    Passengers findByuserId(String userId);
}
