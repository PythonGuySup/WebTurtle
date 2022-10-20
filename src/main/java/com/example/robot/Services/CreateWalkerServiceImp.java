package com.example.robot.Services;

import com.example.robot.Data.*;
import com.example.robot.Data.Repositiories.PositionPointDataRepository;
import com.example.robot.Logic.Walker;
import com.example.robot.Manager.MapSessionImp;
import com.example.robot.Manager.WalkerSessionImp;
import com.example.robot.utils.MapMaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreateWalkerServiceImp implements CreateRobotService {
    @Autowired
    private WalkerSessionImp walkerSessionImp;
    @Autowired
    private MapSessionImp mapSessionImp;



    @Autowired
    private PositionPointDataRepository positionDataRepository;

    public Walker create(Coordinates coords) {

        Walker walker = new Walker();
        MapData map = new MapData(MapMaker.getMap(coords), coords.getX1() + 1, coords.getY1() + 1);
        map.getRobots().add(walker);
        walker.setPosition(coords);

        positionDataRepository.save(walker.getPosition());

        walker.setMapData(map);

        mapSessionImp.save(map);
        //walker.getReadyToSave();
        walkerSessionImp.save(walker);
        log.info("Set robot with id: {}", walker.getId());
        log.info(walker.getPosition().toString());

        return walker;
    }
}
