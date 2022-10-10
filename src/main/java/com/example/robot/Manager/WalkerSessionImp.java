package com.example.robot.Manager;

import com.example.robot.Data.Repositiories.PositionPointDataRepository;
import com.example.robot.Data.Repositiories.WalkerDataRepository;
import com.example.robot.Logic.Walker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@RequiredArgsConstructor
@Component
public class WalkerSessionImp implements WalkerSession { //FIXME

    private final WalkerDataRepository walkerDataRepository;

    private final  PositionPointDataRepository positionPointDataRepository;


    @Override
    public void save(Walker robot) {
        if (robot.getPath().isEmpty()) {
            log.error("Missing path! Check robot preparing to save");
        }

        log.warn("{}", robot.getPath());

        positionPointDataRepository.saveAll(robot.getPath());
        walkerDataRepository.save(robot);

    }

}
