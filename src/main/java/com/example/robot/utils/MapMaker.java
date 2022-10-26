package com.example.robot.utils;

import com.example.robot.Data.Coordinates;
import com.example.robot.Data.CostPoint;
import com.example.robot.Data.PositionPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapMaker {

    public static List<CostPoint> getMap(Coordinates coords) {
        List<CostPoint> map = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i <= coords.getX1() + 1; i++) {
            for (int j = 0; j <= coords.getY1() + 1; j++) {
                if ( random.nextBoolean() && random.nextBoolean()) {
                    CostPoint data = new CostPoint(i, j, (short) 0, 1);
                    map.add(data);
                }

            }

        }
        return map;
    }

}
