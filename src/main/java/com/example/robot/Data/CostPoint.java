package com.example.robot.Data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Embeddable
public class CostPoint extends Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private int cost;

    public CostPoint(int x, int y, short view, int cost) {
        super(x, y, view);
        this.cost = cost;
    }

    public CostPoint(CostPoint costPointData) {
        super(costPointData.getX(), costPointData.getY(), costPointData.getView());
        this.cost = costPointData.getCost();
    }
    public CostPoint() { super(); }
}
