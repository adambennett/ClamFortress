package main.interfaces;

public interface Projectile {
    Boolean canFire();
    Integer fire();
    Integer getAccuracy();
    void setAccuracy(int accuracy);
}
