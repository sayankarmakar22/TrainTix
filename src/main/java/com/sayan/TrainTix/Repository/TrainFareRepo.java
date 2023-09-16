package com.sayan.TrainTix.Repository;

import com.sayan.TrainTix.Model.TrainFare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainFareRepo extends JpaRepository<TrainFare,Integer> {
}
