package com.example.robot.Data;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "robots")
@Entity
public class MapData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ElementCollection
    @CollectionTable
    private Collection<CostPoint> map; // FIXME THIS ISN'T IMMUTABLE MAP

    private int sizeX;
    private int sizeY;

    @OneToMany(cascade = CascadeType.ALL)
    List<RobotData> robots = new ArrayList<>();


    public MapData(Collection<CostPoint> map, int sizeX, int sizeY) {
        this.map = map;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
}
