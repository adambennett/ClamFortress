package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;



import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.merchants.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.concurrent.*;

public class Scouting extends AbstractGameAction {

    private final Integer nethermod;

    public Scouting(int amtToRun, int nethermod) {
        super(amtToRun);
        this.nethermod = nethermod;
    }

    @Override
    public void update() {
        /*if (!Database.getCurrentGame().getGameBoard().isBoardFull()) {
            int roll = ThreadLocalRandom.current().nextInt(0, 100);

            if (Database.getCurrentGame().getVillage().getInventory().containsItem("telescope")) {
                roll += 20;
            }

            if (roll >= 40) {
                AbstractNode region = Database.getCurrentGame().getGameBoard().getRandomRegion(this.nethermod);
                Database.getCurrentGame().getGameBoard().discover(region);
                OutputManager.addToBot("Discovered a new " + region.toString() + " region!");
            }
        } else {
            OutputManager.addToBot(OutputFlag.FULL_BOARD, "The board is full! You cannot discover any additional spaces!");
        }

        int merchantRoll = ThreadLocalRandom.current().nextInt(0, 100);
        if (Database.getCurrentGame().getVillage().getInventory().containsItem("shop token")) {
            merchantRoll += 20;
        }

        if (Database.getCurrentGame().getGameBoard().isBoardFull()) {
            merchantRoll += 10;
        }

        if (merchantRoll > 98) {
            Merchant traveler = MerchantManager.getRandomMerchant();
            //Database.getCurrentGame().getVillage().addMerchant(traveler);
            OutputManager.merch(1);
        }*/
        this.isDone = true;
    }

    @Override
    public Scouting clone() {
        return new Scouting(this.amountToRun, this.nethermod);
    }
}
