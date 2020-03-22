package main.utilities.stringUtils;


import main.models.*;
import main.models.animals.*;
import main.models.buildings.abstracts.*;
import main.models.items.*;
import main.models.items.artifacts.*;
import main.models.managers.*;
import main.models.nodes.*;
import main.models.people.*;
import main.models.people.merchants.*;
import main.models.resources.*;
import main.models.tech.*;

import java.util.*;
import java.util.concurrent.*;

public class GameStrings {

    public static ArrayList<Character> vowels;
    public static final Map<Integer, String> modifierMap = new HashMap<>();
    public static String chooseRace;
    public static String turnMenu;
    public static String priorityMenu;
    public static String endPhase;
    public static String stats;
    public static String inv;
    public static String vil;
    public static String board;
    public static String build;
    public static String archive;
    public static String resources;
    public static String merchant;
    public static String saleMerchant;

    public static final String openingBlurb = "GAME START\nHelp your guys survive and thrive... watch out for cLAmS";

    public static final String loginScreen =
                    "**************************************************\n" +
                    "***              Clam Fortress                 ***\n" +
                    "***--------------------------------------------***\n" +
                    "***                1 | Login                   ***\n" +
                    "***                2 | Register                ***\n" +
                    "***                3 | Quickplay               ***\n" +
                    "***--------------------------------------------***\n" +
                    "***                0 | Exit                    ***\n" +
                    "**************************************************\n";

    public static final String newGameHub =
                    "**************************************************\n" +
                    "***               New Game Menu                ***\n" +
                    "***--------------------------------------------***\n" +
                    "***                1 | Difficulty              ***\n" +
                    "***                2 | Biome                   ***\n" +
                    "***                3 | Race                    ***\n" +
                    "***                4 | Population              ***\n" +
                    "***                5 | Board Size              ***\n" +
                    "***                6 | Difficulty Modifiers    ***\n" +
                    "***                7 | Starting Era            ***\n" +
                    "***                8 | View Current Settings   ***\n" +
                    "***--------------------------------------------***\n" +
                    "***                0 | Start Game              ***\n" +
                    "***--------------------------------------------***\n" +
                    "***             Exit | Exit Game               ***\n" +
                    "***             Quit | Return to Main Menu     ***\n" +
                    "***            Reset | Reset all to Default    ***\n" +
                    "**************************************************\n";

    public static final String mainMenu =
                    "**************************************************\n" +
                    "***                 Main Menu                  ***\n" +
                    "***--------------------------------------------***\n" +
                    "***                1 | New Game                ***\n" +
                    "***                2 | Load Game               ***\n" +
                    "***                3 | Stats                   ***\n" +
                    "***                4 | Archive                 ***\n" +
                    "***                5 | Options                 ***\n" +
                    "***--------------------------------------------***\n" +
                    "***                0 | Logout                  ***\n" +                  
                    "**************************************************\n";

    public static final String startEra =
                    "**************************************************\n" +
                    "***              Starting Era                  ***\n" +
                    "***--------------------------------------------***\n" +
                    "***           1 | Stone Age                    ***\n" +
                    "***           2 | Bronze Age                   ***\n" +
                    "***           3 | Iron Age                     ***\n" +
                    "***           4 | Exploration Age              ***\n" +
                    "***           5 | Industrial Age               ***\n" +
                    "***           6 | Information Age              ***\n" +
                    "***           7 | Future                       ***\n" +
                    "***--------------------------------------------***\n" +
                    "***           0 | Back to New Game Menu        ***\n" +
                    "***           9 | Start Game                   ***\n" +
                    "**************************************************\n";

    public static final String train =
                    "**************************************************\n" +
                    "***           Villager Training                ***\n" +
                    "***--------------------------------------------***\n" +
                    "***           1 | Agility                      ***\n" +
                    "***           2 | Strength                     ***\n" +
                    "***           3 | Dexterity                    ***\n" +
                    "***           4 | Intelligence                 ***\n" +
                    "***           5 | Engineering                  ***\n" +
                    "***           6 | Max HP                       ***\n" +
                    "***--------------------------------------------***\n" +
                    "***           0 | Return to Standby Phase      ***\n" +
                    "**************************************************\n";

    public static final String pop =
                    "**************************************************\n" +
                    "***              Population Options            ***\n" +
                    "***--------------------------------------------***\n" +
                    "***           1 | Set Population Cap           ***\n" +
                    "***           2 | Set Starting Population      ***\n" +
                    "***--------------------------------------------***\n" +
                    "***           0 | Back to New Game Menu        ***\n" +
                    "***           9 | Start Game                   ***\n" +
                    "**************************************************\n";

    public static final String boardSize =
                    "**************************************************\n" +
                    "***              Board Size Options            ***\n" +
                    "***--------------------------------------------***\n" +
                    "***           1 | Set Board X Max              ***\n" +
                    "***           2 | Set Board Y Max              ***\n" +
                    "***--------------------------------------------***\n" +
                    "***           0 | Back to New Game Menu        ***\n" +
                    "***           9 | Start Game                   ***\n" +
                    "**************************************************\n";

