package com.example.robot.Logic;

import com.example.robot.Data.Coordinates;
import com.example.robot.Data.PositionPoint;


import java.util.List;

public interface PathFinding {
    List<PositionPoint> FindNeighbors(int[][] map, PositionPoint point);
    List<PositionPoint> FindPath(int sizeX, int sizeY, Coordinates coords);
    boolean IsWalkable(int[][] map, PositionPoint point);
}
