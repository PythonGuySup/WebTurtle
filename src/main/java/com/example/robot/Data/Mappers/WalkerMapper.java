package com.example.robot.Data.Mappers;


import com.example.robot.Data.MapData;
import com.example.robot.Data.RobotData;
import com.example.robot.Data.RobotTypes;
import com.example.robot.Data.WalkerDTO;
import com.example.robot.Logic.Walker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface WalkerMapper {
    @Mapping(target = "robotId", source = "walker.id")
    @Mapping(target = "mapId", source = "walker.mapData.id")
    @Mapping(target = "robotType", constant = "WALKER")
    @Mapping(target = "positionPoint", source = "walker.positionPoint")
    @Mapping(target = "map", source = "walker.mapData.map")
    @Mapping(target = "path", source = "walker.path" )
    WalkerDTO toWalkerDTO(Walker walker);

}