    public static final String chooseBiome =
                    "**************************************************\n" +
                    "***              Starting Biome                ***\n" +
                    "***--------------------------------------------***\n" +
                    "***           1 | Grasslands                   ***\n" +
                    "***           2 | Desert                       ***\n" +
                    "***           3 | Jungle                       ***\n" +
                    "***           4 | Mountain                     ***\n" +
                    "***           5 | Sea                          ***\n" +
                    "***           6 | Tundra                       ***\n" +
                    "***--------------------------------------------***\n" +
                    "***           0 | Back to New Game Menu        ***\n" +
                    "***           9 | Start Game                   ***\n" +
                    "**************************************************\n";

    public static final String gridTest =
                    "**************************************************\n" +
                    "***     _______________________________        ***\n" +
                    "***     |DESRT|NETHR|OCEAN|MOUNT|MOUNT|        ***\n" +
                    "***     | MIA | M A | M   |  I  |  I  |        ***\n" +
                    "***     |_____|_____|_____|_____|_____|        ***\n" +
                    "***     |CITY |JUNGL|JUNGL|TNDRA|TNDRA|        ***\n" +
                    "***     |  I  |  IA |     |     |  I  |        ***\n" +
                    "***     |_____|_____|_____|_____|_____|        ***\n" +
                    "***     |GRASS|JUNGL|JUNGL| VIL |JUNGL|        ***\n" +
                    "***     | MI  | M   |   A |     |   A |        ***\n" +
                    "***     |_____|_____|_____|_____|_____|        ***\n" +
                    "***                                            ***\n" +
                    "**************************************************\n";

    public static final String chooseDifficulty =
                    "**************************************************\n" +
                    "***              Select Difficulty             ***\n" +
                    "***--------------------------------------------***\n" +
                    "***           1 | Easy                         ***\n" +
                    "***           2 | Standard                     ***\n" +
                    "***           3 | Hard                         ***\n" +
                    "***           4 | Brutal                       ***\n" +
                    "***           5 | Nightmare                    ***\n" +
                    "***           6 | Impossible                   ***\n" +
                    "***           7 | Custom                       ***\n" +
                    "***           8 | Random                       ***\n" +
                    "***--------------------------------------------***\n" +
                    "***           0 | Back to New Game Menu        ***\n" +
                    "***           9 | Start Game                   ***\n" +
                    "**************************************************\n";

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

    public static final String customDifficulty =
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
                    "***             0 | Back to New Game Menu                   ***\n" +
                    "***************************************************************\n";

    public static ArrayList<LinkedHashMap<String, ArrayList<String>>> getRaces() {
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
        LinkedHashMap<String, ArrayList<String>> raceMenuMap = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<String>> extraOptions = new LinkedHashMap<>();
        ArrayList<LinkedHashMap<String, ArrayList<String>>> mapps = new ArrayList<>();
        int index = 1;
        ArrayList<String> col = new ArrayList<>(); col.add(human); raceMenuMap.put("" + index, col); index++;
        ArrayList<String> colB = new ArrayList<>(); colB.add(orc); raceMenuMap.put("" + index, colB); index++;
        ArrayList<String> colC = new ArrayList<>(); colC.add(elf); raceMenuMap.put("" + index, colC); index++;
        ArrayList<String> colD = new ArrayList<>(); colD.add(dwarf); raceMenuMap.put("" + index, colD); index++;
        ArrayList<String> colE = new ArrayList<>(); colE.add(claman); raceMenuMap.put("" + index, colE); index++;
        ArrayList<String> colF = new ArrayList<>(); colF.add(alien); raceMenuMap.put("" + index, colF);
        ArrayList<String> colG = new ArrayList<>(); colG.add("Return to Main Menu"); extraOptions.put("0", colG);
        ArrayList<String> colH = new ArrayList<>(); colH.add("Start Game"); extraOptions.put("9", colH);
        mapps.add(raceMenuMap);
        mapps.add(extraOptions);
        return mapps;
    }
    public static void loadRaceMenu() {
        String leftAlignFormat = "| %-2s | %-19s |\n";
        String headerFormat = "| %-24s |\n";
        String breakLine = "+----+---------------------+\n";
        String header = "Choose Village Race";
        chooseRace = StringHelpers.multiColumnMenu(leftAlignFormat, headerFormat, breakLine, header, getRaces());
    }

