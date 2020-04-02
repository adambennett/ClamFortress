package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters;


import com.fasterxml.jackson.annotation.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;

import javax.persistence.*;

@Entity
public abstract class AbstractEncounter extends GameObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Village village;

    protected Integer turnsActive;

    public AbstractEncounter() { super("", ""); }

    public AbstractEncounter(String name, String desc, int turnsActive) {
        super(name, desc);
        this.turnsActive = turnsActive;
    }

    public abstract void runEncounter();

    public void setTurnsActive(Integer turnsActive) {
        this.turnsActive = turnsActive;
    }

    public Integer getTurnsActive() {
        return turnsActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    @Override
    public abstract String toString();

   /* @Override
    public abstract AbstractEncounter clone();*/

}
