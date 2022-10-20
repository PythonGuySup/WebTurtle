package com.example.robot.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Embeddable
public final class PositionPointData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    private int x;
    private int y;
    private short view;

    @OneToOne
    RobotData robotData;

    public PositionPoint toPositionPoint() {
        PositionPoint positionPoint = new PositionPoint(this.getX(), this.getY(), this.getView(), null);
        return positionPoint;
    }

    public PositionPointData(int x, int y, short view) {
        this.x = x;
        this.y = y;
        this.view = view;
    }

    public PositionPointData(Long id, int x, int y, short view)  {
        this.id = id;
        this.x = x;
        this.y = y;
        this.view = view;
    }

    public PositionPointData(PositionPointData positionPointData) {
        this.x = positionPointData.getX();
        this.y = positionPointData.getY();
        this.view = positionPointData.getView();
    }
    public PositionPointData () {
    }

    //@Override
    //public String toString() { return String.format("(%d, %d, %d) degrees", x, y, view); }
    public void offset(int ox, int oy) { this.setX(this.getX() + ox);  this.setY(this.getY() + oy); }

    public void offset(int ox, int oy, short oview) { this.setX(this.getX() + ox);  this.setY(this.getY() + oy); this.setView((short) (this.getView() + oview));  }

    public void offsetY(int oy) { this.setY(this.getY() + oy); }

    public void offsetX(int ox) { this.setX(this.getX() + ox); }

    public void offsetView( int oview ) { this.setView((short) (this.getView() + oview)); }

}
