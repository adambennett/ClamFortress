package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.disasters;


import com.fasterxml.jackson.annotation.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;

import javax.persistence.*;

@Entity
public abstract class AbstractDisaster extends AbstractEncounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Village village;

    public AbstractDisaster() { super(); }

    public AbstractDisaster(String name, String desc, int turns) {
        super(name, desc, turns);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Village getVillage() {
        return village;
    }

    @Override
    public void setVillage(Village village) {
        this.village = village;
    }

    @Override
    public abstract void runEncounter();

}
