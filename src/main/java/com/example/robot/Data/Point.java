package com.example.robot.Data;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Embeddable
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    private int x;
    private int y;
    private short view;


    public Point(int x, int y, short view) {
        this.x = x;
        this.y = y;
        this.view = view;
    }

    public Point(Point pointData) {
        this.x = pointData.getX();
        this.y = pointData.getY();
        this.view = pointData.getView();
    }
    public Point() {}
}
