package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class ProjectileEnhancer extends AbstractArtifact implements Unique {

    public ProjectileEnhancer() {
        super("Projectile Enhancer", "Upon pickup, set the accuracy of all of your projectile weapons to 100%.");
    }

    @Override
    public void onObtain() {
        for (AbstractItem item : Database.getCurrentGame().getVillage().getInventory().getItems()) {
            if (item instanceof Projectile) {
                Projectile fItem = (Projectile)item;
                if (fItem.getAccuracy() < 100) {
                    fItem.setAccuracy(100);
                    OutputManager.addToBot("Projectile Enhancer set accuracy of " + item.getName() + " to 100%!");
                }
            }
        }
    }

    @Override
    public ProjectileEnhancer clone() {
        return new ProjectileEnhancer();
    }
}
