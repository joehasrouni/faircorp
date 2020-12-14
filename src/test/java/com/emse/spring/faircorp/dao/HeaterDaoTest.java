package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class HeaterDaoTest {
    @Autowired
    private HeaterDao heaterDao;
    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldDeleteWindowsRoom() {
        Optional<Room> room = roomDao.findById(-10L);
        Assertions.assertThat(room.get().getHeaters().size()).isEqualTo(2);

        heaterDao.deleteByRoom(-10L);
        List<Heater> result = heaterDao.findAllById(room.get().getHeaters().stream().map(Heater::getId).collect(Collectors.toList()));
        Assertions.assertThat(result).isEmpty();

    }
}