    public static LinkedHashMap<String, String> getTurns() {
        LinkedHashMap<String, String> a = new LinkedHashMap<>();
        Village v = Game.getVillage();
        a.put("Turn Number", "" + Game.getGameManager().getTurnNumber());
        a.put("Current Era", "" + TechTree.getCurrentEra().toString());
        a.put("Population", "" + Game.getVillage().getPopulation() + " / " + Game.getVillage().getPopCap());
        a.put("Village HP", "" + Game.getVillage().getHealth() + " / " + Game.getVillage().getMaxHP());
        a.put("Resources", "" + Game.getVillage().totalResources() + " / " + Game.getVillage().getResourceLimit());
        a.put("Buildings", "" + Game.getVillage().getBuildings().size() + " / " + Game.getVillage().getBuildingLimit());
        a.put("Food", "" + Game.getVillage().getFood() + " / " + Game.getVillage().getFoodLimit());
        a.put("Hunger", "" + Game.getVillage().getHunger() + " / " + 100);
        a.put("Coins", "" + Game.getVillage().getCoins() + " / " + Game.getVillage().getCoinLimit());
        a.put("Faith", "" + Game.getVillage().getFaith() + " / " + Game.getVillage().getFaithLimit());
        if (GameManager.getInstance().getRaidingCity() != null && !GameManager.getInstance().getRaidingCity().getDefeated()) {
            City raid = GameManager.getInstance().getRaidingCity();
            a.put("Raiding", "" + raid.cityName() + " [" + raid.getHp() + " / " + raid.getMaxHP() + "]");
        }
        return a;
    }
    public static LinkedHashMap<String, String> getTurnCommands() {
        LinkedHashMap<String, String> a = new LinkedHashMap<>();
        a.put("2", "Stats");
        a.put("3", "Board");
        a.put("4", "Resources");
        if (Game.getVillage().getInventory().inventorySize() > 0) {
            a.put("5", "Inventory");
        } else {
            a.put("5", "---------");
        }
        if (Game.getVillage().getBuildings().size() > 0) {
            a.put("6", "Buildings");
        } else {
            a.put("6", "---------");
        }
        if (Game.getVillage().getPopulation() > 0) {
            a.put("7", "Population");
        } else {
            a.put("7", "----------");
        }
        if (Game.getVillage().getVistingMerchants().size() > 0  && Game.getVillage().getVistingMerchants().get(0).getWares().size() > 0) {
            a.put("8", "Merchants");
        } else {
            a.put("8", "---------");
        }
        if (Game.canRaid()) {
            a.put("9", "Raid a New City");
        } else {
            a.put("9", "---------------");
        }
        int trainingCost = GameManager.getInstance().getTrainingCost();
        if (Game.getVillage().getCoins() >= trainingCost) {
            a.put("10", "Train (" +  trainingCost + " Coins)");
        } else {
            a.put("10", "------------------");
        }
        return a;
    }
    public static void loadTurnMenu() {
        String leftAlignFormat = "| %28s | %-75s |\n";
        String headerFormat = "| %-106s |\n";
        String breakLine = "+------------------------------+-----------------------------------------------------------------------------+\n";
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
        turnMenu = StringHelpers.twoColumnMenu(leftAlignFormat, headerFormat, breakLine, header, list);
    }

    public static LinkedHashMap<String, Integer> getPriorityValues() {
        ArrayList<main.enums.FoodOptions> optionEnums = main.enums.FoodOptions.getOptionsFromRace(Game.getPlayerRace());
        String food1Name = StringHelpers.capFirstLetter(optionEnums.get(0).writeInConsole().toLowerCase());
        String food2Name = StringHelpers.capFirstLetter(optionEnums.get(1).writeInConsole().toLowerCase());
        String food3Name = StringHelpers.capFirstLetter(optionEnums.get(2).writeInConsole().toLowerCase());
        Integer foodPriority1 = PriorityManager.getFood1();
        Integer foodPriority2 = PriorityManager.getFood2();
        Integer foodPriority3 = PriorityManager.getFood3();
        Integer prayPriority = PriorityManager.getPray();
        Integer foragePriority = PriorityManager.getForage();
        Integer woodcutPriority = PriorityManager.getWoodcut();
        Integer stonePickPriority = PriorityManager.getStone();
        Integer miningPriority = PriorityManager.getMine();
        Integer defendPriority = PriorityManager.getDefend();
        Integer harvestPriority = PriorityManager.getHarvest();
        Integer forgePriority = PriorityManager.getForge();
        Integer healPriority = PriorityManager.getHeal();
        Integer scoutPriority = PriorityManager.getScout();
        Integer plantPriority = PriorityManager.getPlant();
        Integer smithPriority = PriorityManager.getSmith();
        Integer smeltPriority = PriorityManager.getSmelt();
        Integer raidPriority = PriorityManager.getRaid();
        Integer engineerPriority = PriorityManager.getEngineer();
        Integer buildPriority = PriorityManager.getBuild();
        Integer tradePriority = PriorityManager.getTrade();
        Integer masonryPriority = PriorityManager.getMasonry();
        LinkedHashMap<String, Integer> priorities = new LinkedHashMap<>();
        priorities.put(food1Name, foodPriority1);
        priorities.put(food2Name, foodPriority2);
        priorities.put(food3Name, foodPriority3);
        priorities.put("Praying", prayPriority);
        priorities.put("Foraging", foragePriority);
        priorities.put("Woodcutting", woodcutPriority);
        priorities.put("Stone Picking", stonePickPriority);
        priorities.put("Mining", miningPriority);
        priorities.put("Defending", defendPriority);
        priorities.put("Harvesting", harvestPriority);
        priorities.put("Forging", forgePriority);
        priorities.put("Healing", healPriority);
        priorities.put("Exploring", scoutPriority);
        priorities.put("Planting", plantPriority);
        priorities.put("Smithing", smithPriority);
        priorities.put("Smelting", smeltPriority);
        priorities.put("Raiding", raidPriority);
        priorities.put("Engineering", engineerPriority);
        priorities.put("Building", buildPriority);
        priorities.put("Trading", tradePriority);
        priorities.put("Masonry", masonryPriority);
        return priorities;
    }
    public static LinkedHashMap<String, ArrayList<String>> getPriorities() {
        LinkedHashMap<String, Integer> priorityVals = getPriorityValues();
        LinkedHashMap<String, ArrayList<String>> a = new LinkedHashMap<>();
        int index = 1;
        for (Map.Entry<String, Integer> entry : priorityVals.entrySet()) {
            ArrayList<String> tempCols = new ArrayList<>();
            tempCols.add(entry.getKey());
            tempCols.add(""+ entry.getValue());
            a.put("" + index, tempCols);
            index++;
        }
        if (a.size() < 1) {
            ArrayList<String> tempCols = new ArrayList<>();
            tempCols.add("");
            tempCols.add("");
            a.put(" ", tempCols);
        }
        return a;
    }
    public static void loadPriorities() {
        String leftAlignFormat = "| %25s | %-35s | %-35s |\n";
        String headerFormat = "| %-101s |\n";
        String breakLine = "+---------------------------+-------------------------------------+-------------------------------------+\n";
        String header = "PRIORITY PHASE";
        LinkedHashMap<String, ArrayList<String>> points = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<String>> colHeads = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<String>> msg = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<String>> ret = new LinkedHashMap<>(); 
        ArrayList<String> pointCols = new ArrayList<>();
        pointCols.add("" + PriorityManager.getPointsRemaining());
        pointCols.add("" + PriorityManager.totalSpentPoints());
        ArrayList<String> colHeaders = new ArrayList<>();
        colHeaders.add("PRIORITY");
        colHeaders.add("POINTS");
        ArrayList<String> msgCols = new ArrayList<>();
        msgCols.add("options to put points into");
        msgCols.add("");
        ArrayList<String> retCols = new ArrayList<>();
        retCols.add("End Phase");
        retCols.add("");
        points.put("Points Remaining", pointCols);
        colHeads.put("COMMAND", colHeaders);
        msg.put("Choose any combination of", msgCols);
        ret.put("0", retCols);
        ArrayList<LinkedHashMap<String, ArrayList<String>>> list = new ArrayList<>();
        list.add(colHeads);
        list.add(getPriorities());
        list.add(points);
        //list.add(msg);
        list.add(ret);
        priorityMenu = StringHelpers.multiColumnMenu(leftAlignFormat, headerFormat, breakLine, header, list);
    }

