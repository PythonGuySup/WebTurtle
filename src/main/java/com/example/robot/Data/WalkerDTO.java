package com.example.robot.Data;

import lombok.Data;

@Data
public class WalkerDTO {
    private String robotId, mapId, robotType;
    private PositionPoint positionPoint;
}
