package main.models.items.military.weapons.future;

import main.interfaces.*;
import main.models.items.military.weapons.*;

import java.util.concurrent.*;

public abstract class AbstractFutureGun extends AbstractWeapon implements Projectile {

    private final Integer ammoCount;
    protected final Integer damage;
    private Integer shots;
    protected Integer plasmaDamage;
    protected Integer accuracy;

    public AbstractFutureGun(String name, String desc, int ammoCount, int dmg, int accuracy) {
        super(name, desc);
        if (dmg < 2) { dmg = 2; }
        if (accuracy > 100) { accuracy = 100; }
        if (accuracy < 0) { accuracy = 0; }
        this.ammoCount = ammoCount;
        this.shots = 0;
        this.damage = dmg;
        this.plasmaDamage = ThreadLocalRandom.current().nextInt(1, dmg);
        this.accuracy = accuracy;
    }

    @Override
    public Boolean canFire() {
        return this.shots < this.ammoCount || ThreadLocalRandom.current().nextInt(0, 10) == 1;
    }

    @Override
    public Integer fire() {
        if (this.shots < this.ammoCount) {
            this.shots++;
            this.plasmaDamage =  ThreadLocalRandom.current().nextInt(1, damage);
            boolean hit = false;
            if (this.accuracy == 100) {
                hit = true;
            } else {
                int shot = ThreadLocalRandom.current().nextInt(0, 100);
                if (shot <= this.accuracy) {
                    hit = true;
                }
            }
            return (hit) ? this.damage * this.plasmaDamage : 0;
        }
        return 0;
    }

    @Override
    public Integer modifyAtk() {
        return 0;
    }

    @Override
    public abstract AbstractFutureGun clone();

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
