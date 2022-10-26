package com.example.robot.Data.Repositiories;

import com.example.robot.Data.PositionPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionPointRepository extends CrudRepository<PositionPoint, Long> {
}
