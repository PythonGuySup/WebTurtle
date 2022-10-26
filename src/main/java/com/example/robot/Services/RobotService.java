package com.example.robot.Services;


import com.example.robot.Data.Coordinates;
import com.example.robot.Data.WalkerDTO;

public interface RobotService<CommandType> {
    WalkerDTO create(Coordinates coords);

    WalkerDTO implementCommand(long id, String command);

    WalkerDTO goToGoal(int x, int y);


}
