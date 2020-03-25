package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class ArchiveTest {

    @BeforeEach
    public void setup() {
        //Game.startGame();      
    }

    @Test
    public void get() {
        GameObject obj = Archive.getInstance().get("wood");
        String expected = "Wood";
        String actual = obj.getName();
        Assertions.assertEquals(expected, actual);
        Assertions.assertTrue(obj instanceof Wood);
    }

    @Test
    public void generateNewResources() {
        ArrayList<AbstractResource> res = Archive.getInstance().generateNewResources("stone", 15);
        Integer expected = 15;
        Integer actual = res.size();
        Assertions.assertEquals(expected, actual);
        Assertions.assertTrue(res.get(0) instanceof Stone);
    }

    @Test
    public void artifacts() {
        ArrayList<AbstractArtifact> art = Archive.getInstance().artifacts();
        Assertions.assertTrue(art.contains(new HolyCrown()));
    }

}