package main.utilities;


import main.models.Game;
import main.models.items.*;
import main.models.items.artifacts.*;
import main.models.managers.*;
import main.models.nodes.*;
import main.models.people.*;
import main.models.resources.*;

import java.util.*;
import java.util.concurrent.*;

public class GameStrings {

    private static ArrayList<Character> vowels;

    static {
        chooseRace = "";
        turnMenu = "";
        priorityMenu = "";
        vowels = new ArrayList<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    private static String chooseRace;
    private static String turnMenu;
    private static String priorityMenu;
    private static String endPhase;
    private static String resources;
    private static String inv;
    private static String vil;

    private static final String openingBlurb = "GAME START\nHelp your guys survive and thrive... watch out for cLAmS";

    private static final String openGame =
                    "**************************************************\n" +
                    "***                Clam Fortress               ***\n" +
                    "***--------------------------------------------***\n" +
                    "***                1 | New Game                ***\n" +
                    "***                2 | Load Game               ***\n" +
                    "**************************************************\n";

    private static final String chooseBiome =
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

    private static final String chooseDifficulty =
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

    private static final String customDifficulty =
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

    public static Boolean startsWithVowel(String word) {
        return isVowel(word.charAt(0));
    }

    public static Boolean isVowel(Character character) {
        return (character != null) && vowels.contains(character);
    }

    public static String capFirstLetter(String s) {
        String color = s.toLowerCase();
        color = s.toLowerCase().substring(0, 1).toUpperCase() + color.substring(1);
        return color;
    }

    private static String format(String s, String lenCheck, String endString) {
        while (s.length() < lenCheck.length()) {
            s += " ";
        }
        s += endString + "\n";
        return s;
    }

    private static String formatNoNL(String s, String lenCheck) {
        while (s.length() < lenCheck.length()) {
            s += " ";
        }
        s += "<";
        return s;
    }

    public static Map<String, String> getRaces() {
        String human = "Human";
        String orc = "???";
        String elf = orc;
        String dwarf = orc;
        String claman = orc;
        String alien = orc;
        boolean isOrcUnlocked = main.utilities.persistence.Database.getOrcsUnlocked();
        boolean isElfUnlocked = main.utilities.persistence.Database.getElvesUnlocked();
        boolean isDwarfUnlocked = main.utilities.persistence.Database.getDwarvesUnlocked();
        boolean isClamanUnlocked = main.utilities.persistence.Database.getClamanUnlocked();
        boolean isAlienUnlocked = main.utilities.persistence.Database.getAliensUnlocked();
        if (isAlienUnlocked)  { alien = "Alien";   }
        if (isClamanUnlocked) { claman = "Claman"; }
        if (isDwarfUnlocked)  { dwarf = "Dwarf";   }
        if (isElfUnlocked)    { elf = "Elf";       }
        if (isOrcUnlocked)    { orc = "Orc";       }
        Map<String, String> raceMenuMap = new HashMap<>();
        int index = 1;
        raceMenuMap.put("" + index, human); index++;
        raceMenuMap.put("" + index, orc); index++;
        raceMenuMap.put("" + index, elf); index++;
        raceMenuMap.put("" + index, dwarf); index++;
        raceMenuMap.put("" + index, claman); index++;
        raceMenuMap.put("" + index, alien);
        return raceMenuMap;
    }

    public static String newMenu(String leftAlignFormat, String headerFormat, String breakLine, String header, Map<String, String> commandToLabelMap) {
        ArrayList<Map<String, String>> list = new ArrayList<>();
        list.add(commandToLabelMap);
        return newMenu(leftAlignFormat, headerFormat, breakLine, header, list);
    }

    public static String newMenu(String leftAlignFormat, String headerFormat, String breakLine, String header, ArrayList<Map<String, String>> commandToLabelMapList) {
        String finalString = "";
        finalString += breakLine;
        finalString += String.format(headerFormat, header);
        finalString += breakLine;
        for (Map<String, String> map : commandToLabelMapList) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                finalString += String.format(leftAlignFormat, entry.getKey(), entry.getValue());
            }
            finalString += breakLine;
        }
        return finalString;
    }

    public static String newNewMenu(String leftAlignFormat, String headerFormat, String breakLine, String header, ArrayList<LinkedHashMap<String, ArrayList<String>>> commandToLabelMapList) {
        String finalString = "";
        finalString += breakLine;
        finalString += String.format(headerFormat, header);
        finalString += breakLine;
        for (LinkedHashMap<String, ArrayList<String>> map : commandToLabelMapList) {
            for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
                int size = entry.getValue().size() + 1;
                String[] newArr = new String[size];
                newArr[0] = entry.getKey();
                for (int i = 0; i < newArr.length - 1; i++) {
                    newArr[i+1] = entry.getValue().get(i);
                }
                finalString += String.format(leftAlignFormat,newArr);
            }
            finalString += breakLine;
        }
        return finalString;
    }

    public static void loadRaceMenu() {
        String leftAlignFormat = "| %-2s | %-15s |\n";
        String headerFormat = "| %-20s |\n";
        String breakLine = "+----+-----------------+\n";
        String header = "Choose Village Race";
        chooseRace = newMenu(leftAlignFormat, headerFormat, breakLine, header, getRaces());
    }

    public static LinkedHashMap<String, String> getTurns() {
        LinkedHashMap<String, String> a = new LinkedHashMap<>();
        Village v = Game.getVillage();
        a.put("Turn Number", "" + Game.getGameManager().getTurnNumber());
        a.put("Population", "" + Game.getVillage().getPopulation() + " / " + Game.getVillage().getPopCap());
        a.put("Village HP", "" + Game.getVillage().getHealth() + " / " + Game.getVillage().getHealth());
        a.put("Resources", "" + Game.getVillage().totalResources() + " / " + Game.getVillage().getResourceLimit());
        a.put("Buildings", "" + Game.getVillage().getBuildings().size() + " / " + Game.getVillage().getBuildingLimit());
        a.put("Food", "" + Game.getVillage().getFood() + " / " + Game.getVillage().getFoodLimit());
        a.put("Hunger", "" + Game.getVillage().getHunger() + " / " + 100);
        a.put("Coins", "" + Game.getVillage().getCoins() + " / " + Game.getVillage().getCoinLimit());
        a.put("Faith", "" + Game.getVillage().getFaith() + " / " + Game.getVillage().getFaithLimit());
        return a;
    }

    public static LinkedHashMap<String, String> getTurnCommands() {
        LinkedHashMap<String, String> a = new LinkedHashMap<>();
        a.put("2", "Stats");
        if (Game.getVillage().getInventory().getItems().size() > 0) {
            a.put("3", "Inventory");
        } else {
            a.put("3", "[No Items]");
        }
        if (Game.getVillage().getBuildings().size() > 0) {
            a.put("4", "Buildings");
        } else {
            a.put("4", "[No Buildings]");
        }
        if (Game.getVillage().getPopulation() > 0) {
            a.put("5", "Population");
        } else {
            a.put("5", "[No Villagers]");
        }
        if (Game.getVillage().getVistingMerchants().size() > 0) {
            a.put("6", "Merchants");
        } else {
            a.put("6", "[No Merchants Available]");
        }
        if (Game.getVillage().getVistingMerchants().size() > 0) {
            a.put("6", "Merchants");
        } else {
            a.put("6", "[No Merchants Available]");
        }
        if (Game.canRaid()) {
            a.put("7", "Raid a City");
        } else {
            a.put("7", "[Raids Unavailable]");
        }
        int trainingCost = GameManager.getInstance().getTrainingCost();
        if (Game.getVillage().getCoins() >= trainingCost) {
            a.put("8", "Train (" +  trainingCost + " Coins)");
        } else {
            a.put("8", "[Not Enough Coins]");
        }
        return a;
    }

    public static void loadTurnMenu() {
        String leftAlignFormat = "| %28s | %-30s |\n";
        String headerFormat = "| %-61s |\n";
        String breakLine = "+------------------------------+--------------------------------+\n";
        String header = "STANDBY PHASE";
        LinkedHashMap<String, String> date = new LinkedHashMap<>();
        LinkedHashMap<String, String> bottom = new LinkedHashMap<>();
        LinkedHashMap<String, String> megaBottom = new LinkedHashMap<>();
        date.put(GameManager.getInstance().getDateString(), Game.getGameManager().getSeason());
        bottom.put("0", "Priorities Phase");
        megaBottom.put("End", "Skip to End Phase");
        megaBottom.put("Quit", "Finish Game");
        megaBottom.put("Save", "Save & Continue");
        megaBottom.put("Exit", "Save & Quit");
        ArrayList<Map<String, String>> list = new ArrayList<>();
        list.add(date);
        list.add(getTurns());
        list.add(getTurnCommands());
        list.add(bottom);
        list.add(megaBottom);
        turnMenu = newMenu(leftAlignFormat, headerFormat, breakLine, header, list);
    }

    public static void loadPriorityMenu() {
        String food1Name = "***             1 | ";
        String food2Name = "***             2 | ";
        String food3Name = "***             3 | ";
        ArrayList<main.enums.FoodOptions> optionEnums = main.enums.FoodOptions.getOptionsFromRace(Game.getPlayerRace());
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
        food1Name = formatNoNL(food1Name, lenny);
        food2Name = formatNoNL(food2Name, lenny);
        food3Name = formatNoNL(food3Name, lenny);
        Integer foodPriority1 = main.models.managers.PriorityManager.getFood1();
        Integer foodPriority2 = main.models.managers.PriorityManager.getFood2();
        Integer foodPriority3 = main.models.managers.PriorityManager.getFood3();
        Integer prayPriority = main.models.managers.PriorityManager.getPray();
        Integer foragePriority = main.models.managers.PriorityManager.getForage();
        Integer woodcutPriority = main.models.managers.PriorityManager.getWoodcut();
        Integer stonePickPriority = main.models.managers.PriorityManager.getStone();
        Integer miningPriority = main.models.managers.PriorityManager.getMine();
        Integer defendPriority = main.models.managers.PriorityManager.getDefend();
        Integer harvestPriority = main.models.managers.PriorityManager.getHarvest();
        Integer forgePriority = main.models.managers.PriorityManager.getForge();
        Integer healPriority = main.models.managers.PriorityManager.getHeal();
        Integer scoutPriority = main.models.managers.PriorityManager.getScout();
        Integer plantPriority = main.models.managers.PriorityManager.getPlant();
        Integer smithPriority = main.models.managers.PriorityManager.getSmith();
        Integer smeltPriority = main.models.managers.PriorityManager.getSmelt();
        Integer raidPriority = main.models.managers.PriorityManager.getRaid();
        Integer engineerPriority = main.models.managers.PriorityManager.getEngineer();
        Integer buildPriority = main.models.managers.PriorityManager.getBuild();
        Integer tradePriority = main.models.managers.PriorityManager.getTrade();
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
        String points = format("(" + main.models.managers.PriorityManager.getPointsRemaining() + ")" , lenB, ending);
        priorityMenu =
                        "***************************************************************\n" +
                        "***                      PRIORITY PHASE                     ***\n" +
                        "***************************************************************\n" +
                        "***                       Points: " + points +
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
                        "***---------------------------------------------------------***\n" +
                        "***             0 | End Phase                               ***\n " +
                        "***************************************************************\n";
    }

    public static void loadEndPhase() {
        endPhase =
                "****************************************************************************************************\n" +
                "***                                          END PHASE                                           ***\n" +
                "***----------------------------------------------------------------------------------------------***\n" +
                "***                                      0 | Standby Phase                                       ***\n" +
                "***                                      1 | Reprint End Turn Report                             ***\n" +
                "***----------------------------------------------------------------------------------------------***\n" +
                "***                                   Skip | Skip to next End Phase                              ***\n" +
                "***                                   Quit | Finish Game                                         ***\n" +
                "***                                   Save | Save & Continue                                     ***\n" +
                "***                                   Exit | Save & Quit                                         ***\n" +
                "****************************************************************************************************\n";
    }

    public static LinkedHashMap<String, String> getResources() {
        LinkedHashMap<String, String> rsrcMap = new LinkedHashMap<>();
        Village v = Game.getVillage();
        rsrcMap.put("Population", "" + v.getPopulation() + " / " + v.getPopCap());
        rsrcMap.put("Buildings", "" + v.getBuildings().size() + " / " + v.getBuildingLimit());
        rsrcMap.put("Total Village HP", "" + v.getHealth() + " / " + v.getHealth());
        rsrcMap.put("Attack", "" + v.getAttackPower());
        rsrcMap.put("Defense", "" + v.getDefense());
        rsrcMap.put("Agility", "" + v.getAgility());
        rsrcMap.put("Dexterity", "" + v.getDexterity());
        rsrcMap.put("Engineering", "" + v.getEngineering());
        rsrcMap.put("Intellect", "" + v.getIntelligence());
        rsrcMap.put("Magic", "" + v.getMagic());
        rsrcMap.put("Strength", "" + v.getStrength());
        rsrcMap.put("Average Age", "" + v.getAgeAvg());
        rsrcMap.put("Average Agility", "" + v.getAgilityAvg());
        rsrcMap.put("Average Dexterity", "" + v.getDexterityAvg());
        rsrcMap.put("Average Engineering", "" + v.getEngineeringAvg());
        rsrcMap.put("Average Intellect", "" + v.getIntelligenceAvg());
        rsrcMap.put("Average Magic", "" + v.getMagicAvg());
        rsrcMap.put("Average Strength", "" + v.getStrengthAvg());
        rsrcMap.put("Coins", "" + v.getCoins() + " / " + v.getCoinLimit());
        rsrcMap.put("Food", "" + v.getFood() + " / " + v.getFoodLimit());
        rsrcMap.put("Faith", "" + v.getFaith() + " / " + v.getFaithLimit());
        Map<String, Integer> occ = new HashMap<>();
        for (AbstractResource resource : v.getAllResources()) {
           if (occ.containsKey(resource.getName())) {
               occ.put(resource.getName(), occ.get(resource.getName()) + 1);
           } else {
               occ.put(resource.getName(), 1);
           }
        }
        for (Map.Entry<String, Integer> entry : occ.entrySet()) {
            rsrcMap.put(entry.getKey(), ""+entry.getValue());
        }
        return rsrcMap;
    }

    public static LinkedHashMap<String, String> getInventory() {
        LinkedHashMap<String, String> a = new LinkedHashMap<>();
        Village v = Game.getVillage();
        for (AbstractItem item : v.getInventory().getItems()){
            String name = item.getName();
            a.put(name, item.getDesc());
        }
        if (a.size() < 1) {
            a.put(" ", " ");
        }
        return a;
    }
    public static LinkedHashMap<String, ArrayList<String>> getVillagers() {
        LinkedHashMap<String, ArrayList<String>> a = new LinkedHashMap<>();
        Village v = Game.getVillage();
        for (Survivor s : v.getSurvivors()) {
            ArrayList<String> tempCols = new ArrayList<>();
            tempCols.add("" + s.getAge());
            tempCols.add("" + s.getHealthPoints());
            tempCols.add("" + s.getStrength());
            tempCols.add("" + s.getDexterity());
            tempCols.add("" + s.getIntelligence());
            tempCols.add("" + s.getAgility());
            tempCols.add("" + s.getMagic());
            tempCols.add("" + s.getEngineering());
            tempCols.add(GameStrings.capFirstLetter(s.getRace().toString().toLowerCase()));
            tempCols.add(GameStrings.capFirstLetter(s.getGender().toString().toLowerCase()));
            a.put(s.getName(), tempCols);
        }
        if (a.size() < 1) {
            ArrayList<String> tempCols = new ArrayList<>();
            tempCols.add("");
            tempCols.add("");
            tempCols.add("");
            tempCols.add("");
            tempCols.add("");
            tempCols.add("");
            tempCols.add("");
            tempCols.add("");
            tempCols.add("");
            tempCols.add("");
            a.put(" ", tempCols);
        }
        return a;
    }


    public static void loadResources() {
        String leftAlignFormat = "| %-25s | %-25s |\n";
        String headerFormat = "| %-53s |\n";
        String breakLine = "+---------------------------+---------------------------+\n";
        String header = "Village Stats";
        Map<String, String> bottom = new HashMap<>();
        bottom.put("0", "Return to Standby Menu");
        ArrayList<Map<String, String>> list = new ArrayList<>();
        list.add(getResources());
        list.add(bottom);
        resources = newMenu(leftAlignFormat, headerFormat, breakLine, header, list);
    }

    public static void loadInventory() {
        String leftAlignFormat = "| %-25s | %-85s |\n";
        String headerFormat = "| %-113s |\n";
        String breakLine = "+---------------------------+---------------------------------------------------------------------------------------+\n";
        String header = "Inventory";
        Map<String, String> top = new HashMap<>();
        Map<String, String> bottom = new HashMap<>();
        top.put("Item Name", "Description");
        bottom.put("0", "Return to Standby Menu");
        ArrayList<Map<String, String>> list = new ArrayList<>();
        list.add(top);
        list.add(getInventory());
        list.add(bottom);
        inv = newMenu(leftAlignFormat, headerFormat, breakLine, header, list);
    }

    public static void loadVillagers() {
        String leftAlignFormat = "| %-52s | %-8s | %-8s | %-4s | %-4s | %-4s | %-4s | %-4s | %-4s | %-10s | %-10s |\n";
        String headerFormat = "| %-142s |\n";
        String breakLine = "+------------------------------------------------------+----------+----------+------+------+------+------+------+------+------------+------------+\n";
        String header = "Population";
        LinkedHashMap<String, ArrayList<String>> top = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<String>> bottom = new LinkedHashMap<>();
        ArrayList<String> topCols = new ArrayList<>();
        ArrayList<String> botCols = new ArrayList<>();
        topCols.add("AGE"); botCols.add("Return");
        topCols.add("HP"); botCols.add("");
        topCols.add("STR"); botCols.add("");
        topCols.add("DEX"); botCols.add("");
        topCols.add("INT"); botCols.add("");
        topCols.add("AGI"); botCols.add("");
        topCols.add("MAG"); botCols.add("");
        topCols.add("ENG"); botCols.add("");
        topCols.add("RACE"); botCols.add("");
        topCols.add("GENDER"); botCols.add("");
        top.put("NAME", topCols);
        bottom.put("0", botCols);
        ArrayList<LinkedHashMap<String, ArrayList<String>>> list = new ArrayList<>();
        list.add(top);
        list.add(getVillagers());
        list.add(bottom);
        vil = newNewMenu(leftAlignFormat, headerFormat, breakLine, header, list);
    }

    public static String getStringFromPromptType(main.enums.PromptMessage msg) {
        switch (msg) {
            case BIOME_MENU:
                return chooseBiome;
            case CUSTOM_DIFF_MENU:
                return customDifficulty;
            case DIFF_MENU:
                return chooseDifficulty;
            case LOGIN_MENU:
                return openGame;
            case BLURB:
                return openingBlurb;
            case PRIORITY_MENU:
                loadPriorityMenu();
                return priorityMenu;
            case RACE_MENU:
                loadRaceMenu();
                return chooseRace;
            case TURN_MENU:
                loadTurnMenu();
                return turnMenu;
            case END_PHASE:
                loadEndPhase();
                return endPhase;
            case RESOURCE_VIEW:
                loadResources();
                return resources;
            case INVENTORY_VIEW:
                loadInventory();
                return inv;
            case VILLAGERS:
                loadVillagers();
                return vil;
        }
        return "";
    }

    public static String getRandomName(boolean includePokemon) {
        ArrayList<String> names = new ArrayList<>();
        names.add("A Monkey");
        names.add("A Platypus");
        names.add("Aaron");
        names.add("Adam");
        names.add("Adara");
        names.add("Addison");
        names.add("Aileen");
        names.add("Alan");
        names.add("Alec");
        names.add("Alice");
        names.add("Alvin");
        names.add("Amela");
        names.add("Amelia");
        names.add("Amir");
        names.add("Anthony");
        names.add("Arden");
        names.add("Armand");
        names.add("Ash Ketchum");
        names.add("Ashely");
        names.add("Ashley");
        names.add("Ashy Larry");
        names.add("Aspen");
        names.add("Astra");
        names.add("Ayanna");
        names.add("Azalia");
        names.add("Barry");
        names.add("Beady Eyes McGee");
        names.add("Beatrice");
        names.add("Benedict");
        names.add("Bethany");
        names.add("Beverly");
        names.add("Blue Man Group");
        names.add("Branden");
        names.add("Branden");
        names.add("Brennan");
        names.add("Brent");
        names.add("Britanney");
        names.add("Brock");
        names.add("Bruno");
        names.add("Buckminster");
        names.add("Burton");
        names.add("Bus Stop Guy");
        names.add("Cade");
        names.add("Carly");
        names.add("Cedric");
        names.add("Chaim");
        names.add("Chancellor");
        names.add("Chaney");
        names.add("Charles");
        names.add("Charlotte");
        names.add("Chris Nobles");
        names.add("Clare");
        names.add("Clinton");
        names.add("Cole");
        names.add("Colette");
        names.add("Coronavirus Man");
        names.add("Damian");
        names.add("Damian");
        names.add("Dan Stabb");
        names.add("Danny Carey");
        names.add("Dante");
        names.add("Darth Vader");
        names.add("Dean");
        names.add("Dennis");
        names.add("Derek");
        names.add("Desa");
        names.add("Desirae");
        names.add("Donald Trump");
        names.add("Driscoll");
        names.add("Eagan");
        names.add("Easter Bunny");
        names.add("Echo");
        names.add("Eden");
        names.add("Eleanor");
        names.add("Elizabeth");
        names.add("Elton");
        names.add("Emerald");
        names.add("Emerson");
        names.add("Erich");
        names.add("Farmer Joe");
        names.add("Farmer Rick");
        names.add("Fat Guy");
        names.add("Fatima");
        names.add("Fredericka");
        names.add("Gage");
        names.add("Galena");
        names.add("Gandalf");
        names.add("Gary Oak");
        names.add("Gannon");
        names.add("Gemma");
        names.add("Geoffrey");
        names.add("Glenna");
        names.add("Graiden");
        names.add("Hadassah");
        names.add("Han");
        names.add("Hanae");
        names.add("Harriet");
        names.add("Hayfa");
        names.add("Heidi");
        names.add("Helen");
        names.add("Herman");
        names.add("Herrod");
        names.add("Hilary");
        names.add("Hobo Jeff");
        names.add("Hobo Jim");
        names.add("Hot Girl");
        names.add("Ignacia");
        names.add("Ignacia");
        names.add("Ignatius");
        names.add("Iliana");
        names.add("Indira");
        names.add("Indira");
        names.add("Ira");
        names.add("Isaac");
        names.add("Jack");
        names.add("Jacob");
        names.add("Jael");
        names.add("Jakeem");
        names.add("Jamalia");
        names.add("Jarrod");
        names.add("Jedi");
        names.add("Jeremy");
        names.add("Jeremy");
        names.add("Jerry");
        names.add("Jill");
        names.add("Joe Rogan");
        names.add("Joe");
        names.add("John Oliver");
        names.add("John");
        names.add("Jorden");
        names.add("Josephine");
        names.add("Josiah");
        names.add("Julian");
        names.add("Justine");
        names.add("Kalia");
        names.add("Karina");
        names.add("Karleigh");
        names.add("Kaseem");
        names.add("Keane");
        names.add("Keegan");
        names.add("Keely");
        names.add("Kelly");
        names.add("Kirby");
        names.add("Kitty Rotten");
        names.add("Kris Younger");
        names.add("Kylynn");
        names.add("Lacey");
        names.add("Lacey");
        names.add("Lara");
        names.add("Latifah");
        names.add("Lee");
        names.add("Leon");
        names.add("Lillian");
        names.add("Lossy");
        names.add("Lucius");
        names.add("Lydia");
        names.add("Lysandra");
        names.add("Macaulay");
        names.add("Macaulay");
        names.add("Macey");
        names.add("Macy");
        names.add("Madonna");
        names.add("Maggie");
        names.add("Maite");
        names.add("Malik");
        names.add("Master Hand");
        names.add("Crazy Hand");
        names.add("Giovanni");
        names.add("Lt. Surge");
        names.add("Gunny");
        names.add("Gunner");
        names.add("Hook Man");
        names.add("Really Slow Guy");
        names.add("White Knight");
        names.add("Black Knight");
        names.add("Knight of Ni");
        names.add("Saul Goodman");
        names.add("Walter White");
        names.add("Jesse Pinkman");
        names.add("Jon Snow");
        names.add("Tyrion");
        names.add("A Dragon");
        names.add("Dothraki Screamer");
        names.add("Unsullied Soldier");
        names.add("Khalessi");
        names.add("Dany");
        names.add("Dani");
        names.add("Danny");
        names.add("Drew Carey");
        names.add("Jim Carey");
        names.add("Idris Elba");
        names.add("Steve Carell");
        names.add("Steven Colbert");
        names.add("John Stewart");
        names.add("Aragorn");
        names.add("Legolas");
        names.add("Gimli");
        names.add("Frodo");
        names.add("Samwise Gamgee");
        names.add("Pippin");
        names.add("Merry");
        names.add("Gandalf, the White");
        names.add("Gandalf, the Grey");
        names.add("Voldemort");
        names.add("Harry Potter");
        names.add("Ronald Weasley");
        names.add("Fred Weasley");
        names.add("George Weasley");
        names.add("Arthur Weasley");
        names.add("Ginny Weasley");
        names.add("Percy Weasley");
        names.add("Molly Weasley");
        names.add("Hermonine Granger");
        names.add("Hedwig");
        names.add("Mark");
        names.add("Mary");
        names.add("Mary");
        names.add("Melissa");
        names.add("Melvin");
        names.add("Melyssa");
        names.add("Mercedes");
        names.add("Merrill");
        names.add("Micheal Jackson");
        names.add("Miriam");
        names.add("Mr. Nice Guy");
        names.add("Murphy");
        names.add("My Dad");
        names.add("Myra");
        names.add("Myra");
        names.add("Nancy");
        names.add("Naomi");
        names.add("Nasim");
        names.add("Natalie");
        names.add("Nehru");
        names.add("Neil Peart");
        names.add("Nell");
        names.add("Nelle");
        names.add("Nerea");
        names.add("Noble");
        names.add("Nomlanga");
        names.add("Noob");
        names.add("Octavia");
        names.add("Octavius");
        names.add("Odysseus");
        names.add("Oleg");
        names.add("Ori");
        names.add("Owen");
        names.add("Paki");
        names.add("Paki");
        names.add("Pamela");
        names.add("Patrick Star");
        names.add("Pete");
        names.add("Peter Griffin");
        names.add("Petra");
        names.add("Phillip");
        names.add("Phoebe");
        names.add("Post Malone");
        names.add("Price");
        names.add("Priscilla");
        names.add("Professor Oak");
        names.add("Professor Elm");
        names.add("Professor Birch");
        names.add("Quail");
        names.add("Quamar");
        names.add("Quinlan");
        names.add("Quinn");
        names.add("Rafael");
        names.add("Raja");
        names.add("Rajah");
        names.add("Rebecca");
        names.add("Ric Flair");
        names.add("Rick James");
        names.add("Roberto");
        names.add("Robin");
        names.add("AJ Applegate");
        names.add("RoboCop");
        names.add("Ronan");
        names.add("Russian Spy");
        names.add("Samson");
        names.add("Santa Claus");
        names.add("Sasha");
        names.add("Sauron");
        names.add("Scarlet");
        names.add("Scuba Steve");
        names.add("Sebastian");
        names.add("Sharon");
        names.add("Shellie");
        names.add("Silas");
        names.add("Skyler");
        names.add("Spock");
        names.add("Spongebob");
        names.add("Stacey");
        names.add("Stacey's Mom");
        names.add("Stacey");
        names.add("Stella");
        names.add("Steve-O");
        names.add("Stuart");
        names.add("Susan");
        names.add("Squidward");
        names.add("Mr. Krabs");
        names.add("Tanek");
        names.add("Tarik");
        names.add("Tariq");
        names.add("Tate");
        names.add("Teagan");
        names.add("Thaddeus");
        names.add("Thor");
        names.add("Timmy Turner");
        names.add("Trevor");
        names.add("Uncle Bob");
        names.add("Uriel");
        names.add("Valentine");
        names.add("Vivian");
        names.add("Wade");
        names.add("Wing");
        names.add("Wynne");
        names.add("Xandra");
        names.add("Yolanda");
        names.add("Yosemite Sam");
        names.add("Your Girlfriend");
        names.add("Emperor Thaurissan");
        names.add("Deathwing");
        names.add("Yogg-Saron");
        names.add("Murloc");
        names.add("Murloc Tidehunter");
        names.add("Murloc Rockpool");
        names.add("Fisheye Guy");
        names.add("Weird Eye Guy");
        names.add("Fisheye Girl");
        names.add("Weird Eye Girl");
        names.add("Dumb Person");
        names.add("Smart Person");
        names.add("King Joghause");
        names.add("King Flausweussen");
        names.add("King Nordissanijakivic");
        names.add("King Swijckiwskty");
        names.add("King RuntimeError");
        names.add("King CompileError");
        names.add("Confused Programmer");
        names.add("Confused Debugger");
        names.add("Program Bug");
        names.add("Program Bug");
        names.add("Program Bug");
        names.add("Movie Watcher");
        names.add("Creepo");
        names.add("Radiohead");
        names.add("Nickleback");
        names.add("The Arbiter");
        names.add("343 Guilty Spark");
        names.add("Volcano Worshipper");
        names.add("Hurricane Worshipper");
        names.add("Plague Worshipper");
        names.add("Tornado Worshipper");
        names.add("Earthquake Worshipper");
        names.add("Master of Terminals");
        names.add("Controller of Versions");
        names.add("Breaker of Convention");
        names.add("Adam Codeborn of the House Bennett");
        names.add("King of the First Men");
        names.add("King of the Andals");
        names.add("COVID-19 Carrier");
        names.add("Greasy Guy");
        names.add("Guy Who Says Moist");
        names.add("Racist Guy");
        names.add("Politically Correct Guy");
        names.add("Sacha Baron Cohen");
        names.add("Nathan Fielder");
        names.add("Daniel Tosh");
        names.add("Tony Hinchcliffe");
        names.add("Brian Redban");
        names.add("Jeremiah Watkins");
        names.add("Joelberg");
        names.add("Molly Stewart");
        names.add("Andrew Santino");
        names.add("Bill Burr");
        names.add("Huel");
        names.add("Vacuum Repair Guy");
        names.add("Mr. Beast");
        names.add("Mark Rober");
        names.add("NASA Guy");
        names.add("Elon Musk");
        names.add("Obama");
        names.add("George Bush");
        names.add("George Clinton");
        names.add("Abraham Lincoln");
        names.add("Mark Wahlberg");
        names.add("Marky Mark");
        names.add("50 Cent");
        names.add("Eminem");
        names.add("A Ghost");
        names.add("Cursed Guy");
        names.add("Unlucky Guy");
        names.add("Joyner Lucas");
        names.add("Luke Holland");
        names.add("Mark McQuire");
        names.add("Ed Sheeran");
        names.add("Hopsin");
        names.add("Quavo");
        names.add("Katy Perry");
        names.add("Billie Eilish");
        names.add("Sean Evans");
        names.add("Pete Davidson");
        names.add("Nicholas Cage");
        names.add("Nicholas Cage (from Con Air)");
        names.add("Paul Rudd");
        names.add("Shaq");
        names.add("Koby Bryant");
        names.add("Gordon Ramsey");
        names.add("Paula Deen");
        names.add("Margot Robbie");
        names.add("Olivia Wilde");
        names.add("Ashton Kutcher");
        names.add("Shia LaBeouf");
        if (includePokemon) {
            names.add("Bulbasaur");
            names.add("Ivysaur");
            names.add("Venusaur");
            names.add("Charmander");
            names.add("Charmeleon");
            names.add("Charizard");
            names.add("Squirtle");
            names.add("Wartortle");
            names.add("Blastoise");
            names.add("Caterpie");
            names.add("Butterfree");
            names.add("Beedrill");
            names.add("Pidgey");
            names.add("Rattata");
            names.add("Ekans");
            names.add("Pikachu");
            names.add("Raichu");
            names.add("Sandshrew");
            names.add("Nidoqueen");
            names.add("Nidoking");
            names.add("Clefairy");
            names.add("Vulpix");
            names.add("Ninetales");
            names.add("Jigglypuff");
            names.add("Zubat");
            names.add("Vileplume");
            names.add("Diglett");
            names.add("Dugtrio");
            names.add("Meowth");
            names.add("Psyduck");
            names.add("Growlithe");
            names.add("Arcanine");
            names.add("Poliwag");
            names.add("Slowpoke");
            names.add("Gengar");
            names.add("Onix");
            names.add("Cubone");
            names.add("Hitmonlee");
            names.add("Hitmonchan");
            names.add("Lickitung");
            names.add("Koffing");
            names.add("Weezing");
            names.add("Mr.Mime");
            names.add("Scyther");
            names.add("Electabuzz");
            names.add("Magmar");
            names.add("Pinsir");
            names.add("Magikarp");
            names.add("Gyarados");
            names.add("Eevee");
            names.add("Vaporeon");
            names.add("Jolteon");
            names.add("Flareon");
            names.add("Snorlax");
            names.add("Articuno");
            names.add("Zapdos");
            names.add("Moltres");
            names.add("Dragonite");
            names.add("Mewtwo");
            names.add("Mew");
            names.add("Typhlosion");
            names.add("Totodile");
            names.add("Hoothoot");
            names.add("Pichu");
            names.add("Togepi");
            names.add("Ampharos");
            names.add("Marill");
            names.add("Sudowoodo");
            names.add("Quagsire");
            names.add("Espeon");
            names.add("Umbreon");
            names.add("Qwilfish");
            names.add("Shuckle");
            names.add("Heracross");
            names.add("Piloswine");
            names.add("Corsola");
            names.add("Raikou");
            names.add("Entei");
            names.add("Tyranitar");
            names.add("Lugia");
            names.add("Ho-Oh");
            names.add("Celebi");
            names.add("Treecko");
            names.add("Torchic");
            names.add("Blaziken");
            names.add("Mudkip");
            names.add("Zigzagoon");
            names.add("Ralts");
            names.add("Metagross");
            names.add("Latias");
            names.add("Latios");
            names.add("Kyogre");
            names.add("Groudon");
            names.add("Rayquaza");
            names.add("Jirachi");
            names.add("Deoxys");
        }
        return names.get(ThreadLocalRandom.current().nextInt(names.size()));
    }

}
