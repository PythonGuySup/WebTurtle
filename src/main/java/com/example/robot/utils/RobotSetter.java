package com.example.robot.utils;

import com.example.robot.Data.Coordinates;
import com.example.robot.Data.RobotData;

public class RobotSetter {
    public static void setRobot(RobotData robot, Coordinates coords) {
        robot.setPosition(coords);
    }
}
