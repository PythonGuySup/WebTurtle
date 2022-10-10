package com.example.robot.Logic;

import com.example.robot.Data.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j

@Entity
public class Walker extends RobotData<WalkerCommands> implements Robot<WalkerCommands>{

    public void giveCommand(WalkerCommands command, int repeat, int wait_ms) {
        if (log.isDebugEnabled()) {
            log.debug("Walker is parsing command");
        }

        log.info(((this.getPositionPoint() == null) ? "ERROR: Point IS NULL" : "Parsing the command...\t" + this.getPositionPoint())); // FIXME! DELETE THIS!

        switch (command) {
            case GO: this.setPosition(moveToward(this.getPosition().getView())); break;
            case LEFT: this.setPosition(this.getPosition().offsetView(90)); break;
            case SEMICIRCLE: this.setPosition(this.getPosition().offsetView(180)); break;
            case SKIP: break;
            default: log.info("Command {} wasn't understand", command); break;
        }
    }

    private PositionPoint moveToward(short view) {

        if (log.isDebugEnabled()) {
            log.debug("Walker moved");
        }

        return switch (view) {
            case 0 -> this.getPosition().offsetY(1);
            case 90 -> this.getPosition().offsetX(1);
            case 180 -> this.getPosition().offsetY(-1);
            case 270 -> this.getPosition().offsetX(-1);
            case 360 -> this.getPosition().offsetY(1);
            default -> this.getPosition().offsetY(1);
        };

    }

    @Override
    public RobotTypes getType() {
        return RobotTypes.WALKER;
    }

    public void getReadyToSave() {
        try {
            this.flushPathPull();
        } catch (Exception exception) {
            log.error("ERROR WHILE: Flush  PathPull to Path column : ", exception);

        }

    }
    private void flushPathPull() {
       List<PositionPoint> path = this.getPathByPoint(this.getPositionPoint(), new ArrayList<PositionPoint>());
       log.info("flushPathPull: path is {}", path);

       for (PositionPoint point : path) {
           if (point != null) {
               PositionPointData data = new PositionPointData();
               data.setX(point.getX());
               data.setY(point.getY());
               data.setView(point.getView());
               this.getPath().add(data);
           }
       }
    }

    private List<PositionPoint> getPathByPoint(PositionPoint point, List<PositionPoint> path) {

        if (point == null || point.getPrevious() == null) {
            log.warn("HERE: {}", point);
            path.add(point);
            Collections.reverse(path);
            return path;
        } else {
            path.add(point);
            return this.getPathByPoint(point.getPrevious(), path);
        }
    }

}