    public static LinkedHashMap<String, String> getStats() {
        LinkedHashMap<String, String> rsrcMap = new LinkedHashMap<>();
        Village v = Game.getVillage();
        rsrcMap.put("Cities Defeated", "" + GameManager.getInstance().getDefeatedCities() + " / " + (GameManager.getInstance().getRaidable().size() + GameManager.getInstance().getDefeatedCities()));
        rsrcMap.put("Population", "" + v.getPopulation() + " / " + v.getPopCap());
        rsrcMap.put("Buildings", "" + v.getBuildings().size() + " / " + v.getBuildingLimit());
        rsrcMap.put("Total Village HP", "" + v.getHealth() + " / " + v.getMaxHP());
        rsrcMap.put("Attack", "" + v.getAttackPower());
        rsrcMap.put("Defense", "" + v.getDefense());
        rsrcMap.put("Agility", "" + v.getAgility());
        rsrcMap.put("Dexterity", "" + v.getDexterity());
        rsrcMap.put("Engineering", "" + v.getEngineering());
        rsrcMap.put("Intellect", "" + v.getIntelligence());
        rsrcMap.put("Magic", "" + v.getMagic());
        rsrcMap.put("Strength", "" + v.getStrength());
        if (v.getPopulation() > 0) {
            rsrcMap.put("Average Age", "" + v.getAgeAvg());
            rsrcMap.put("Average Agility", "" + v.getAgilityAvg());
            rsrcMap.put("Average Dexterity", "" + v.getDexterityAvg());
            rsrcMap.put("Average Engineering", "" + v.getEngineeringAvg());
            rsrcMap.put("Average Intellect", "" + v.getIntelligenceAvg());
            rsrcMap.put("Average Magic", "" + v.getMagicAvg());
            rsrcMap.put("Average Strength", "" + v.getStrengthAvg());
        }
        rsrcMap.put("Villagers Killed", "" + GameManager.getInstance().getVillagersKilled());
        rsrcMap.put("Enemies Killed", "" + GameManager.getInstance().getEnemiesKilled());
        return rsrcMap;
    }
    public static void loadStats() {
        String leftAlignFormat = "| %-25s | %-25s |\n";
        String headerFormat = "| %-53s |\n";
        String breakLine = "+---------------------------+---------------------------+\n";
        String header = "Village Stats";
        Map<String, String> bottom = new HashMap<>();
        bottom.put("0", "Return to Standby Menu");
        ArrayList<Map<String, String>> list = new ArrayList<>();
        list.add(getStats());
        list.add(bottom);
        stats = StringHelpers.twoColumnMenu(leftAlignFormat, headerFormat, breakLine, header, list);
    }
    
