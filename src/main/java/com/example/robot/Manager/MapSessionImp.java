package com.example.robot.Manager;

import com.example.robot.Data.MapData;
import com.example.robot.Data.Repositiories.CostPointRepository;
import com.example.robot.Data.Repositiories.MapDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MapSessionImp implements MapSession{

    @Autowired
    private MapDataRepository mapDataRepository;

    @Autowired
    private CostPointRepository costPointRepository;
    public void save(MapData mapData) {
        costPointRepository.saveAll(mapData.getMap());
        mapDataRepository.save(mapData);
        log.info("Map saved");
    }
}
