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
            int merchantRoll = ThreadLocalRandom.current().nextInt(0, 100);
            if (Game.getVillage().getInventory().containsItem("telescope")) {
                roll += 20;
            }

            if (roll >= 40) {
                AbstractNode region = Game.getGameBoard().getRandomRegion(this.nethermod);
                Game.getGameBoard().discover(region);
                OutputManager.addToBot("Discovered a new " + region.toString() + " region!");
            }

            merchantRoll = 1;
            if (merchantRoll == 1) {
                Merchant traveler = new Merchant();
                Game.getVillage().addMerchant(traveler);
                OutputManager.addToBot("During your exploring, you came upon a traveling merchant by the name of " + traveler.getName() + ".");
            }
        } else {
            OutputManager.addToBot(OutputFlag.FULL_BOARD, "The board is full! You cannot discover any additional spaces!");
            this.setAmtRemaining(this.amountToRun);
        }
        this.isDone = true;
    }

    @Override
    public Scouting clone() {
        return new Scouting(this.amountToRun, this.nethermod);
    }
}
