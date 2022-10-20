package com.example.robot.Services;

import com.example.robot.Data.PositionPoint;
import com.example.robot.Data.PositionPointData;
import com.example.robot.Data.Repositiories.WalkerDataRepository;
import com.example.robot.Data.WalkerCommands;
import com.example.robot.Data.WalkerDTO;
import com.example.robot.Logic.Robot;
import com.example.robot.Logic.Walker;
import com.example.robot.Manager.WalkerSessionImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WalkerServiceExpImp implements RobotServiceExp {
    @Autowired
    private WalkerDataRepository walkerDataRepository;

    @Autowired
    private WalkerSessionImp walkerSessionImp;

    public Walker run(long id, String command) {
       Walker walker = walkerDataRepository.findById(id).get();
       walker.giveCommand(WalkerCommands.valueOf(command), 0 ,0);
       //FIX THIS YOU SHOULDN'T FLUSH BY YOUR SELF
       walkerSessionImp.save(walker);
       log.info("Robot {}: path {}", walker.getId(), walker.getPath().toString());
       log.info(walker.getPosition().toString());
       return walker;
    }


}
