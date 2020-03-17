package main.Animals;

import main.models.animals.Animal;
import main.models.animals.desert.Armadillo;
import main.models.animals.desert.Camel;
import main.models.animals.desert.Lizard;
import main.models.animals.desert.Scorpion;
import main.models.animals.jungle.Forestdweller;
import main.models.animals.jungle.Jungleape;
import main.models.animals.jungle.Wildabeast;
import main.models.animals.land.*;
import main.models.animals.land.bears.*;
import main.models.animals.mountain.Cougar;
import main.models.animals.mountain.MountainAnimal;
import main.models.animals.mountain.MountainGoat;
import main.models.animals.mountain.MountainHare;
import main.models.animals.sea.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class AnimalTest {

    @Test
    public void getAmountOfFoodOnHuntTest(){
        MountainAnimal mGoat = new MountainGoat();

        Integer actual = mGoat.getAmountOfFoodOnHunt();
        Integer expected = 75;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void animalCloneTest(){
        ArrayList<Animal> listOfAnimals = new ArrayList<>();
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
        for (Animal a: listOfAnimals) {
            if(a == null){
                actual = false;
            }
            else actual = true;
        }

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void SeaAnimalsTest(){
        ArrayList<SeaAnimal> seaAnimals = new ArrayList<>();
        seaAnimals.add(new Dolphin().clone());
        seaAnimals.add(new Fish().clone());
        seaAnimals.add(new Penguin().clone());
        seaAnimals.add(new Platypus().clone());
        seaAnimals.add(new Seal().clone());
        seaAnimals.add(new Shark().clone());
        seaAnimals.add(new Whale().clone());

        Boolean expected = true;
        Boolean actual = null;
        for(SeaAnimal s : seaAnimals){
            if(s == null){
                actual = false;
            }
            else actual = true;
        }

        Assert.assertEquals(actual,expected);

    }
}
