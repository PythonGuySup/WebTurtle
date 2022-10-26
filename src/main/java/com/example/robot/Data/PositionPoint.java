package com.example.robot.Data;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Embeddable
public final class PositionPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    private int x;
    private int y;
    private short view;

    @OneToOne
    RobotData robotData;

    public PositionPoint(int x, int y, short view) {
        this.x = x;
        this.y = y;
        this.view = view;
    }

    public PositionPoint(int x, int y, short view, RobotData robotData)  {
        this.x = x;
        this.y = y;
        this.view = view;
        this.robotData = null; //FIXME!
    }

    public PositionPoint(PositionPoint positionPointData) {
        this.x = positionPointData.getX();
        this.y = positionPointData.getY();
        this.view = positionPointData.getView();
    }
    public PositionPoint() {
    }

    //@Override
    //public String toString() { return String.format("(%d, %d, %d) degrees", x, y, view); }
    public void offset(int ox, int oy) { this.setX(this.getX() + ox);  this.setY(this.getY() + oy); }

    public void offset(int ox, int oy, short oview) { this.setX(this.getX() + ox);  this.setY(this.getY() + oy); this.setView((short) (this.getView() + oview));  }

    public void offsetY(int oy) { this.setY(this.getY() + oy); }

    public void offsetX(int ox) { this.setX(this.getX() + ox); }

    public void offsetView( int oview ) { this.setView((short) (this.getView() + oview)); }

}
