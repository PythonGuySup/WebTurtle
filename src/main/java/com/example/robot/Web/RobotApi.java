package com.example.robot.Web;


import com.example.robot.Data.Coordinates;
import com.example.robot.Services.WalkerServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/Robot")
@RequiredArgsConstructor
@Slf4j
public class RobotApi {

    @Autowired
    private WalkerServiceImp service;


    @PostMapping(path = "/service", consumes = "application/json")
    public void Walk(@RequestBody Coordinates coords) {
        service.setCoords(coords);
        service.run();


    }

}
