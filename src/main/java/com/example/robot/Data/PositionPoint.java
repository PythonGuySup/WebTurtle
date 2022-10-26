package com.example.robot.Data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;


@Slf4j
@Data
@Entity
@EqualsAndHashCode(exclude = "robotData", callSuper = true)
@ToString(exclude = "robotData", callSuper = true)
@Embeddable
public class PositionPoint extends Point implements Comparable<PositionPoint> {

    @OneToOne
    @JsonBackReference
    RobotData robotData;

    public PositionPoint(int x, int y, short view) {
        super(x, y, view);
    }

    public PositionPoint(int x, int y, short view, RobotData robotData)  {
        super(x, y, view);
        this.robotData = robotData; //FIXME!
    }

    public PositionPoint(PositionPoint positionPointData) {
        super(positionPointData.getX(), positionPointData.getY(), positionPointData.getView());
        this.robotData = positionPointData.getRobotData();
    }
    public PositionPoint() {
        super();
    }

    public void offset(int ox, int oy) { this.setX(this.getX() + ox);  this.setY(this.getY() + oy); }

    public void offset(int ox, int oy, short oview) { this.setX(this.getX() + ox);  this.setY(this.getY() + oy); this.setView((short) (this.getView() + oview));  }

    public void offsetY(int oy) { this.setY(this.getY() + oy); }

    public void offsetX(int ox) { this.setX(this.getX() + ox); }

    public void offsetView( int oview ) { this.setView((short) (this.getView() + oview)); }

    @Override
    public int compareTo(PositionPoint obj) {
        if ( obj == null) {
            log.error("Compare to NULL {}", obj);
            throw new NullPointerException();
        }
         else if (this.getId() == obj.getId()) {
            return 0;
        }
         else if (this.getId() < obj.getId()) {
            return -1;
        } else if (this.getId() > obj.getId()) {
            return 1;
        }
         log.error("Can't compare {}", obj);
         return -1;
    }
}
