package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

import javax.persistence.*;
import java.util.*;
import java.util.concurrent.*;

/*@Entity*/
public class Farm extends GameObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private Village village;

    @Transient
    private List<Seeds> growing = new ArrayList<>();

    @Transient
    private List<Seeds> harvestable = new ArrayList<>();

    public Farm() {
        super("Farm", "Place to store all your seeds and plants.");
    }

    public Integer harvest() {
        if (harvestable.size() > 0) {
            Seeds randSeed = harvestable.remove(ThreadLocalRandom.current().nextInt(harvestable.size()));
            return randSeed.harvest();
        }
        return 0;
    }

    public void addSeeds(Seeds seed, int amt) {
        for (int i = 0; i < amt; i++) {
            this.growing.add(new Seeds());
        }
    }

    @Override
    public void endPhase() {
        for (Seeds seed : growing) {
            int food = seed.harvest();
            if (food > 0) {
                harvestable.add(seed);
            }
        }
    }

    public List<Seeds> getGrowing() {
        return growing;
    }

    public List<Seeds> getHarvestable() {
        return harvestable;
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

    public void setGrowing(List<Seeds> growing) {
        this.growing = growing;
    }

    public void setHarvestable(List<Seeds> harvestable) {
        this.harvestable = harvestable;
    }

    @Override
    public Farm clone() {
        return new Farm();
    }
}
