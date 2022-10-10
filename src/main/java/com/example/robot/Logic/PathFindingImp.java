package com.example.robot.Logic;

import com.example.robot.Data.Coordinates;
import com.example.robot.Data.PositionPoint;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class PathFindingImp implements PathFinding {


    public boolean IsWalkable(int[][] map, PositionPoint point) {
        if (point.getY() < 0 || point.getY() > map.length - 1) return false;
        if (point.getX() < 0 || point.getX() > map[0].length - 1) return false;
        return map[point.getY()][point.getX()] == 0;
    }

    public List<PositionPoint> FindNeighbors(int[][] map, PositionPoint point) {
        List<PositionPoint> neighbors = new ArrayList<>();
        PositionPoint up = point.offset(0,  1);
        PositionPoint down = point.offset(0,  -1);
        PositionPoint left = point.offset(-1, 0);
        PositionPoint right = point.offset(1, 0);
        if (IsWalkable(map, up)) neighbors.add(up);
        if (IsWalkable(map, down)) neighbors.add(down);
        if (IsWalkable(map, left)) neighbors.add(left);
        if (IsWalkable(map, right)) neighbors.add(right);
        return neighbors;
    }
    public List<PositionPoint> FindPath(int sizeX, int sizeY, Coordinates coords) {

        PositionPoint start = new PositionPoint(coords.getX0(), coords.getY0(), (short) 0, null);
        PositionPoint end = new PositionPoint(coords.getX1(), coords.getY1(), (short) 0, null);

        int[][] map = new int[sizeY + 1][sizeX + 1];

        boolean finished = false;
        List<PositionPoint> used = new ArrayList<>();

        used.add(start);
        while (!finished) {
            List<PositionPoint> newOpen = new ArrayList<>();
            for(int i = 0; i < used.size(); ++i){
                PositionPoint point = used.get(i);
                for (PositionPoint neighbor : FindNeighbors(map, point)) {
                    if (!used.contains(neighbor) && !newOpen.contains(neighbor)) {
                        newOpen.add(neighbor);
                    }
                }
            }

            for(PositionPoint point : newOpen) {
                used.add(point);
                if (end.equals(point)) {
                    finished = true;
                    break;
                }
            }

            if (!finished && newOpen.isEmpty())
                return null;
        }

        List<PositionPoint> path = new ArrayList<>();
        PositionPoint point = used.get(used.size() - 1);
        while(point.getPrevious() != null) {
            path.add(0, point);
            point = point.getPrevious();
        }
        return path;
    }

}
