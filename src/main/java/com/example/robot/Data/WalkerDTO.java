package com.example.robot.Data;

import lombok.Data;

import java.util.Collection;
import java.util.Set;

@Data
public class WalkerDTO {
    private String robotId, mapId, robotType;
    private PositionPoint positionPoint;
    private Collection<CostPoint> map;
    private Set<PositionPoint> path;
}
