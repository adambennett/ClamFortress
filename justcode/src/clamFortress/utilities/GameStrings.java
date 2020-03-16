package clamFortress.utilities;

import clamFortress.consoleIO.*;
import clamFortress.enums.*;
import clamFortress.game.*;
import clamFortress.game.logic.*;
import clamFortress.utilities.persistence.*;

import java.util.*;
import java.util.concurrent.*;

public class GameStrings {


    private static String openGame;
    private static String chooseDifficulty;
    private static String chooseRace;
    private static String chooseBiome;
    private static String openingBlurb;
    private static String turnMenu;
    private static String customDifficulty;
    private static String priorityMenu;

    public static String capFirstLetter(String s) {
        String color = s.toLowerCase();
        color = color.substring(0, 1).toUpperCase() + color.substring(1, color.length());
        return color;
    }

    private static String format(String s, String lenCheck, String endString) {
        while (s.length() < lenCheck.length()) {
            s += " ";
        }
        s += endString + "\n";
        return s;
    }

    private static String formatNoNL(String s, String lenCheck, String endString) {
        while (s.length() < lenCheck.length()) {
            s += " ";
        }
        s += endString;
        return s;
    }

    private static void loadStrings(Game game) {
        priorityMenu = "";
        openingBlurb = "Blah blah help your guys survive and thrive... watch out for cLAmS";


        openGame =
                "**************************************************\n" +
                "***                Clam Fortress               ***\n" +
                "***--------------------------------------------***\n" +
                "***                1 | New Game                ***\n" +
                "***                2 | Load Game               ***\n" +
                "**************************************************\n";

        chooseDifficulty =
                "**************************************************\n" +
                "***               Select Difficulty            ***\n" +
                "***--------------------------------------------***\n" +
                "***                1 | Easy                    ***\n" +
                "***                2 | Standard                ***\n" +
                "***                3 | Hard                    ***\n" +
                "***                4 | Brutal                  ***\n" +
                "***                5 | Nightmare               ***\n" +
                "***                6 | Impossible              ***\n" +
                "***                7 | Custom                  ***\n" +
                "***                8 | Random                  ***\n" +
                "**************************************************\n";

        customDifficulty =
                "***************************************************************\n" +
                "***                    Difficulty Options                   ***\n" +
                "***---------------------------------------------------------***\n" +
                "***             1 | Tougher enemies                         ***\n" +
                "***             2 | Slow resource gain                      ***\n" +
                "***             3 | More bad events                         ***\n" +
                "***             4 | Terrible disasters                      ***\n" +
                "***             5 | Handicap starting equipment             ***\n" +
                "***             6 | More Netherworlds                       ***\n" +
                "***             7 | Tools are less effective                ***\n" +
                "***             8 | Incredibly hostile enemies              ***\n" +
                "***             9 | Limited Blueprint access                ***\n" +
                "***            10 | Disable Trading                         ***\n" +
                "***            11 | Disable Magic                           ***\n" +
                "***            12 | Disable Aliens                          ***\n" +
                "***            13 | Disable Healing                         ***\n" +
                "***            14 | Disable Faith                           ***\n" +
                "***            15 | Disable ability to check surroundings   ***\n" +
                "***---------------------------------------------------------***\n" +
                "***   Choose any combination of custom difficulty options   ***\n" +
                "***************************************************************\n";

        String orc = "???                     ***\n";
        String elf = orc;
        String dwarf = orc;
        String claman = orc;
        String alien = orc;
        boolean isOrcUnlocked = Database.getOrcsUnlocked();
        boolean isElfUnlocked = Database.getElvesUnlocked();
        boolean isDwarfUnlocked = Database.getDwarvesUnlocked();
        boolean isClamanUnlocked = Database.getClamanUnlocked();
        boolean isAlienUnlocked = Database.getAliensUnlocked();
        if (isAlienUnlocked) { alien = "Alien                   ***\n"; }
        if (isClamanUnlocked) { claman = "Claman                  ***\n"; }
        if (isDwarfUnlocked) { dwarf = "Dwarf                   ***\n"; }
        if (isElfUnlocked) { elf = "Elf                     ***\n"; }
        if (isOrcUnlocked) { orc = "Orc                     ***\n"; }
        chooseRace =
                "**************************************************\n" +
                "***             Choose Village Race            ***\n" +
                "***--------------------------------------------***\n" +
                "***                1 | Human                   ***\n" +
                "***                2 | " + orc +
                "***                3 | " + elf +
                "***                4 | " + dwarf +
                "***                5 | " + claman +
                "***                6 | " + alien +
                "***                7 | Random                  ***\n" +
                "**************************************************\n";

        chooseBiome =
                "**************************************************\n" +
                "***             Choose Starting Biome          ***\n" +
                "***--------------------------------------------***\n" +
                "***                1 | Grasslands (Default)    ***\n" +
                "***                2 | Desert                  ***\n" +
                "***                3 | Jungle                  ***\n" +
                "***                4 | Mountain                ***\n" +
                "***                5 | Sea                     ***\n" +
                "***                6 | Tundra                  ***\n" +
                "**************************************************\n";

        String endString = "***";
        String lenCheck = "************************************************************";
        String otherlen = "*******************************";
        String mana = "" + game.getVillage().getMana();
        String faith = "" + game.getVillage().getFaith();
        String coins = "" + game.getVillage().getCoins();
        String stone = "" + game.getVillage().getStone();
        String wood = "" + game.getVillage().getWood();
        String population = "" + game.getVillage().getPopulation() + " / " + game.getVillage().getPopCap();
        String turnNumber = "" + game.getGameManager().getTurnNumber();
        String date = "***  " + game.getGameManager().getDateString() + " :: ";
        String season = game.getGameManager().getSeason();
        String fullDate = date + season;
        String surroundings = "***                1 | Surrounding Region Report            ***\n";
        if (AbstractConsole.getCurrentGame() != null && !AbstractConsole.getCurrentGame().getSurroundingCheckEnabled()) {
            surroundings =          "***                1 | [DISABLED]                           ***\n";
        }
        mana = format(mana, otherlen, endString);
        coins = format(coins, otherlen, endString);
        stone = format(stone, otherlen, endString);
        wood = format(wood, otherlen, endString);
        population = format(population, otherlen, endString);
        turnNumber = format(turnNumber, otherlen, endString);
        fullDate = format(fullDate, lenCheck, endString);
        faith = format(faith, otherlen, endString);
        turnMenu =
                "***************************************************************\n" +
                    fullDate +
                "***           Turn Number :: " + turnNumber +
                "***            Population :: " + population +
                "***                  Wood :: " + wood +
                "***                 Stone :: " + stone +
                "***                 Coins :: " + coins +
                "***                 Faith :: " + faith +
                "***                  Mana :: " + mana +
                "***---------------------------------------------------------***\n" +
                surroundings +
                "***                2 | Village Resources                    ***\n" +
                "***                3 | Village Inventory                    ***\n" +
                "***                4 | Buildings                            ***\n" +
                "***                5 | Inspect Villagers                    ***\n" +
                "***                6 | Train (Random Stat - 200 Coins)      ***\n" +
                "***---------------------------------------------------------***\n" +
                "***                0 | Continue to Priorities Menu          ***\n" +
                "***---------------------------------------------------------***\n" +
                "***             Skip | Skip turn                            ***\n" +
                "***              End | End Game                             ***\n" +
                "***             Exit | Save & Quit                          ***\n" +
                "***************************************************************\n";
    }
    
