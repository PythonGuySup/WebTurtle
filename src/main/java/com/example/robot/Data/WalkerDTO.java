package com.example.robot.Data;

import lombok.Data;

import java.util.Collection;

@Data
public class WalkerDTO {
    private String robotId, mapId, robotType;
    private PositionPoint positionPoint;
    private Collection<PositionPoint> map;
}
