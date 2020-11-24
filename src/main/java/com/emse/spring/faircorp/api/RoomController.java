package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    private final RoomDao roomDao;
    private final WindowDao windowDao;

    public RoomController( RoomDao roomDao , WindowDao windowDao) {
        this.roomDao = roomDao;
        this.windowDao = windowDao;
    }

    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }

    @PutMapping(path = "/{id}/switchWindow")
    public RoomDto switchStatus(@PathVariable Long id)
    {
       Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
       //List<Window> result = windowDao.findAllById(room.getWindows().stream().map(Window::getId).collect(Collectors.toList()));

        for(Window window : room.getWindows()) {
            window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED : WindowStatus.OPEN);
        }

        //room.setWindows(result);

        return new RoomDto(room);
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {

        Room room = null;
        room = roomDao.save(new Room(dto.getFloor(), dto.getName()));

        return new RoomDto(room);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        roomDao.deleteById(id);
    }
}