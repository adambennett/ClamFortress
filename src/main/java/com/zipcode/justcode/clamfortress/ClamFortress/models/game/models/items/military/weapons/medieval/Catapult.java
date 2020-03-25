package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;

import java.util.concurrent.*;

public class Catapult extends AbstractWeapon implements Projectile {

    private final Integer ammoCount;
    private final Integer damage;
    private Integer shots;
    private Integer accuracy;

    public Catapult() {
        super("Catapult", "A heavy-duty military catapult. Improves attack by 500.");
        this.ammoCount = 2;
        this.damage = 6000;
        this.shots = 0;
        this.accuracy = 20;
    }

    @Override
    public Integer modifyAtk() {
        return 500;
    }

    @Override
    public Catapult clone() {
        return new Catapult();
    }

    @Override
    public Boolean canFire() {
        return this.shots < this.ammoCount;
    }

    @Override
    public Integer fire() {
        if (this.shots < this.ammoCount) {
            this.shots++;
            boolean hit = false;
            if (this.accuracy == 100) {
                hit = true;
            } else {
                int shot = ThreadLocalRandom.current().nextInt(0, 100);
                if (shot <= this.accuracy) {
                    hit = true;
                }
            }
            return (hit) ? this.damage : 0;
        }
        return 0;
    }

    @Override
    public Integer getAccuracy() {
        return this.accuracy;
    }

    @Override
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
        if (this.accuracy > 100) {
            this.accuracy = 100;
        }
        if (this.accuracy < 0) {
            this.accuracy = 0;
        }
    }
}
