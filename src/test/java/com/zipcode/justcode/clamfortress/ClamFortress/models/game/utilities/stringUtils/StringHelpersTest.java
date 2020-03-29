package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.stringUtils;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.consoleIO.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import org.aspectj.lang.annotation.*;
import org.junit.jupiter.api.*;

public class StringHelpersTest {

    @BeforeEach
    public void setUp() {
        Game game = new Game();
        game.setId(1L);
        Database.setGameForTests(game);
        StringHelpers.reloadStrings();
    }

    @Test
    public void startsWithVowel() {
        String a = "A";
        String b = "B";
        String aa = "aa";
        String bb = "bb";
        String ba = "Ba";
        String ab = "Ab";
        String wonky = "ASIASMasdjasdasdujAASdjka";

        Assertions.assertTrue(StringHelpers.startsWithVowel(wonky));
        Assertions.assertTrue(StringHelpers.startsWithVowel(a));
        Assertions.assertTrue(StringHelpers.startsWithVowel(aa));
        Assertions.assertTrue(StringHelpers.startsWithVowel(ab));
        Assertions.assertFalse(StringHelpers.startsWithVowel(b));
        Assertions.assertFalse(StringHelpers.startsWithVowel(bb));
        Assertions.assertFalse(StringHelpers.startsWithVowel(ba));
    }

    @Test
    public void capFirstLetter() {
        String adam = "adam";
        String expected = "Adam";
        String actual = StringHelpers.capFirstLetter(adam);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void reloadStrings() {
        String initial = GameStrings.turnMenu;
        GameUtils.devConsoleObtainObject(new Coin(), 200, new MidTurnMenu(), true);
        String after = GameStrings.turnMenu;
        Assertions.assertNotEquals(initial, after);
    }

    @Test
    public void getStringFromPromptType() {
        GameStrings.loadStats();
        String expectedArchive = GameStrings.archive;
        String expectedBiome = GameStrings.chooseBiome;
        String expectedDifficulty = GameStrings.chooseDifficulty;
        String expectedCustomDiff = GameStrings.customDifficulty;
        String expectedMain = GameStrings.mainMenu;
        String expectedBlurb = GameStrings.openingBlurb;
        String expectedPriority = GameStrings.priorityMenu;
        String expectedRace = GameStrings.chooseRace;
        String expectedTurn = GameStrings.turnMenu;
        String expectedEnd = GameStrings.endPhase;
        String expectedStats = GameStrings.stats;
        String expectedInventory = GameStrings.inv;
        String expectedVillagers = GameStrings.vil;
        String expectedPopSetup = GameStrings.pop;
        String expectedGameBoard = GameStrings.board;
        String expectedBoardSize = GameStrings.boardSize;
        String expectedHub = GameStrings.newGameHub;
        String expectedLogin = GameStrings.loginScreen;
        String expectedEra = GameStrings.startEra;
        String expectedBuild = GameStrings.build;
        String expectedResources = GameStrings.resources;
        String expectedMerchant = GameStrings.merchant;
        String expectedTraining = GameStrings.train;
        String expectedSaleMerchant = GameStrings.saleMerchant;
        String actualArchive = StringHelpers.getStringFromPromptType(PromptMessage.ARCHIVE);
        String actualBiome = StringHelpers.getStringFromPromptType(PromptMessage.BIOME_MENU);
        String actualDifficulty = StringHelpers.getStringFromPromptType(PromptMessage.DIFF_MENU);
        String actualCustomDiff = StringHelpers.getStringFromPromptType(PromptMessage.CUSTOM_DIFF_MENU);
        String actualMain = StringHelpers.getStringFromPromptType(PromptMessage.MAIN_MENU);
        String actualBlurb = StringHelpers.getStringFromPromptType(PromptMessage.BLURB);
        String actualPriority = StringHelpers.getStringFromPromptType(PromptMessage.PRIORITY_MENU);
        String actualRace = StringHelpers.getStringFromPromptType(PromptMessage.RACE_MENU);
        String actualTurn = StringHelpers.getStringFromPromptType(PromptMessage.TURN_MENU);
        String actualEnd = StringHelpers.getStringFromPromptType(PromptMessage.END_PHASE);
        String actualStats = StringHelpers.getStringFromPromptType(PromptMessage.STAT_VIEW);
        String actualInventory = StringHelpers.getStringFromPromptType(PromptMessage.INVENTORY_VIEW);
        String actualVillagers = StringHelpers.getStringFromPromptType(PromptMessage.VILLAGERS);
        String actualPopSetup = StringHelpers.getStringFromPromptType(PromptMessage.POP_SETUP);
        String actualGameBoard = StringHelpers.getStringFromPromptType(PromptMessage.GAME_BOARD);
        String actualBoard = StringHelpers.getStringFromPromptType(PromptMessage.BOARD_SIZE);
        String actualHub = StringHelpers.getStringFromPromptType(PromptMessage.NEW_GAME_HUB);
        String actualLogin = StringHelpers.getStringFromPromptType(PromptMessage.LOGIN);
        String actualEra = StringHelpers.getStringFromPromptType(PromptMessage.START_ERA);
        String actualBuild = StringHelpers.getStringFromPromptType(PromptMessage.BUILDINGS);
        String actualResources = StringHelpers.getStringFromPromptType(PromptMessage.RESOURCE_VIEW);
        String actualMerchant = StringHelpers.getStringFromPromptType(PromptMessage.MERCHANT);
        String actualTraining = StringHelpers.getStringFromPromptType(PromptMessage.TRAINING);
        String actualSaleMerchant = StringHelpers.getStringFromPromptType(PromptMessage.SALE_MERCHANT);
        Assertions.assertEquals(expectedArchive, actualArchive);
        Assertions.assertEquals(expectedBiome, actualBiome);
        Assertions.assertEquals(expectedDifficulty, actualDifficulty);
        Assertions.assertEquals(expectedCustomDiff, actualCustomDiff);
        Assertions.assertEquals(expectedMain, actualMain);
        Assertions.assertEquals(expectedBlurb, actualBlurb);
        Assertions.assertEquals(expectedPriority, actualPriority);
        Assertions.assertEquals(expectedRace, actualRace);
        Assertions.assertEquals(expectedTurn, actualTurn);
        Assertions.assertEquals(expectedEnd, actualEnd);
        Assertions.assertEquals(expectedStats, actualStats);
        Assertions.assertEquals(expectedInventory, actualInventory);
        Assertions.assertEquals(expectedVillagers, actualVillagers);
        Assertions.assertEquals(expectedPopSetup, actualPopSetup);
        Assertions.assertEquals(expectedGameBoard, actualGameBoard);
        Assertions.assertEquals(expectedBoardSize, actualBoard);
        Assertions.assertEquals(expectedHub, actualHub);
        Assertions.assertEquals(expectedLogin, actualLogin);
        Assertions.assertEquals(expectedEra, actualEra);
        Assertions.assertEquals(expectedBuild, actualBuild);
        Assertions.assertEquals(expectedResources, actualResources);
        Assertions.assertEquals(expectedMerchant, actualMerchant);
        Assertions.assertEquals(expectedTraining, actualTraining);
        Assertions.assertEquals(expectedSaleMerchant, actualSaleMerchant);
    }
}