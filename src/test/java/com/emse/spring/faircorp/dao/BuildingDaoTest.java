package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BuildingDaoTest {

    @Autowired
    private BuildingDao buildingDao;

    //Should find all windows in a building
    @Test
    public void shouldFindAllWindows() {
        List<Window> windows = buildingDao.findWindowBuilding(-6L);
        Assertions.assertThat(windows.get(0).getName()).isEqualTo("Main Window");
        Assertions.assertThat(windows.get(1).getName()).isEqualTo("Small Window");
    }
}
