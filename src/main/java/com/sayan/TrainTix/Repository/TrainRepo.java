package com.sayan.TrainTix.Repository;

import com.sayan.TrainTix.Model.Train;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepo extends JpaRepository<Train,String> {
    Boolean existsBytrainNumber(String trainNumber);
    Train findBytrainNumber(String number);

    @Query(value = "select count(seat_number) from ticket where train_number =:trainNumber",nativeQuery = true)
    int getLeftSeat(String trainNumber);

    @Query(value = "select max(seat_number) from ticket where train_number =:trainNumber",nativeQuery = true)
    int getLastSeatBook(String trainNumber);
}
