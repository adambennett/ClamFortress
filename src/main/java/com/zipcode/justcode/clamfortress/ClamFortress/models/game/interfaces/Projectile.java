package com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces;

public interface Projectile {
    Boolean canFire();
    Integer fire();
    Integer getAccuracy();
    void setAccuracy(int accuracy);
}
