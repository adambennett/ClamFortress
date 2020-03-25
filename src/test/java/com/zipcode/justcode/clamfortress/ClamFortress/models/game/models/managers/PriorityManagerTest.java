package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriorityManagerTest {

    @Test
    public void getPointsRemaining() {
        Game.startGame();
        Integer expectedFood1 = 10;
        Integer expectedFood2 = 15;
        Integer expectedFood3 = 20;
        Integer expectedPray = 25;
        Integer expectedForage = 30;
        Integer expectedWoodcut = 35;
        Integer expectedStone = 40;
        Integer expectedMine = 45;
        Integer expectedDefend = 50;
        Integer expectedHarvest = 55;
        Integer expectedForge = 60;
        Integer expectedHeal = 65;
        Integer expectedScout = 70;
        Integer expectedPlant = 75;
        Integer expectedSmith = 80;
        Integer expectedSmelt = 85;
        Integer expectedRaid = 90;
        Integer expectedEngineer = 95;
        Integer expectedBuild = 100;
        Integer expectedTrade = 105;
        Integer expectedPts = 110;
        Integer expectedDef = 115;
        PriorityManager.setDefend(expectedDefend);
        PriorityManager.setPointsRemaining(expectedPts);
        PriorityManager.setFood1(expectedFood1);
        PriorityManager.setFood2(expectedFood2);
        PriorityManager.setFood3(expectedFood3);
        PriorityManager.setPray(expectedPray);
        PriorityManager.setForage(expectedForage);
        PriorityManager.setWoodcut(expectedWoodcut);
        PriorityManager.setStone(expectedStone);
        PriorityManager.setMine(expectedMine);
        PriorityManager.setDefend(expectedDefend);
        PriorityManager.setHarvest(expectedHarvest);
        PriorityManager.setForge(expectedForge);
        PriorityManager.setHeal(expectedHeal);
        PriorityManager.setScout(expectedScout);
        PriorityManager.setPlant(expectedPlant);
        PriorityManager.setSmith(expectedSmith);
        PriorityManager.setMasonry(expectedSmelt);
        PriorityManager.setRaid(expectedRaid);
        PriorityManager.setEngineer(expectedEngineer);
        PriorityManager.setBuild(expectedBuild);
        PriorityManager.setTrade(expectedTrade);
        Integer actualFood1 = PriorityManager.getFood1();
        Integer actualFood2 = PriorityManager.getFood2();
        Integer actualFood3 = PriorityManager.getFood3();
        Integer actualPray = PriorityManager.getPray();
        Integer actualForage = PriorityManager.getForage();
        Integer actualWoodcut = PriorityManager.getWoodcut();
        Integer actualStone = PriorityManager.getStone();
        Integer actualMine = PriorityManager.getMine();
        Integer actualDefend = PriorityManager.getDefend();
        Integer actualHarvest = PriorityManager.getHarvest();
        Integer actualForge = PriorityManager.getForge();
        Integer actualHeal = PriorityManager.getHeal();
        Integer actualScout = PriorityManager.getScout();
        Integer actualPlant = PriorityManager.getPlant();
        Integer actualSmith = PriorityManager.getSmith();
        Integer actualSmelt = PriorityManager.getMasonry();
        Integer actualRaid = PriorityManager.getRaid();
        Integer actualEngineer = PriorityManager.getEngineer();
        Integer actualBuild = PriorityManager.getBuild();
        Integer actualTrade = PriorityManager.getTrade();
        Integer actualPts = PriorityManager.getPointsRemaining();
        assertEquals(expectedFood1, actualFood1);
        assertEquals(expectedFood2, actualFood2);
        assertEquals(expectedFood3, actualFood3);
        assertEquals(expectedPray, actualPray);
        assertEquals(expectedForage, actualForage);
        assertEquals(expectedWoodcut, actualWoodcut);
        assertEquals(expectedStone, actualStone);
        assertEquals(expectedMine, actualMine);
        assertEquals(expectedHarvest, actualHarvest);
        assertEquals(expectedForge, actualForge);
        assertEquals(expectedHeal, actualHeal);
        assertEquals(expectedDefend, actualDefend);
        assertEquals(expectedScout, actualScout);
        assertEquals(expectedPlant, actualPlant);
        assertEquals(expectedSmith, actualSmith);
        assertEquals(expectedSmelt, actualSmelt);
        assertEquals(expectedRaid, actualRaid);
        assertEquals(expectedEngineer, actualEngineer);
        assertEquals(expectedTrade, actualTrade);
        assertEquals(expectedPts, actualPts);
        assertEquals(expectedBuild, actualBuild);
    }
}