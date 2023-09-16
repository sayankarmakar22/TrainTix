package com.sayan.TrainTix.Repository;

import com.sayan.TrainTix.Model.SeatAllocate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatAllocateRepo extends JpaRepository<SeatAllocate,Integer> {
}
