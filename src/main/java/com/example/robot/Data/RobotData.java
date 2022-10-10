package com.example.robot.Data;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Robot")
public abstract class RobotData<CommandType>  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ElementCollection
    @CollectionTable(name = "Path")
    private List<PositionPointData> path = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    MapData mapData;
    @Transient
    private PositionPoint positionPoint;




    public void setPosition(Coordinates coords) {
        this.positionPoint = new PositionPoint(coords.getX0(), coords.getY0(), (short) 0, null);
    }

    public void setPosition(Coordinates coords, short view) {
        this.positionPoint = new PositionPoint(coords.getX0(), coords.getY0(), view, null);
    }

    public void setPosition(PositionPoint positionPoint) {
        this.positionPoint = positionPoint;
    }


    public RobotTypes getType() {
        log.warn("getType should be OVERRIDE");
        return null;
    }


    public PositionPoint getPosition() {
        return positionPoint;
    }


}