    public static LinkedHashMap<String, String> getResources() {
        LinkedHashMap<String, String> rsrcMap = new LinkedHashMap<>();
        Village v = Game.getVillage();
        rsrcMap.put("Coins", "" + v.getCoins() + " / " + v.getCoinLimit());
        rsrcMap.put("Food", "" + v.getFood() + " / " + v.getFoodLimit());
        rsrcMap.put("Faith", "" + v.getFaith() + " / " + v.getFaithLimit());
        Map<String, Integer> occ = new HashMap<>();
        ArrayList<AbstractResource> resources = v.getAllResources();
        Collections.sort(resources);
        for (AbstractResource resource : resources) {
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
    public static void loadResources() {
        String leftAlignFormat = "| %-25s | %-25s |\n";
        String headerFormat = "| %-53s |\n";
        String breakLine = "+---------------------------+---------------------------+\n";
        String header = "Resources";
        Map<String, String> bottom = new HashMap<>();
        bottom.put("0", "Return to Standby Menu");
        ArrayList<Map<String, String>> list = new ArrayList<>();
        list.add(getResources());
        list.add(bottom);
        resources = StringHelpers.twoColumnMenu(leftAlignFormat, headerFormat, breakLine, header, list);
    }

    public static LinkedHashMap<String, ArrayList<String>> getInventory() {
        LinkedHashMap<String, ArrayList<String>> a = new LinkedHashMap<>();
        Village v = Game.getVillage();
        for (Map.Entry<AbstractItem, Integer> entry : v.getInventory().getEntrySet()) {
            String name = entry.getKey().getName();
            String desc = entry.getKey().getDesc();
            if (desc.length() > 85) {
                desc = desc.substring(0, 86);
            }
            ArrayList<String> cols = new ArrayList<>();
            cols.add(""+entry.getValue());
            cols.add(entry.getKey().getType());
            cols.add(desc);
            a.put(name, cols);
        }
        if (a.size() < 1) {
            ArrayList<String> tempCols = new ArrayList<>();
            tempCols.add("");
            tempCols.add("");
            tempCols.add("");
            a.put(" ", tempCols);
        }
        return a;
    }
    public static void loadInventory() {
        String leftAlignFormat = "| %-25s | %-21s | %-21s | %-85s |\n";
        String headerFormat = "| %-161s |\n";
        String breakLine = "+---------------------------+-----------------------+-----------------------+---------------------------------------------------------------------------------------+\n";
        String header = "Inventory";
        LinkedHashMap<String, ArrayList<String>> top = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<String>> bottom = new LinkedHashMap<>();
        ArrayList<String> topCols = new ArrayList<>();
        ArrayList<String> botCols = new ArrayList<>();
        topCols.add("Amount"); botCols.add("Return");
        topCols.add("Type"); botCols.add("");
        topCols.add("Description"); botCols.add("Total Items: " + Game.getVillage().getInventory().inventorySize() + " / " + Game.getVillage().getInventory().getCapacity());
        top.put("Item Name", topCols);
        bottom.put("0", botCols);
        ArrayList<LinkedHashMap<String, ArrayList<String>>> list = new ArrayList<>();
        list.add(top);
        list.add(getInventory());
        list.add(bottom);
        inv = StringHelpers.multiColumnMenu(leftAlignFormat, headerFormat, breakLine, header, list);
    }

    public static LinkedHashMap<String, String> getBuildings() {
        LinkedHashMap<String, String> a = new LinkedHashMap<>();
        Village v = Game.getVillage();
        ArrayList<AbstractBuilding> buildings = v.getBuildings();
        Collections.sort(buildings);
        for (AbstractBuilding item : buildings){
            String name = item.getName();
            String desc = item.getDesc();
            if (desc.length() > 85) {
                desc = desc.substring(0, 86);
            }
            a.put(name, desc);
        }
        if (a.size() < 1) {
            a.put(" ", " ");
        }
        return a;
    }
    public static void loadBuildings() {
        String leftAlignFormat = "| %-25s | %-85s |\n";
        String headerFormat = "| %-113s |\n";
        String breakLine = "+---------------------------+---------------------------------------------------------------------------------------+\n";
        String header = "Buildings";
        Map<String, String> top = new HashMap<>();
        Map<String, String> bottom = new HashMap<>();
        top.put("Building", "Description");
        bottom.put("0", "Return to Standby Menu");
        ArrayList<Map<String, String>> list = new ArrayList<>();
        list.add(top);
        list.add(getBuildings());
        list.add(bottom);
        build = StringHelpers.twoColumnMenu(leftAlignFormat, headerFormat, breakLine, header, list);
    }

    public static LinkedHashMap<String, ArrayList<String>> getArchive() {
        LinkedHashMap<String, ArrayList<String>> a = new LinkedHashMap<>();
        ArrayList<GameObject> objs = Archive.getInstance().getArchive();
        Collections.sort(objs);
        for (GameObject obj : objs) {
            ArrayList<String> tempCols = new ArrayList<>();
            tempCols.add("" + obj.getType());
            String desc = obj.getDesc();
            if (desc.length() > 124) {
                desc = desc.substring(0, 125);
            }
            tempCols.add("" + desc);
            a.put(obj.getName(), tempCols);
        }
        if (a.size() < 1) {
            ArrayList<String> tempCols = new ArrayList<>();
            tempCols.add("");
            tempCols.add("");
            a.put(" ", tempCols);
        }
        return a;
    }
    public static void loadArchive() {
        String leftAlignFormat = "| %-25s | %-21s | %-125s |\n";
        String headerFormat = "| %-163s |\n";
        String breakLine = "+---------------------------+-----------------------+-------------------------------------------------------------------------------------------------------------------------------+\n";
        String header = "Archive";
        LinkedHashMap<String, ArrayList<String>> top = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<String>> bottom = new LinkedHashMap<>();
        ArrayList<String> topCols = new ArrayList<>();
        ArrayList<String> botCols = new ArrayList<>();
        topCols.add("TYPE"); botCols.add("Return to Main Menu");
        topCols.add("DESCRIPTION"); botCols.add("Game Objects: " + Archive.getInstance().getArchive().size());
        top.put("NAME", topCols);
        bottom.put("0", botCols);
        ArrayList<LinkedHashMap<String, ArrayList<String>>> list = new ArrayList<>();
        list.add(top);
        list.add(getArchive());
        list.add(bottom);
        archive = StringHelpers.multiColumnMenu(leftAlignFormat, headerFormat, breakLine, header, list);
    }
    
    public static LinkedHashMap<String, String> getBoard() {
        LinkedHashMap<String, String> a = new LinkedHashMap<>();
        Board board = Game.getGameBoard();
        for (Map.Entry<AbstractResource, Integer> item : board.getResources().entrySet()) {
            if (item.getValue() > 0) {
                String name = item.getKey().getName();
                a.put(name, "" + item.getValue());
            }
        }
        Map<String, Integer> an = new HashMap<>();
        for (AbstractAnimal item : board.getAnimals()) {
            if (an.containsKey(item.getName())) {
                an.put(item.getName(), an.get(item.getName()) + 1);
            } else {
                an.put(item.getName(), 1);
            }
        }
        for (Map.Entry<String, Integer> item : an.entrySet()) {
            a.put(item.getKey(), "" + item.getValue());
        }
        if (a.size() < 1) {
            a.put(" ", " ");
        }
        return a;
    }
    public static void loadBoard() {
        String leftAlignFormat = "| %-25s | %-35s |\n";
        String headerFormat = "| %-63s |\n";
        String breakLine = "+---------------------------+-------------------------------------+\n";
        String header = "Game Board [" + Game.getGameBoard().getGridXMax() + "x" + Game.getGameBoard().getGridYMax() + "]";
        Map<String, String> top = new HashMap<>();
        Map<String, String> bottom = new HashMap<>();
        top.put("Resource / Animal", "Amount");
        bottom.put("0", "Return to Standby Menu");
        ArrayList<Map<String, String>> list = new ArrayList<>();
        list.add(top);
        list.add(getBoard());
        list.add(bottom);
        board = StringHelpers.twoColumnMenu(leftAlignFormat, headerFormat, breakLine, header, list);
    }
    
    public static LinkedHashMap<String, ArrayList<String>> getVillagers() {
        LinkedHashMap<String, ArrayList<String>> a = new LinkedHashMap<>();
        Village v = Game.getVillage();
        for (Survivor s : v.getSurvivors()) {
            ArrayList<String> tempCols = new ArrayList<>();
            tempCols.add("" + s.getAge());
            tempCols.add("" + s.getHP() + " / " + s.getMaxHp());
            tempCols.add("" + s.getStrength());
            tempCols.add("" + s.getDexterity());
            tempCols.add("" + s.getIntelligence());
            tempCols.add("" + s.getAgility());
            tempCols.add("" + s.getMagic());
            tempCols.add("" + s.getEngineering());
            tempCols.add(StringHelpers.capFirstLetter(s.getRace().toString().toLowerCase()));
            tempCols.add(StringHelpers.capFirstLetter(s.getGender().toString().toLowerCase()));
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
    public static void loadVillagers() {
        String leftAlignFormat = "| %-52s | %-8s | %-18s | %-4s | %-4s | %-4s | %-4s | %-4s | %-4s | %-10s | %-10s |\n";
        String headerFormat = "| %-142s |\n";
        String breakLine = "+------------------------------------------------------+--------------------+----------+------+------+------+------+------+------+------------+------------+\n";
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
        vil = StringHelpers.multiColumnMenu(leftAlignFormat, headerFormat, breakLine, header, list);
    }
    
    public static LinkedHashMap<String, ArrayList<String>> getMerchant() {
        LinkedHashMap<String, ArrayList<String>> a = new LinkedHashMap<>();
        Village v = Game.getVillage();
        if (v.getVistingMerchants().size() > 0) {
            Merchant active = v.getVistingMerchants().get(0);
            for (Map.Entry<String, Integer> o : active.getWares().entrySet()) {
                GameObject obj = Archive.getInstance().get(o.getKey());
                boolean canBuy = true;
                if ((obj instanceof AbstractItem)) {
                    canBuy = Game.getVillage().getInventory().canAdd((AbstractItem) obj);
                }
                String type = Archive.getInstance().get(o.getKey()).getType();
                String cost = "" + o.getValue();
                String desc = Archive.getInstance().get(o.getKey()).getDesc();
                if (!canBuy) {
                    cost = "???";
                    desc = "???";
                }
                if (desc.length() > 124) {
                    desc = desc.substring(0, 125);
                }
                ArrayList<String> tempCols = new ArrayList<>();
                tempCols.add(cost);
                tempCols.add(type);
                tempCols.add(desc);
                String name = "Unusable Item";
                if (canBuy) {
                    name = "";
                    String[] spliceName = o.getKey().split(" ");
                    for (String s : spliceName) {
                        name += StringHelpers.capFirstLetter(s.toLowerCase()) + " ";
                    }
                }
                name = name.trim();
                a.put(name, tempCols);
            }
        }
        if (a.size() < 1) {
            ArrayList<String> tempCols = new ArrayList<>();
            tempCols.add("");
            tempCols.add("");
            tempCols.add("");
            a.put(" ", tempCols);
        }
        return a;
    }
    public static void loadMerchant() {
        String leftAlignFormat = "| %-25s | %-21s | %-21s | %-125s |\n";
        String headerFormat = "| %-201s |\n";
        String breakLine = "+---------------------------+-----------------------+-----------------------+-------------------------------------------------------------------------------------------------------------------------------+\n";
        String header = "Merchant";
        Village v = Game.getVillage();
        if (Game.getVillage().getVistingMerchants().size() > 0) {
            Merchant active = v.getVistingMerchants().get(0);
            header = active.getName() + "'s " + active.getMerchantType() + " Shop";
        }
        LinkedHashMap<String, ArrayList<String>> top = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<String>> bottom = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<String>> sellLine = new LinkedHashMap<>();
        ArrayList<String> topCols = new ArrayList<>();
        ArrayList<String> botCols = new ArrayList<>();
        ArrayList<String> sales = new ArrayList<>();
        topCols.add("Cost (Coins)"); botCols.add("Return"); sales.add("Sell");
        topCols.add("Type"); botCols.add("Coins: " + Game.getVillage().getCoins()); sales.add("");
        topCols.add("Description"); botCols.add(""); sales.add("");
        top.put("Item Name", topCols);
        bottom.put("0", botCols);
        sellLine.put("5", sales);
        ArrayList<LinkedHashMap<String, ArrayList<String>>> list = new ArrayList<>();
        list.add(top);
        list.add(getMerchant());
        list.add(bottom);
        list.add(sellLine);
        merchant = StringHelpers.multiColumnMenu(leftAlignFormat, headerFormat, breakLine, header, list);
    }

/*    public static LinkedHashMap<String, ArrayList<String>> getGrid() {
        LinkedHashMap<String, ArrayList<String>> a = new LinkedHashMap<>();
        for (int i = 0; i < Game.getGameBoard().getGridXMax(); i++) {
            if (i >= Game.getGameBoard().getNextX()) {
                String head = "";aaa
                ArrayList<String> nodes = new ArrayList<>();
                for (int k = 0; k < Game.getGameBoard().getGridYMax(); k++) {
                    AbstractNode curr = Game.getGameBoard().getNodeAt(i, k);
                    nodes.add(curr.getIcon());
                }
                a.put(head.getIcon(), nodes);
            } else {
                AbstractNode head = Game.getGameBoard().getNodeAt(i, 0);
                ArrayList<String> nodes = new ArrayList<>();
                for (int k = 0; k < Game.getGameBoard().getGridYMax(); k++) {
                    AbstractNode curr = Game.getGameBoard().getNodeAt(i, k);
                    nodes.add(curr.getIcon());
                }
                a.put(head.getIcon(), nodes);
            }
        }
        return a;
    }*/
    public static void loadGrid() {
        String leftAlignFormat = "| %-52s | %-8s |\n";
        String headerFormat = "| %-142s |\n";
        String breakLine = "+-++\n";
        String header = "Population";
        LinkedHashMap<String, ArrayList<String>> top = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<String>> bottom = new LinkedHashMap<>();
        ArrayList<String> topCols = new ArrayList<>();
        ArrayList<String> botCols = new ArrayList<>();
        topCols.add("COST (COINS)"); botCols.add("Return");
        topCols.add("TYPE"); botCols.add("Sell");
        top.put("NAME", topCols);
        bottom.put("0", botCols);
        ArrayList<LinkedHashMap<String, ArrayList<String>>> list = new ArrayList<>();
        list.add(top);
        list.add(getMerchant());
        list.add(bottom);
        merchant = StringHelpers.multiColumnMenu(leftAlignFormat, headerFormat, breakLine, header, list);
    }
    
    public static LinkedHashMap<String, ArrayList<String>> getSaleMerchant() {
        LinkedHashMap<String, ArrayList<String>> a = new LinkedHashMap<>();
        Village v = Game.getVillage();
        if (v.getInventory().inventorySize() > 0) {
            for (Map.Entry<AbstractItem, Integer> entry : v.getInventory().getEntrySet()) {
                AbstractItem item = entry.getKey();
                if (!(item instanceof AbstractArtifact) && entry.getValue() > 0) {
                    String type = item.getType();
                    String val = "" + v.getInventory().getItemValue(item);
                    String amt = "" + entry.getValue();
                    ArrayList<String> tempCols = new ArrayList<>();
                    tempCols.add(amt);
                    tempCols.add(val);
                    tempCols.add(type);
                    a.put(item.getName(), tempCols);
                }
            }
        }
        if (a.size() < 1) {
            ArrayList<String> tempCols = new ArrayList<>();
            tempCols.add("");
            tempCols.add("");
            tempCols.add("");
            a.put(" ", tempCols);
        }
        return a;
    }
    public static void loadSaleMerchant() {
        String leftAlignFormat = "| %-25s | %-21s | %-21s | %-21s |\n";
        String headerFormat = "| %-97s |\n";
        String breakLine = "+---------------------------+-----------------------+-----------------------+-----------------------+\n";
        String header = "Merchant - Sell Menu";
        Village v = Game.getVillage();
        if (Game.getVillage().getVistingMerchants().size() > 0) {
            Merchant active = v.getVistingMerchants().get(0);
            header = "Selling Items to " + active.getName() + "'s Shop";
        }
        LinkedHashMap<String, ArrayList<String>> top = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<String>> bottom = new LinkedHashMap<>();
        ArrayList<String> topCols = new ArrayList<>();
        ArrayList<String> botCols = new ArrayList<>();
        topCols.add("Held"); botCols.add("Return");
        topCols.add("Value"); botCols.add("");
        topCols.add("Type"); botCols.add("Coins: " + Game.getVillage().getCoins());
        top.put("Item Name", topCols);
        bottom.put("0", botCols);
        ArrayList<LinkedHashMap<String, ArrayList<String>>> list = new ArrayList<>();
        list.add(top);
        list.add(getSaleMerchant());
        list.add(bottom);
        saleMerchant = StringHelpers.multiColumnMenu(leftAlignFormat, headerFormat, breakLine, header, list);
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
        names.add("Raheel");
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
        names.add("Raheel");
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
        names.add("Raheel");
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
        names.add("Nicholas Cage (from Face Off)");
        names.add("Nicholas Cage (from National Treasure)");
        names.add("Nicholas Cage (from Leaving Las Vegas)");
        names.add("Nicholas Cage (from Mandy)");
        names.add("Nicholas Cage (from Gone in 60 Seconds)");
        names.add("Nicholas Cage (from Ghost Rider)");
        names.add("Nicholas Cage (from Raising Arizona)");
        names.add("Nicholas Cage (from Knowing)");
        names.add("Nicholas Cage (from Moonstruck)");
        names.add("Nicholas Cage (from Kick-Ass)");
        names.add("Nicholas Cage (from Adaptation)");
        names.add("Nicholas Cage (from The Family Man)");
        names.add("Nicholas Cage (from Wild at Heart)");
        names.add("Nicholas Cage (from Bad Lieutenant)");
        names.add("Nicholas Cage (from Lord of War)");
        names.add("Nicholas Cage (from Season of the Witch)");
        names.add("Nicholas Cage (from Vampire's Kiss)");
        names.add("Nicholas Cage (from Color Out of Space)");
        names.add("Nicholas Cage (from The Rock)");
        names.add("Nicholas Cage (from Drive Angry)");
        names.add("Nicholas Cage (from Left Behind)");
        names.add("Nicholas Cage (from The Wicker Man)");
        names.add("Nicholas Cage (from The Frozen Ground)");
        names.add("Nicholas Cage (from Next)");
        names.add("Nicholas Cage (from Matchstick Men)");
        names.add("Nicholas Cage (from 8mm)");
        names.add("Nicholas Cage (from Bangkok Dangerous)");
        names.add("Nicholas Cage (from The Weather Man)");
        names.add("Nicholas Cage (from Mom and Dad)");
        names.add("Nicholas Cage (from Snake Eyes)");
        names.add("Nicholas Cage (from Dying of the Light)");
        names.add("Nicholas Cage (from Outcast)");
        names.add("Nicholas Cage (from Birdy)");
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
        modifierMap.put(1, "Tougher enemies");
        modifierMap.put(2, "Slow resource gain");
        modifierMap.put(3, "More bad events");
        modifierMap.put(4, "Terrible disasters");
        modifierMap.put(5, "Handicap starting equipment");
        modifierMap.put(6, "More Netherworlds");
        modifierMap.put(7, "Tools are less effective");
        modifierMap.put(8, "Incredibly hostile enemies");
        modifierMap.put(9, "Limited Blueprint access");
        modifierMap.put(10, "Disable Trading");
        modifierMap.put(11, "Disable Magic");
        modifierMap.put(12, "Disable Aliens");
        modifierMap.put(13, "Disable Healing");
        modifierMap.put(14, "Disable Faith");
        modifierMap.put(15, "Disable ability to check surroundings");
    }

}
