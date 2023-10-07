package com.example.robot.Logic;

import com.example.robot.Data.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;

@Slf4j

@Entity
public class Walker extends RobotData<WalkerCommands> implements Robot<WalkerCommands>{

    public void giveCommand(WalkerCommands command, int repeat, int wait_ms) {
        if (log.isDebugEnabled()) {
            log.debug("Walker is parsing a command");
        }

        log.info(((this.getPosition() == null) ? "ERROR: Point IS NULL" : "Parsing the command...\t" + this.getPosition())); // FIXME! DELETE THIS!

        switch (command) {
            case GO: this.getPath().add(new PositionPoint(this.getPosition())); moveToward(this.getPosition().getView()); break;
            case LEFT: this.getPath().add(new PositionPoint(this.getPosition())); this.getPosition().offsetView(90); break;
            case SEMICIRCLE: this.getPath().add(new PositionPoint(this.getPosition())); this.getPosition().offsetView(180); break;
            case SKIP: break;
            default: log.info("Command {} wasn't understand", command); break;
        }
    }

    private void moveToward(short view) {

        if (log.isDebugEnabled()) {
            log.debug("Walker moved");
        }

        switch (view) {
            case 0 -> {
                this.getPosition().offsetY(1);
                break;
            }
            case 90 -> {
                this.getPosition().offsetX(1);
                break;
            }
            case 180 -> {
                this.getPosition().offsetY(-1);
                break;
            }
            case 270 -> {
                this.getPosition().offsetX(-1);
                break;
            }
            case 360 -> {
                this.getPosition().offsetY(1);
                break;
            }
            default -> this.getPosition().offsetY(1);
        }

    }

    @Override
    public RobotTypes getType() {
        return RobotTypes.WALKER;
    }


}
