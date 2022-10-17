package com.example.robot.Services;

import com.example.robot.Data.*;
import com.example.robot.Data.Repositiories.WalkerDataRepository;
import com.example.robot.Logic.PathFinding;
import com.example.robot.Logic.PathFindingImp;

import com.example.robot.Logic.Walker;
import com.example.robot.Manager.MapSessionImp;
import com.example.robot.Manager.WalkerSession;
import com.example.robot.Manager.WalkerSessionImp;
import com.example.robot.utils.MapMaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public final class WalkerServiceImp implements RobotService<WalkerCommands> { // immutable

    private Coordinates coords;

    private MapSessionImp mapSessionImp;
    private WalkerSession session;
    private WalkerDataRepository walkerDataRepository;

    @Autowired
    public WalkerServiceImp(MapSessionImp mapSessionImp, WalkerSessionImp session, WalkerDataRepository walkerDataRepository) {
        this.mapSessionImp = mapSessionImp;
        this.session = session;
        this.walkerDataRepository = walkerDataRepository;
    }

    public void setCoords(Coordinates coords) {
        this.coords = coords;
    }

    @Override
    public void run() {
        MapData map = new MapData(MapMaker.getMap(coords), coords.getX1() + 1, coords.getY1() + 1);

        Walker robot = new Walker();
        robot.setPosition(coords);

        robot.setMapData(map);
        robot.getMapData().getRobots().add(robot);

        PathFinding pathFinding = new PathFindingImp();

        log.info("Path to the goal:{}", pathFinding.FindPath(robot.getMapData().getSizeX(), robot.getMapData().getSizeY(), coords));
        this.goToGoal(pathFinding, coords, robot);
        log.info(robot.getPosition().toString());

        mapSessionImp.save(map);
        robot.getReadyToSave();
        session.save(robot);

        log.warn("GETTING FROM DATABASE IN THE LOCAL MEMORY");
        String str = "\n";
        int counter = 1;
        for (Walker robots : walkerDataRepository.findAll()) {
            log.info("Robot {}: path {}", robots.getId(), robots.getPath().toString());
            for (PositionPointData data : robot.getMapData().getMap()) {
                str += data.toString() + "\t";
                if (counter == map.getSizeX()) {
                    str += "\n";
                    counter = 0;
                }
                counter += 1;
            }
            log.info(str);

        }

    }

    private void goToGoal(PathFinding pathFinding, Coordinates coords, Walker robot) {
        for (PositionPoint point : (pathFinding.FindPath(robot.getMapData().getSizeX(), robot.getMapData().getSizeY(), coords))) {
            log.info("Robot coords: {}", robot.getPositionPoint());

            if (point.getX() > robot.getPosition().getX()) {

                if ((robot.getPosition().getView() % 360) == 90) {
                    robot.giveCommand(WalkerCommands.GO, 0, 0);

                } else {
                    while ((robot.getPosition().getView() % 360) != 90) {
                        log.info("1");
                        if ((short) (robot.getPosition().getView() % 360) < 90)
                            robot.giveCommand(WalkerCommands.LEFT, 0, 0);
                        else robot.giveCommand(WalkerCommands.RIGHT, 0, 0);
                    }
                    robot.giveCommand(WalkerCommands.GO, 0, 0);
                }
            } else if (point.getX() < robot.getPosition().getX()) {
                if ((robot.getPosition().getView() % 360) == 180) {
                    robot.giveCommand(WalkerCommands.GO, 0, 0);

                } else {
                    while ((robot.getPosition().getView() % 360) != 180) {
                        log.info("2");
                        if ((short) (robot.getPosition().getView() % 360) < 180)
                            robot.giveCommand(WalkerCommands.LEFT, 0, 0);
                        else robot.giveCommand(WalkerCommands.RIGHT, 0, 0);
                    }
                    robot.giveCommand(WalkerCommands.GO, 0, 0);
                }
            }

            if (point.getY() > robot.getPosition().getY()) {
                if ((robot.getPosition().getView() % 360) == 0) {
                    robot.giveCommand(WalkerCommands.GO, 0, 0);

                } else {
                    while ((robot.getPosition().getView() % 360) != 0) {
                        log.info("3");
                        robot.giveCommand(WalkerCommands.LEFT, 0, 0);
                    }
                    robot.giveCommand(WalkerCommands.GO, 0, 0);
                }
            } else if (point.getY() < robot.getPosition().getY()){
                if ((robot.getPosition().getView() % 360) == 270) {
                    robot.giveCommand(WalkerCommands.GO, 0, 0);

                } else {
                    while ((robot.getPosition().getView() % 360) != 270) {
                        log.info("4");
                        if ((short) (robot.getPosition().getView() % 360) < 270)
                            robot.giveCommand(WalkerCommands.LEFT, 0, 0);
                        else robot.giveCommand(WalkerCommands.RIGHT, 0, 0);
                    }
                    robot.giveCommand(WalkerCommands.GO, 0, 0);
                }
            }

        }

    }
}

