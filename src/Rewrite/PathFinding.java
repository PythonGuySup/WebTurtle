package com.example.robot.Services.Rewrite;

import com.example.robot.Coordinates;
import com.example.robot.Services.Data.Point;

public interface PathFinding {
    String[] gridPathFinding(Coordinates coords);
    Point[] getNeighbours(Point[][] grid, Point currentPoint);
}
