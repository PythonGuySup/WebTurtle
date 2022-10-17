package com.example.robot.Web;

import com.example.robot.Data.Coordinates;


import com.example.robot.Data.Repositiories.MapDataRepository;
import com.example.robot.Data.Repositiories.PositionPointDataRepository;
import com.example.robot.Data.Repositiories.WalkerDataRepository;


import com.example.robot.Data.WalkerCommands;

import com.example.robot.Services.RobotService;
import com.example.robot.Services.WalkerServiceImp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/home")
@SessionAttributes("coords")
public class HomeController {


    @ModelAttribute("coords")
    public Coordinates coords() { return new Coordinates(); }

    @GetMapping
    public String getCoords() {
        return "home";
    }

    @PostMapping
    public String service(@ModelAttribute Coordinates coords) {
        log.info("{}", coords);

        //RobotService<WalkerCommands> service = new WalkerServiceImp();
        //service.setCoords(coords);
       // service.run();
        return "success";

    }
}
