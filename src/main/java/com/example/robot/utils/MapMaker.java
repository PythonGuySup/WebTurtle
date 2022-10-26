package com.example.robot.utils;

import com.example.robot.Data.Coordinates;
import com.example.robot.Data.PositionPoint;

import java.util.ArrayList;
import java.util.List;

public class MapMaker {

    public static List<PositionPoint> getMap(Coordinates coords) {
        List<PositionPoint> map = new ArrayList<>();
        for (int i = 0; i <= coords.getX1() + 1; i++) {
            for (int j = 0; j <= coords.getY1() + 1; j++) {
                PositionPoint data = new PositionPoint(i, j, (short) 0, null);
                map.add(data);
            }

        }
        return map;
    }

}
