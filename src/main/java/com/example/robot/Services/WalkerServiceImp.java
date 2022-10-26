package com.example.robot.Services;

import com.example.robot.Data.*;
import com.example.robot.Data.Mappers.WalkerMapper;
import com.example.robot.Data.Repositiories.PositionPointRepository;
import com.example.robot.Data.Repositiories.WalkerDataRepository;
import com.example.robot.Logic.PathFinding;
import com.example.robot.Logic.PathFindingImp;

import com.example.robot.Logic.Walker;
import com.example.robot.Manager.MapSessionImp;
import com.example.robot.Manager.WalkerSession;
import com.example.robot.Manager.WalkerSessionImp;
import com.example.robot.utils.MapMaker;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@RequiredArgsConstructor
@Component
public final class WalkerServiceImp implements RobotService<WalkerCommands> { // immutable

    private Coordinates coords;

    @NonNull
    private WalkerMapper walkerMapper;

    @NonNull
    private WalkerSessionImp walkerSessionImp;

    @NonNull
    private MapSessionImp mapSessionImp;

    @NonNull
    private WalkerDataRepository walkerDataRepository;


    @Override
    public WalkerDTO initialize(Coordinates coords) {
        Walker robot = this.create(coords);
        return walkerMapper.toWalkerDTO(robot);

    }


    public Walker create(Coordinates coords) {

        Walker walker = new Walker();
        MapData map = new MapData(MapMaker.getMap(coords), coords.getX1() + 1, coords.getY1() + 1);
        map.getRobots().add(walker);
        walker.setPosition(coords);

        walker.setMapData(map);

        mapSessionImp.save(map);
        walkerSessionImp.save(walker);
        log.info("Set robot with id: {}", walker.getId());
        log.info(walker.getPosition().toString());

        return walker;
    }

    @Override
    public WalkerDTO implementCommand(long id, String command) {
        Walker walker = walkerDataRepository.findById(id).get();
        walker.giveCommand(WalkerCommands.valueOf(command), 0 ,0);
        //FIX THIS YOU SHOULDN'T FLUSH BY YOUR SELF
        walkerSessionImp.save(walker);
        log.info("Robot {}: path {}", walker.getId(), walker.getPath().toString());
        log.info(walker.getPosition().toString());
        return walkerMapper.toWalkerDTO(walker);
    }

    @AllArgsConstructor
    public class AchievementGoal {

        private Walker robot;

        public void achieve(Coordinates goal) {

            PathFinding pathFinding = new PathFindingImp();

            log.info("Path to the goal:{}", pathFinding.FindPath(robot.getMapData().getSizeX(), robot.getMapData().getSizeY(), goal));
            this.goToGoal(pathFinding, goal, robot);
            log.info(robot.getPosition().toString());


        }

        private void goToGoal(PathFinding pathFinding, Coordinates goal, Walker robot) {
            for (LinkedPoint point : (pathFinding.FindPath(robot.getMapData().getSizeX(), robot.getMapData().getSizeY(), goal))) {
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


}

