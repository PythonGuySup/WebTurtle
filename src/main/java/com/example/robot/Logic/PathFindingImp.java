package com.example.robot.Logic;

import com.example.robot.Data.Coordinates;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class PathFindingImp implements PathFinding {


    public boolean IsWalkable(int[][] map, LinkedPoint point) {
        if (point.getY() < 0 || point.getY() > map.length - 1) return false;
        if (point.getX() < 0 || point.getX() > map[0].length - 1) return false;
        return map[point.getY()][point.getX()] == 0;
    }

    public List<LinkedPoint> FindNeighbors(int[][] map, LinkedPoint point) {
        List<LinkedPoint> neighbors = new ArrayList<>();
        LinkedPoint up = point.offset(0,  1);
        LinkedPoint down = point.offset(0,  -1);
        LinkedPoint left = point.offset(-1, 0);
        LinkedPoint right = point.offset(1, 0);
        if (IsWalkable(map, up)) neighbors.add(up);
        if (IsWalkable(map, down)) neighbors.add(down);
        if (IsWalkable(map, left)) neighbors.add(left);
        if (IsWalkable(map, right)) neighbors.add(right);
        return neighbors;
    }
    public List<LinkedPoint> FindPath(int sizeX, int sizeY, Coordinates coords) {

        LinkedPoint start = new LinkedPoint(coords.getX0(), coords.getY0(), (short) 0, null);
        LinkedPoint end = new LinkedPoint(coords.getX1(), coords.getY1(), (short) 0, null);

        int[][] map = new int[sizeY + 1][sizeX + 1];

        boolean finished = false;
        List<LinkedPoint> used = new ArrayList<>();

        used.add(start);
        while (!finished) {
            List<LinkedPoint> newOpen = new ArrayList<>();
            for(int i = 0; i < used.size(); ++i){
                LinkedPoint point = used.get(i);
                for (LinkedPoint neighbor : FindNeighbors(map, point)) {
                    if (!used.contains(neighbor) && !newOpen.contains(neighbor)) {
                        newOpen.add(neighbor);
                    }
                }
            }

            for(LinkedPoint point : newOpen) {
                used.add(point);
                if (end.equals(point)) {
                    finished = true;
                    break;
                }
            }

            if (!finished && newOpen.isEmpty())
                return null;
        }

        List<LinkedPoint> path = new ArrayList<>();
        LinkedPoint point = used.get(used.size() - 1);
        while(point.getPrevious() != null) {
            path.add(0, point);
            point = point.getPrevious();
        }
        return path;
    }

}
