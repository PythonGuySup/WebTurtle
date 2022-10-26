package com.example.robot.Services;


import com.example.robot.Data.Coordinates;
import com.example.robot.Data.WalkerDTO;

public interface RobotService<CommandType> {
    WalkerDTO initialize(Coordinates coords);

    WalkerDTO implementCommand(long id, String command);


}
