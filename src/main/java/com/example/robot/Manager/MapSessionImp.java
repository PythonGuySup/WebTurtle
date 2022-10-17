package com.example.robot.Manager;

import com.example.robot.Data.MapData;
import com.example.robot.Data.PositionPointData;
import com.example.robot.Data.Repositiories.MapDataRepository;
import com.example.robot.Data.Repositiories.PositionPointDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MapSessionImp implements MapSession{

    @Autowired
    private MapDataRepository mapDataRepository;

    @Autowired
    private PositionPointDataRepository positionPointDataRepository;
    public void save(MapData mapData) {
        positionPointDataRepository.saveAll(mapData.getMap());
        mapDataRepository.save(mapData);
        log.info("Map saved");
    }
}
