package com.example.robot.Services;


import com.example.robot.Data.Coordinates;
import com.example.robot.Data.WalkerDTO;
import com.example.robot.Logic.Walker;

public interface RobotService<CommandType> {
    WalkerDTO create(Coordinates coords);

    WalkerDTO implementCommand(long id, String command);

    WalkerDTO goToGoal(long id, int x, int y);


}
