package com.example.robot.Data.Repositiories;

import com.example.robot.Data.PositionPointData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionPointDataRepository extends CrudRepository<PositionPointData, Long> {
}
