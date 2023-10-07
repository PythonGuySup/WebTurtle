package com.example.robot.Logic;

public interface Robot<CommandType> {
     void giveCommand(CommandType command, int repeat, int wait_ms);
}
