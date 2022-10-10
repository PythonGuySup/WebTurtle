package com.example.robot.Services.Rewrite;


import com.example.robot.Coordinates;

public interface RobotService {
    String[] getPath(Coordinates coords);  // String array contains path from point to point {'turn left', 'go', etc.}
}
