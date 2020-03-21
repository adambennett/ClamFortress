package main.utilities.stringUtils;

import main.enums.*;
import main.models.*;
import main.models.resources.refined.*;
import main.utilities.*;
import main.utilities.consoleIO.*;
import org.junit.*;

import static org.junit.Assert.*;

public class StringHelpersTest {

    @Before
    public void setUp() {
        Game.startGame();
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

        Assert.assertTrue(StringHelpers.startsWithVowel(wonky));
        Assert.assertTrue(StringHelpers.startsWithVowel(a));
        Assert.assertTrue(StringHelpers.startsWithVowel(aa));
        Assert.assertTrue(StringHelpers.startsWithVowel(ab));
        Assert.assertFalse(StringHelpers.startsWithVowel(b));
        Assert.assertFalse(StringHelpers.startsWithVowel(bb));
        Assert.assertFalse(StringHelpers.startsWithVowel(ba));
    }

    @Test
    public void capFirstLetter() {
        String adam = "adam";
        String expected = "Adam";
        String actual = StringHelpers.capFirstLetter(adam);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reloadStrings() {
        String initial = GameStrings.turnMenu;
        GameUtils.devConsoleObtainObject(new Coin(), 200, new MidTurnMenu(), true);
        String after = GameStrings.turnMenu;
        Assert.assertNotEquals(initial, after);
    }

    @Test
    public void getStringFromPromptType() {
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
        Assert.assertEquals(expectedArchive, actualArchive);
        Assert.assertEquals(expectedBiome, actualBiome);
        Assert.assertEquals(expectedDifficulty, actualDifficulty);
        Assert.assertEquals(expectedCustomDiff, actualCustomDiff);
        Assert.assertEquals(expectedMain, actualMain);
        Assert.assertEquals(expectedBlurb, actualBlurb);
        Assert.assertEquals(expectedPriority, actualPriority);
        Assert.assertEquals(expectedRace, actualRace);
        Assert.assertEquals(expectedTurn, actualTurn);
        Assert.assertEquals(expectedEnd, actualEnd);
        Assert.assertEquals(expectedStats, actualStats);
        Assert.assertEquals(expectedInventory, actualInventory);
        Assert.assertEquals(expectedVillagers, actualVillagers);
        Assert.assertEquals(expectedPopSetup, actualPopSetup);
        Assert.assertEquals(expectedGameBoard, actualGameBoard);
        Assert.assertEquals(expectedBoardSize, actualBoard);
        Assert.assertEquals(expectedHub, actualHub);
        Assert.assertEquals(expectedLogin, actualLogin);
        Assert.assertEquals(expectedEra, actualEra);
        Assert.assertEquals(expectedBuild, actualBuild);
        Assert.assertEquals(expectedResources, actualResources);
        Assert.assertEquals(expectedMerchant, actualMerchant);
        Assert.assertEquals(expectedTraining, actualTraining);
        Assert.assertEquals(expectedSaleMerchant, actualSaleMerchant);
    }

    @Test
    public void twoColumnMenu() {
    }

    @Test
    public void multiColumnMenu() {
    }
}