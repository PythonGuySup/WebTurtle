package com.example.robot.Data.Repositiories;

import com.example.robot.Data.MapData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MapDataRepository extends CrudRepository<MapData, Long> {
}
