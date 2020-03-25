package com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;

public interface Cursed {
    default void runCurse() {
        GameManager.getInstance().setNethermod(GameManager.getInstance().getNethermod() - 1);
    }
}
