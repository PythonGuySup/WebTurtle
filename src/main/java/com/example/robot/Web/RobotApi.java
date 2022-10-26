package com.example.robot.Web;


import com.example.robot.Data.Coordinates;
import com.example.robot.Data.MapData;
import com.example.robot.Data.Repositiories.MapDataRepository;
import com.example.robot.Data.WalkerDTO;
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

    private MapDataRepository mapDataRepository;

    private WalkerServiceImp walkerServiceImp;

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public WalkerDTO createWalker(@RequestBody Coordinates coords) { return walkerServiceImp.create(coords); }

    @PatchMapping(path="{id}/{command}")
    public WalkerDTO giveCommand(@PathVariable long id, @PathVariable String command) { return walkerServiceImp.implementCommand(id, command); }

    @GetMapping(path="map/{id}")
    public MapData getMap(@PathVariable long id) { //Need to transform map to DTO!!!
        return mapDataRepository.findById(id).get();
    }

    @PatchMapping(path = "{id}/service", consumes = "application/json") // In this case we're creating all entities even they already exist.
    public WalkerDTO walk(@RequestBody Coordinates coords, @PathVariable long id) {return walkerServiceImp.goToGoal(id, coords.getX1(), coords.getY1());}
}
