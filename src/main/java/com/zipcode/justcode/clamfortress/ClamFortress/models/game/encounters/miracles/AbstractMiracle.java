package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.miracles;


import com.fasterxml.jackson.annotation.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import javax.persistence.*;

@Entity
public abstract class AbstractMiracle extends AbstractEncounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Village village;

    public AbstractMiracle() { super(); }

    public AbstractMiracle(String name, String desc, int turns) {
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
    public void runEncounter() {
        Database.getCurrentGame().getVillage().addMiracle(this);
    }


}
