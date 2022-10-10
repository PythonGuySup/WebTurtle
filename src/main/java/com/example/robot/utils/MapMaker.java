package com.example.robot.utils;

import com.example.robot.Data.Coordinates;
import com.example.robot.Data.PositionPoint;
import com.example.robot.Data.PositionPointData;

import java.util.ArrayList;
import java.util.List;

public class MapMaker {

    public static List<PositionPointData> getMap(Coordinates coords) {
        List<PositionPointData> map = new ArrayList<>();
        for (int i = 0; i <= coords.getX1() + 1; i++) {
            for (int j = 0; j <= coords.getY1() + 1; j++) {
                PositionPointData data = new PositionPointData();
                data.setX(i);
                data.setY(j);
                map.add(new PositionPointData());
            }

        }
        return map;
    }

}