    public static void loadPriorityMenu(PriorityManager manager, Game game) {
        String food1Name = "***             1 | ";
        String food2Name = "***             2 | ";
        String food3Name = "***             3 | ";
        ArrayList<FoodOptions> optionEnums = FoodOptions.getOptionsFromRace(game.getPlayerRace());
        if (optionEnums.size() > 2) {
            food1Name += capFirstLetter(optionEnums.get(0).writeInConsole().toLowerCase());
            food2Name += capFirstLetter(optionEnums.get(1).writeInConsole().toLowerCase());
            food3Name += capFirstLetter(optionEnums.get(2).writeInConsole().toLowerCase());
        } else if (optionEnums.size() > 1) {
            food1Name += capFirstLetter(optionEnums.get(0).writeInConsole().toLowerCase());
            food2Name += capFirstLetter(optionEnums.get(1).writeInConsole().toLowerCase());
            food3Name += "[Unavailable]";
        } else if (optionEnums.size() > 0) {
            food1Name += capFirstLetter(optionEnums.get(0).writeInConsole().toLowerCase());
            food2Name += "[Unavailable]";
            food3Name += "[Unavailable]";
        } else {
            food1Name += "[Unavailable]";
            food2Name += "[Unavailable]";
            food3Name += "[Unavailable]";
        }
        String lenny = "                                         ";
        food1Name = formatNoNL(food1Name, lenny, "<");
        food2Name = formatNoNL(food2Name, lenny, "<");
        food3Name = formatNoNL(food3Name, lenny, "<");
        Integer foodPriority1 = manager.getFood1();
        Integer foodPriority2 = manager.getFood2();
        Integer foodPriority3 = manager.getFood3();
        Integer prayPriority = manager.getPray();
        Integer foragePriority = manager.getForage();
        Integer woodcutPriority = manager.getWoodcut();
        Integer stonePickPriority = manager.getStone();
        Integer miningPriority = manager.getMine();
        Integer defendPriority = manager.getDefend();
        Integer harvestPriority = manager.getHarvest();
        Integer forgePriority = manager.getForge();
        Integer healPriority = manager.getHeal();
        Integer scoutPriority = manager.getScout();
        Integer plantPriority = manager.getPlant();
        Integer smithPriority = manager.getSmith();
        Integer smeltPriority = manager.getSmelt();
        Integer raidPriority = manager.getRaid();
        Integer engineerPriority = manager.getEngineer();
        Integer buildPriority = manager.getBuild();
        Integer tradePriority = manager.getTrade();
        String ending = "***";
        String len = "                  ";
        String foodLen = "                  ";
        String lenB = "                          ";
        String food1 = format( foodPriority1 + ">", foodLen, ending);
        String food2 = format(foodPriority2 + ">", foodLen, ending);
        String food3 = format(foodPriority3 + ">", foodLen, ending);
        String pray = format(prayPriority + ">", len, ending);
        String forage = format(foragePriority + ">", len, ending);
        String woody = format(woodcutPriority + ">", len, ending);
        String stoney = format(stonePickPriority + ">", len, ending);
        String mine = format(miningPriority + ">", len, ending);
        String defend = format(defendPriority + ">", len, ending);
        String harvest = format(harvestPriority + ">", len, ending);
        String forge = format(forgePriority + ">", len, ending);
        String heal = format(healPriority + ">", len, ending);
        String scout = format(scoutPriority + ">", len, ending);
        String plant = format(plantPriority + ">", len, ending);
        String smith = format(smithPriority + ">", len, ending);
        String smelt = format(smeltPriority + ">", len, ending);
        String raid = format(raidPriority + ">", len, ending);
        String engineer = format(engineerPriority + ">", len, ending);
        String build = format(buildPriority + ">", len, ending);
        String trade = format(tradePriority + ">", len, ending);
        String points = format("(" + manager.getPointsRemaining() + ")" , lenB, ending);
        priorityMenu =
                "***************************************************************\n" +
                        "***                    Priorities " + points +
                        "***---------------------------------------------------------***\n" +
                        food1Name + food1 +
                        food2Name + food2 +
                        food3Name + food3 +
                        "***             4 | Pray                 <" + pray +
                        "***             5 | Forage               <" + forage +
                        "***             6 | Woodcutting          <" + woody +
                        "***             7 | Stone Picking        <" + stoney +
                        "***             8 | Mining               <" + mine +
                        "***             9 | Defending            <" + defend +
                        "***            10 | Harvesting           <" + harvest +
                        "***            11 | Forging              <" + forge +
                        "***            12 | Healing              <" + heal +
                        "***            13 | Scouting             <" + scout +
                        "***            14 | Planting             <" + plant +
                        "***            15 | Smithing             <" + smith +
                        "***            16 | Smelting             <" + smelt +
                        "***            17 | Raiding              <" + raid +
                        "***            18 | Engineering          <" + engineer +
                        "***            19 | Building             <" + build +
                        "***            20 | Trading              <" + trade +
                        "***---------------------------------------------------------***\n" +
                        "***   Choose any combination of options to put points into  ***\n" +
                        "***************************************************************\n";

    
    }

