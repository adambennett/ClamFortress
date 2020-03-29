package com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public interface Cursed {
    default void runCurse() {
        Database.getCurrentGame().gameManager.setNethermod(Database.getCurrentGame().gameManager.getNethermod() - 1);
    }
}
