package com.example.robot.Data;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Embeddable
public final class PositionPointData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    private int x;
    private int y;
    private short view;

}
