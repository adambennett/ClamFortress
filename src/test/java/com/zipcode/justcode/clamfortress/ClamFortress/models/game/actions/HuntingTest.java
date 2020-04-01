package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.human.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land.bears.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import org.junit.jupiter.api.*;

public class HuntingTest { ;

    private static Game game;

    @BeforeEach
    public void setup() {
        game = new Game();
        game.setId(1L);
        Database.setGameForTests(game);
    }

    @Test
    public void huntingTest(){
        game.getVillage().setFoodLimit(999);
       // game.getGameBoard().addAnimals(new BlackBear(), 10);
        Hunting hunting = new Hunting(1);
        hunting.update();
        Integer actual = game.getVillage().getFood();
        Assertions.assertTrue(actual > 0);
    }
}
