package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BuildingDao extends JpaRepository<Building, Long> {
    @Query("select w from Window w where w.room.id in (select r from Room r where r.building.id=:id )")
    List<Window> findWindowBuilding(@Param("id") Long id);
}
