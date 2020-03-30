package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.human.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.sea.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FishingTest {
    
    private static Game game;
    
    @BeforeEach
    public void setup() {
        game = new Game();
        game.setId(1L);
        Database.setGameForTests(game);
    }

    @Test
    public void fishingTestWithoutRod(){
        Fishing fishing = new Fishing(1);        
        game.getVillage().setFoodLimit(999);
        game.getGameBoard().addAnimals( new Penguin(),11);

        game.getVillage().setFood(0);
        game.getVillage().setFoodLimit(999);


        fishing.update();

        Integer actual = game.getVillage().getFood();
        Integer expected = 24;
        assertEquals(expected, actual);
    }

    @Test
    public void fishingTestWithRod(){
        Fishing fishing = new Fishing(1);
        PodsRod rod = new PodsRod();
        game.getVillage().setFoodLimit(999);
        game.getVillage().getInventory().addItem(rod);
        game.getGameBoard().addAnimals( new Penguin(),11);

        game.getVillage().setFood(0);



        fishing.update();

        Integer actual = game.getVillage().getFood();
        Integer expected = 48;

        assertEquals(expected, actual);
    }
}
