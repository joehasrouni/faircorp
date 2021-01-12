package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    private final RoomDao roomDao;
    private final BuildingDao buildingDao;

    public RoomController( RoomDao roomDao , BuildingDao buildingDao) {
        this.roomDao = roomDao;
        this.buildingDao = buildingDao;
    }

    @GetMapping
    List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {

        Room room = null;
        Building building = buildingDao.getOne(dto.getBuildingId());
        room = roomDao.save(new Room(building, dto.getName(),dto.getFloor(), dto.getCurrentTemperature(), dto.getTargetTemperature()));

        return new RoomDto(room);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        roomDao.deleteById(id);
    }

    @PutMapping(path = "/{id}/switchWindow")
    public RoomDto switchWindowStatus(@PathVariable Long id)
    {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);

        for(Window window : room.getWindows()) {
            window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED : WindowStatus.OPEN);
        }

        return new RoomDto(room) ;
    }

    @PutMapping(path="/{id}")
    public RoomDto updateTargetTemperature(@PathVariable Long id , @RequestBody RoomDto room)
    {
        Room original = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);

        original.setTargetTemperature(room.getTargetTemperature());

        return new RoomDto(original);
    }

    @PutMapping(path = "/{id}/switchHeaters")
    public RoomDto switchHeaterStatus(@PathVariable Long id)
    {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);

        for(Heater heater : room.getHeaters()) {
            heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF : HeaterStatus.ON);
        }

        return new RoomDto(room);
    }
}