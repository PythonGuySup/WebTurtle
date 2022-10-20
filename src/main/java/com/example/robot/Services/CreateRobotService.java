package com.example.robot.Services;

import com.example.robot.Data.Coordinates;
import com.example.robot.Logic.Walker;

public interface CreateRobotService {
    Walker create(Coordinates coords);
}
