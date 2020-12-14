package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Building;

import java.util.List;
import java.util.stream.Collectors;

public class BuildingDto {
    private long id;
    private String name;
    private List<RoomDto> rooms;

    public BuildingDto() {
    }

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();
        this.rooms = building.getRooms().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RoomDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDto> rooms) {
        this.rooms = rooms;
    }
}
