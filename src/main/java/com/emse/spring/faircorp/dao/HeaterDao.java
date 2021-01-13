package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HeaterDao extends JpaRepository<Heater, Long> {
    @Query("select c from Heater c where c.name=:name")
    Heater findByName(@Param("name") String name);

    @Modifying
    @Query("delete from Heater c where c.name = ?1")
    void deleteByName(String name);

    @Modifying
    @Query("delete from Heater h where h.room.id = :roomParam")
    void deleteByRoom(@Param("roomParam") Long roomId);
}
