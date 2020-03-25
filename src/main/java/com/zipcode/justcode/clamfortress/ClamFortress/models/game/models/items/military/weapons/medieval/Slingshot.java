package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;

import java.util.concurrent.*;

public class Slingshot extends AbstractMedievalWeapon implements Projectile {

    private final Integer ammoCount;
    private final Integer damage;
    private Integer shots;
    private Integer accuracy;

    public Slingshot() {
        super("Slingshot", "Cannons shoots cannonballs.");
        this.ammoCount = 6;
        this.damage = 1;
        this.shots = 0;
        this.accuracy = 80;
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

    @Override
    public Integer getAccuracy() {
        return this.accuracy;
    }

    @Override
    public Integer modifyAtk() {
        return 0;
    }

    @Override
    public Slingshot clone() {
        return new Slingshot();
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
}