    public static String getStringFromPromptType(PromptMessage msg, Game game) {
        loadStrings(game);
        switch (msg) {
            case BIOME_MENU:
                return chooseBiome;
            case CUSTOM_DIFF_MENU:
                return customDifficulty;
            case DIFF_MENU:
                return chooseDifficulty;
            case LOGIN_MENU:
                return openGame;
            case RACE_MENU:
                return chooseRace;
            case TURN_MENU:
                return turnMenu;
            case BLURB:
                return openingBlurb;
            case PRIORITY_MENU:
                loadPriorityMenu(game.priorityManager, game);
                return priorityMenu;
        }
        return "";
    }

    public static String getRandomName() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Scuba Steve");
        names.add("Gandalf");
        names.add("Sauron");
        names.add("Darth Vader");
        names.add("Dealer");
        names.add("John");
        names.add("Pete");
        names.add("Joe");
        names.add("Jack");
        names.add("Mary");
        names.add("Jill");
        names.add("Ashley");
        names.add("Steve-O");
        names.add("Joe Rogan");
        names.add("Kris Younger");
        names.add("Chris Nobles");
        names.add("Roberto");
        names.add("Adam");
        names.add("Raheel");
        names.add("Mo");
        names.add("Sandy");
        names.add("Dave");
        names.add("Zeth");
        names.add("Fat Guy");
        names.add("Noob");
        names.add("RoboCop");
        names.add("Mr. Nice Guy");
        names.add("Your Girlfriend");
        names.add("Hobo Jim");
        names.add("Hobo Jeff");
        names.add("Dan Stabb");
        names.add("Desa");
        names.add("Opponent");
        names.add("Bus Stop Guy");
        names.add("Russian Spy");
        names.add("Donald Trump");
        names.add("John Oliver");
        names.add("Hot Girl");
        names.add("Timmy Turner");
        names.add("Spongebob");
        names.add("Patrick Star");
        names.add("Ash Ketchum");
        names.add("My Dad");
        names.add("A Monkey");
        names.add("A Platypus");
        names.add("Farmer Joe");
        names.add("Farmer Rick");
        names.add("Ashy Larry");
        names.add("Rick James");
        names.add("Ric Flair");
        names.add("Post Malone");
        names.add("Danny Carey");
        names.add("Neil Peart");
        names.add("Jedi");
        names.add("Spock");
        names.add("Beady Eyes McGee");
        names.add("Yosemite Sam");
        names.add("Peter Griffin");
        names.add("Easter Bunny");
        names.add("Uncle Bob");
        names.add("Santa Claus");
        names.add("Kitty Rotten");
        names.add("Blue Man Group");
        names.add("Nick Foles");
        return names.get(ThreadLocalRandom.current().nextInt(names.size()));
    }

}
