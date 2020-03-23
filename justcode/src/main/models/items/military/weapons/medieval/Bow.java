package main.models.items.military.weapons.medieval;

import main.interfaces.*;

import java.util.concurrent.*;

public class Bow extends AbstractMedievalWeapon implements Projectile {

    protected Integer ammoCount;
    protected Integer damage;
    protected Integer shots;
    protected Integer accuracy;

    public Bow() {
        super("Bow", "A standard drawstring bow. Improves attack by 15.");
        this.ammoCount = 25;
        this.damage = 12;
        this.shots = 0;
        this.accuracy = 85;
    }

    public Bow(String name, String desc) {
        super(name, desc);
    }

    @Override
    public Integer modifyAtk() {
        return 15;
    }

    @Override
    public Bow clone() {
        return new Bow();
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
