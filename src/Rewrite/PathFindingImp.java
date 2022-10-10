package com.example.robot.Services.Rewrite;

import com.example.robot.Coordinates;
import com.example.robot.Services.Data.Point;
import com.example.robot.Services.InterfacesOfServices.PathFinding;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

@Slf4j
public class PathFindingImp implements PathFinding {

    private Coordinates coords;
    public PathFindingImp(Coordinates coords) {
        this.coords = coords;
    }

    @Override
    public String[] gridPathFinding(Coordinates coords) { // Dijkstrai's algorithm
        int x0 = coords.getX0();
        int y0 = coords.getY0();
        int x1 = coords.getX1();
        int y1 = coords.getY1();

        List<Point> grid = new ArrayList<>();
        Queue<Point> border = new PriorityQueue<>();
        log.info("Success");



        log.info("SSS");

        return new String[] {"ddd"};
    }

    @Override
    public Point[] getNeighbours(Point[][] grid, Point currentPoint) {
        int i = currentPoint.getX();
        int j = currentPoint.getY();

        return new Point[] {grid[i + 1][j], grid[Math.abs(i - 1)][j], grid[i][j+1], grid[i][Math.abs(j-1)]};
    }
}
