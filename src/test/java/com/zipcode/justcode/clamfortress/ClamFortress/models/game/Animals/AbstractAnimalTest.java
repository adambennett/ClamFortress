package com.zipcode.justcode.clamfortress.ClamFortress.models.game.Animals;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.desert.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.jungle.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land.bears.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.mountain.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.sea.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.tundra.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class AbstractAnimalTest {

    @Test
    public void getAmountOfFoodOnHuntTest(){
        AbstractMountainAnimal mGoat = new MountainGoat();

        Integer actual = mGoat.getAmountOfFoodOnHunt();
        Integer expected = 75;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void animalCloneTest(){
        ArrayList<AbstractAnimal> listOfAnimals = new ArrayList<>();
        listOfAnimals.add(new Armadillo().clone());
        listOfAnimals.add(new Camel().clone());
        listOfAnimals.add(new Lizard().clone());
        listOfAnimals.add(new Scorpion().clone());
        listOfAnimals.add(new Forestdweller().clone());
        listOfAnimals.add(new Jungleape().clone());
        listOfAnimals.add(new Wildabeast().clone());
        listOfAnimals.add(new Buffalo().clone());
        listOfAnimals.add(new Cat().clone());
        listOfAnimals.add(new Chicken().clone());
        listOfAnimals.add(new Cougar().clone());
        listOfAnimals.add(new Cow().clone());
        listOfAnimals.add(new Dog().clone());
        listOfAnimals.add(new Duck().clone());
        listOfAnimals.add(new Horse().clone());
        listOfAnimals.add(new Moose().clone());
        listOfAnimals.add(new Pig().clone());
        listOfAnimals.add(new Turkey().clone());
        listOfAnimals.add(new BlackBear().clone());
        listOfAnimals.add(new BrownBear().clone());
        listOfAnimals.add(new CaveBear().clone());
        listOfAnimals.add(new GrizzlyBear().clone());
        listOfAnimals.add(new Panda().clone());
        listOfAnimals.add(new Pizzly().clone());
        listOfAnimals.add(new PolarBear().clone());
        listOfAnimals.add(new SlothBear().clone());
        listOfAnimals.add(new MountainGoat().clone());
        listOfAnimals.add(new MountainHare().clone());

        Boolean expected = true;
        Boolean actual = null;
        for (AbstractAnimal a: listOfAnimals) {
            if(a == null){
                actual = false;
            }
            else actual = true;
        }

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void SeaAnimalsTest(){
        ArrayList<AbstractSeaAnimal> seaAnimals = new ArrayList<>();
        seaAnimals.add(new Dolphin().clone());
        seaAnimals.add(new Fish().clone());
        seaAnimals.add(new Penguin().clone());
        seaAnimals.add(new Platypus().clone());
        seaAnimals.add(new Seal().clone());
        seaAnimals.add(new Shark().clone());
        seaAnimals.add(new Whale().clone());

        Boolean expected = true;
        Boolean actual = null;
        for(AbstractSeaAnimal s : seaAnimals){
            if(s == null){
                actual = false;
            }
            else actual = true;
        }

        Assertions.assertEquals(actual,expected);
    }
}
