package com.example.robot.Data.Repositiories;

import com.example.robot.Data.CostPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostPointRepository extends CrudRepository<CostPoint, Long> {
}
