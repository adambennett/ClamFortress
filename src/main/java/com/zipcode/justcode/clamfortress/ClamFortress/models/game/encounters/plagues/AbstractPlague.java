package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.plagues;


import com.fasterxml.jackson.annotation.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import javax.persistence.*;
import java.util.concurrent.*;


@Entity
public abstract class AbstractPlague extends AbstractEncounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Village village;

    public AbstractPlague() {}

    public AbstractPlague(String name, String desc, int turns) {
        super(name, desc, turns);
    }

    @Override
    public void runEncounter() {
        if (Database.getCurrentGame().getVillage().getInventory().containsItem("vaccine")) {
            if (ThreadLocalRandom.current().nextBoolean()) {
                Database.getCurrentGame().getVillage().addPlague(this);
            }
        } else {
            Database.getCurrentGame().getVillage().addPlague(this);
        }
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
}
