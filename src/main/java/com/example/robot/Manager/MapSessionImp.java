package com.example.robot.Manager;

import com.example.robot.Data.MapData;
import com.example.robot.Data.PositionPointData;
import com.example.robot.Data.Repositiories.MapDataRepository;
import com.example.robot.Data.Repositiories.PositionPointDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MapSessionImp implements MapSession{

    private final MapDataRepository mapDataRepository;

    private final PositionPointDataRepository positionPointDataRepository;
    public void save(MapData mapData) {
        positionPointDataRepository.saveAll(mapData.getMap());
        mapDataRepository.save(mapData);
        log.info("Map saved");
    }
}
