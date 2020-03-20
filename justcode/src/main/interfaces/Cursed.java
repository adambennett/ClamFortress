package main.interfaces;

import main.models.managers.*;

public interface Cursed {
    default void runCurse() {
        GameManager.getInstance().setNethermod(GameManager.getInstance().getNethermod() - 1);
    }
}
