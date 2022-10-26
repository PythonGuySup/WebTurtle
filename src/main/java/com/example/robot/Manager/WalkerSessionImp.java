package com.example.robot.Manager;

import com.example.robot.Data.Repositiories.PositionPointRepository;
import com.example.robot.Data.Repositiories.WalkerDataRepository;
import com.example.robot.Logic.Walker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class WalkerSessionImp implements WalkerSession { //FIXME

    @Autowired
    private WalkerDataRepository walkerDataRepository;

    @Autowired
    private PositionPointRepository positionPointRepository;


    @Override
    public void save(Walker robot) {
        if (robot.getPath().isEmpty()) {
            log.error("Missing path! Check robot preparing to save");
        }

        log.warn("{}", robot.getPath());
        //robot.getReadyToSave();
        positionPointRepository.saveAll(robot.getPath());
        positionPointRepository.save(robot.getPosition());
        walkerDataRepository.save(robot);

    }

}
