package com.example.robot.Logic;

import lombok.*;

import java.util.Objects;


@Getter
@RequiredArgsConstructor

public final class LinkedPoint {

    private final int x;
    private final int y;

    private final short view; //0-360

    private final LinkedPoint previous;

    @Override
    public String toString() { return String.format("(%d, %d, %d) degrees", x, y, view); }

    @Override
    public boolean equals(Object o) {
        LinkedPoint linkedPoint = (LinkedPoint) o;

        return x == linkedPoint.getX() && y == linkedPoint.getY();
    }

    @Override
    public int hashCode() { return Objects.hash(x, y); }

    public LinkedPoint offset(int ox, int oy) { return new LinkedPoint(this.getX() + ox, this.getY() + oy, this.getView(), this); }

    public LinkedPoint offset(int ox, int oy, short changeView) { return new LinkedPoint(this.getX() + ox, this.getY() + oy, (short) (this.getView() + changeView), this );  }

    public LinkedPoint offsetY(int oy) { return new LinkedPoint(this.getX(), this.getY() + oy, this.getView(), this); }

    public LinkedPoint offsetX(int ox) {  return new LinkedPoint(this.getX() + ox, this.getY(), this.getView(), this); }

    public LinkedPoint offsetView( int oview ) { return new LinkedPoint(this.getX(), this.getY(), (short) (this.getView() + oview), this.getPrevious() ); }


}
