package com.example.robot.Web;


import com.example.robot.Data.Coordinates;
import com.example.robot.Data.MapData;
import com.example.robot.Data.Mappers.WalkerMapper;
import com.example.robot.Data.Repositiories.MapDataRepository;
import com.example.robot.Data.WalkerDTO;
import com.example.robot.Logic.Walker;
import com.example.robot.Services.WalkerServiceExpImp;
import com.example.robot.Services.WalkerServiceImp;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/robots")
@AllArgsConstructor
@Slf4j
public class RobotApi {

    private WalkerServiceImp service;

    private WalkerServiceExpImp walkerServiceExpImp;

    private WalkerMapper walkerMapper;

    private MapDataRepository mapDataRepository;

    private WalkerServiceImp walkerServiceImp;

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public WalkerDTO createWalker(@RequestBody Coordinates coords) {
        return walkerServiceImp.initialize(coords);
    }

    @PatchMapping(path="{id}/{command}")
    public WalkerDTO giveCommand(@PathVariable long id, @PathVariable String command) {
        Walker robot = walkerServiceExpImp.run(id, command.toUpperCase());
        return walkerMapper.toWalkerDTO(robot);
    }

    @GetMapping(path="map/{id}")
    public MapData giveCommand(@PathVariable long id) { //Need to transform map to DTO!!!
        return mapDataRepository.findById(id).get();
    }


}
