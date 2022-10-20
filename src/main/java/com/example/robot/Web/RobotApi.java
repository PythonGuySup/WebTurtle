package com.example.robot.Web;


import com.example.robot.Data.Coordinates;
import com.example.robot.Data.MapData;
import com.example.robot.Data.Mappers.WalkerMapper;
import com.example.robot.Data.Repositiories.MapDataRepository;
import com.example.robot.Data.Repositiories.WalkerDataRepository;
import com.example.robot.Data.WalkerCommands;
import com.example.robot.Data.WalkerDTO;
import com.example.robot.Logic.Walker;
import com.example.robot.Manager.MapSessionImp;
import com.example.robot.Manager.WalkerSessionImp;
import com.example.robot.Services.CreateWalkerServiceImp;
import com.example.robot.Services.WalkerServiceExpImp;
import com.example.robot.Services.WalkerServiceImp;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/robots")
@AllArgsConstructor
@Slf4j
public class RobotApi {

    private WalkerServiceImp service;

    private CreateWalkerServiceImp createWalkerServiceImp;

    private WalkerServiceExpImp walkerServiceExpImp;

    private WalkerMapper walkerMapper;

    private MapDataRepository mapDataRepository;

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public WalkerDTO createWalker(@RequestBody Coordinates coords) {
        Walker robot = createWalkerServiceImp.create(coords);
        return walkerMapper.toWalkerDTO(robot);
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

    @PatchMapping(path = "/service", consumes = "application/json") // In this case we're creating all entities even they already exist.
    public void walk(@RequestBody Coordinates coords) {
        service.run(coords);
    }



}
