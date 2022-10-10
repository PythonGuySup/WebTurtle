package com.example.robot.Logic;

import com.example.robot.Data.*;
import com.example.robot.Data.Repositiories.PositionPointDataRepository;

public interface Robot<CommandType> {
     void giveCommand(CommandType command, int repeat, int wait_ms);
     void getReadyToSave();
}
