package main.models.items.military.weapons.guns;

import main.interfaces.*;
import main.models.items.military.weapons.*;

import java.util.concurrent.*;

public abstract class AbstractGun extends AbstractWeapon implements Projectile {

    private final Integer ammoCount;
    private final Integer damage;
    private Integer shots;
    private Integer accuracy;

    public AbstractGun(String name, String desc, int ammoCount, int dmg, int accuracy) {
        super(name, desc);
        if (accuracy > 100) { accuracy = 100; }
        if (accuracy < 0) { accuracy = 0; }
        this.ammoCount = ammoCount;
        this.shots = 0;
        this.damage = dmg;
        this.accuracy = accuracy;
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
    public Integer modifyAtk() {
        return 0;
    }

    @Override
    public abstract AbstractGun clone();
}
