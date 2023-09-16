package com.sayan.TrainTix.Repository;

import com.sayan.TrainTix.Model.Train;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepo extends JpaRepository<Train,String> {
}
