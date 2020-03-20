package main.models.items.artifacts;

import main.interfaces.*;
import main.models.*;
import main.models.items.*;
import main.models.managers.*;

public class ProjectileEnhancer extends AbstractArtifact implements Unique {

    public ProjectileEnhancer() {
        super("Projectile Enhancer", "Upon pickup, set the accuracy of all of your projectile weapons to 100%.");
    }

    @Override
    public void onObtain() {
        for (AbstractItem item : Game.getVillage().getInventory().getItems()) {
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
