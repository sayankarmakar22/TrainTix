package com.sayan.TrainTix.Repository;

import com.sayan.TrainTix.Model.Passengers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengersRepo extends JpaRepository<Passengers,String> {
}
