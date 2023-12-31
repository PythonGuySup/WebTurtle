package com.example.robot.Logic;

import com.example.robot.Data.Coordinates;


import java.util.List;

public interface PathFinding {
    List<LinkedPoint> FindNeighbors(int[][] map, LinkedPoint point);
    List<LinkedPoint> FindPath(int sizeX, int sizeY, Coordinates coords);
    boolean IsWalkable(int[][] map, LinkedPoint point);
}
