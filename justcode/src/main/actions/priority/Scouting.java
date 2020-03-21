package main.actions.priority;

import main.actions.*;
import main.enums.*;
import main.models.*;
import main.models.nodes.*;
import main.models.managers.*;
import main.models.people.merchants.*;
import main.models.resources.natural.*;

import java.util.concurrent.*;

public class Scouting extends AbstractGameAction {

    private final Integer nethermod;

    public Scouting(int amtToRun, int nethermod) {
        super(amtToRun);
        this.nethermod = nethermod;
    }

    @Override
    public void update() {
        if (!Game.getGameBoard().isBoardFull()) {
            int roll = ThreadLocalRandom.current().nextInt(0, 100);

            if (Game.getVillage().getInventory().containsItem("telescope")) {
                roll += 20;
            }

            if (roll >= 40) {
                AbstractNode region = Game.getGameBoard().getRandomRegion(this.nethermod);
                Game.getGameBoard().discover(region);
                OutputManager.addToBot("Discovered a new " + region.toString() + " region!");
            }
        } else {
            OutputManager.addToBot(OutputFlag.FULL_BOARD, "The board is full! You cannot discover any additional spaces!");
        }

        int merchantRoll = ThreadLocalRandom.current().nextInt(0, 100);
        if (Game.getVillage().getInventory().containsItem("shop token")) {
            merchantRoll += 20;
        }

        if (Game.getGameBoard().isBoardFull()) {
            merchantRoll += 10;
        }

        if (merchantRoll > 98) {
            Merchant traveler = MerchantManager.getRandomMerchant();
            Game.getVillage().addMerchant(traveler);
            OutputManager.addToBot("During your exploring, you came upon a " + traveler.getMerchantType() + " by the name of " + traveler.getName() + ".");
        }
        this.isDone = true;
    }

    @Override
    public Scouting clone() {
        return new Scouting(this.amountToRun, this.nethermod);
    }
}
