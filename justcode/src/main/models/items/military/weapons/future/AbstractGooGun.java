package main.models.items.military.weapons.future;

import main.models.*;

import java.util.concurrent.*;

public abstract class AbstractGooGun extends AbstractFutureGun {

    public AbstractGooGun(String name, String desc, int ammoCount, int dmg, int accuracy) {
        super(name, desc, ammoCount, dmg, accuracy);
    }

    @Override
    public Boolean canFire() {
        return Game.getVillage().getResource("spacegoo") != null && Game.getVillage().getResource("spacegoo") > 0;
    }

    @Override
    public Integer fire() {
        if (canFire()) {
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
    public abstract AbstractFutureGun clone();
}
