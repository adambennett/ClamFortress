package main.models.items.military.weapons.medieval;


import main.interfaces.*;

import java.util.concurrent.*;

public class Cannon extends AbstractMedievalWeapon implements Projectile {

    private final Integer ammoCount;
    private final Integer damage;
    private Integer shots;
    private Integer accuracy;

    public Cannon() {
        super("Cannon", "Cannons shoots cannonballs.");
        this.ammoCount = 10;
        this.damage = 250;
        this.shots = 0;
        this.accuracy = 35;
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
    public Cannon clone() {
        return new Cannon();
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
