package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.human.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.sea.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FishingTest {

    @Test
    public void fishingTestWithoutRod(){
        Fishing fishing = new Fishing(1);
        Game.startGame();
        Game.getVillage().setFoodLimit(999);
        Game.getGameBoard().addAnimals( new Penguin(),11);

        Game.getVillage().setFood(0);
        Game.getVillage().setFoodLimit(999);


        fishing.update();

        Integer actual = Game.getVillage().getFood();
        Integer expected = 24;
        assertEquals(expected, actual);
    }

    @Test
    public void fishingTestWithRod(){
        Fishing fishing = new Fishing(1);
        PodsRod rod = new PodsRod();
        Game.startGame();
        Game.getVillage().setFoodLimit(999);
        Game.getVillage().getInventory().addItem(rod);
        Game.getGameBoard().addAnimals( new Penguin(),11);

        Game.getVillage().setFood(0);



        fishing.update();

        Integer actual = Game.getVillage().getFood();
        Integer expected = 48;

        assertEquals(expected, actual);
    }
}
