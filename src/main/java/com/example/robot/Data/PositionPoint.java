package com.example.robot.Data;

import lombok.*;

import java.util.Objects;


@Getter
@RequiredArgsConstructor

public final class PositionPoint {

    private final int x;
    private final int y;

    private final short view; //0-360

    private final PositionPoint previous;

    @Override
    public String toString() { return String.format("(%d, %d, %d) degrees", x, y, view); }

    @Override
    public boolean equals(Object o) {
        PositionPoint positionPoint = (PositionPoint) o;

        return x == positionPoint.getX() && y == positionPoint.getY();
    }

    @Override
    public int hashCode() { return Objects.hash(x, y); }

    public PositionPoint offset(int ox, int oy) { return new PositionPoint(this.getX() + ox, this.getY() + oy, this.getView(), this); }

    public PositionPoint offset(int ox, int oy, short changeView) { return new PositionPoint(this.getX() + ox, this.getY() + oy, (short) (this.getView() + changeView), this );  }

    public PositionPoint offsetY(int oy) { return new PositionPoint(this.getX(), this.getY() + oy, this.getView(), this); }

    public PositionPoint offsetX(int ox) {  return new PositionPoint(this.getX() + ox, this.getY(), this.getView(), this); }

    public PositionPoint offsetView( int oview ) { return new PositionPoint(this.getX(), this.getY(), (short) (this.getView() + oview), this.getPrevious() ); }


}
