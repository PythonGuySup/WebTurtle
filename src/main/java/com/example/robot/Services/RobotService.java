package com.example.robot.Services;


import com.example.robot.Data.Coordinates;

public interface RobotService<CommandType> {
    void run();
    void setCoords(Coordinates coords);
}
