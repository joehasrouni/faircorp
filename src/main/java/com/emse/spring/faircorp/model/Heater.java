package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
@Table(name = "HEATER")
public class Heater {
    @Id // (3).
    @GeneratedValue
    private Long id;

    @Column(nullable=false) // (4)
    private String name;

    @Column
    private Long power;

    @ManyToOne(optional = false)
    private Room room;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING) // (5)
    private HeaterStatus heaterStatus;

    public Heater() {
    }

    public Heater(String name, Room room , HeaterStatus heaterStatus) {
        this.room = room;
        this.name = name;
        this.heaterStatus = heaterStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }
}
