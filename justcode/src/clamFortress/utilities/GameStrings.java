package clamFortress.utilities;

import clamFortress.consoleIO.*;
import clamFortress.enums.*;
import clamFortress.game.*;
import clamFortress.game.logic.*;
import clamFortress.utilities.persistence.*;

import java.util.*;
import java.util.concurrent.*;

public class GameStrings {

    static {
        chooseRace = "";
        turnMenu = "";
        priorityMenu = "";
    }

    private static String chooseRace;
    private static String turnMenu;
    private static String priorityMenu;
    private static String endPhase;
    private static String resources;

    private static final String openingBlurb = "Blah blah help your guys survive and thrive... watch out for cLAmS";

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

    public static void loadRaceMenu() {
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
    }

    public static void loadTurnMenu() {
        String endString = "***";
        String lenCheck = "************************************************************";
        String otherlen = "*******************************";
        String mana = "" + Game.getVillage().getMana();
        String faith = "" + Game.getVillage().getFaith();
        String coins = "" + Game.getVillage().getCoins();
        String stone = "" + Game.getVillage().getStone();
        String wood = "" + Game.getVillage().getWood();
        String hunger = "" + Game.getVillage().getHunger();
        String famine = "" + Game.getVillage().getFamine();
        String population = "" + Game.getVillage().getPopulation() + " / " + Game.getVillage().getPopCap();
        String turnNumber = "" + Game.getGameManager().getTurnNumber();
        String date = "***  " + Game.getGameManager().getDateString() + " :: ";
        String season = Game.getGameManager().getSeason();
        String fullDate = date + season;
        String surroundings = "***                1 | View Board                           ***\n";
        if (AbstractConsole.getCurrentGame() != null && !Game.getSurroundingCheckEnabled()) {
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
        hunger = format(hunger, otherlen, endString);
        famine = format(famine, otherlen, endString);
        turnMenu =
                        "***************************************************************\n" +
                        "***                      STANDBY PHASE                      ***\n" +
                        "***************************************************************\n" +
                        fullDate +
                        "***           Turn Number :: " + turnNumber +
                        "***            Population :: " + population +
                        "***                  Wood :: " + wood +
                        "***                 Stone :: " + stone +
                        "***                 Coins :: " + coins +
                        "***                 Faith :: " + faith +
                        "***                  Mana :: " + mana +
                        "***                Hunger :: " + hunger +
                        "***                Famine :: " + famine +
                        "***---------------------------------------------------------***\n" +
                        surroundings +
                        "***                2 | View All Village Stats               ***\n" +
                        "***                3 | View Inventory                       ***\n" +
                        "***                4 | View Buildings                       ***\n" +
                        "***                5 | View Population                      ***\n" +
                        "***                6 | Fight Plagues                        ***\n" +
                        "***                7 | Mitigate Disasters                   ***\n" +
                        "***                8 | Trade with Merchants                 ***\n" +
                        "***                9 | Miracles                             ***\n" +
                        "***               10 | Start Raid                           ***\n" +
                        "***               11 | Interact with Aliens                 ***\n" +
                        "***               12 | Train (200 Coins)                    ***\n" +
                        "***---------------------------------------------------------***\n" +
                        "***                0 | Priorities Phase                     ***\n" +
                        "***---------------------------------------------------------***\n" +
                        "***             Skip | Skip turn                            ***\n" +
                        "***              End | End Game                             ***\n" +
                        "***             Save | Save & Continue                      ***\n" +
                        "***             Exit | Save & Quit                          ***\n" +
                        "***************************************************************\n";
    }

    public static void loadPriorityMenu() {
        String food1Name = "***             1 | ";
        String food2Name = "***             2 | ";
        String food3Name = "***             3 | ";
        ArrayList<FoodOptions> optionEnums = FoodOptions.getOptionsFromRace(Game.getPlayerRace());
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
        String points = format("(" + PriorityManager.getPointsRemaining() + ")" , lenB, ending);
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
                "***             Global Score: 99999999999999999999999                                            ***\n" +
                "***             Time Elapsed: 99 days                                                            ***\n" +
                "*** Resources Gained (99999): Stone(120), Faith(60), Rocks(120), Gold(600)                       ***\n" +
                "***      New Survivors (999): Sauron, Scuba Steve, Jeremy, Adam, Rick, James, Matt Perry, ...    ***\n" +
                "***          New Regions (3): Grasslands (1), Sea (2)                                            ***\n" +
                "***                                                                                              ***\n" +
                "***----------------------------------------------------------------------------------------------***\n" +
                "***                                          0 | Standby Phase                                   ***\n" +
                "****************************************************************************************************\n";
    }

    public static void loadResources() {
        resources =
                "*************************************************\n" +
                "***-------------------------------------------***\n" +
                "*** VILLAGE STATS                             ***\n" +
                "***-------------------------------------------***\n" +
                "***   Population        | 30 / 10000          ***\n" +
                "***   Buildings         | 10 / 2000           ***\n" +
                "***   Attack            | 100                 ***\n" +
                "***   Defense           | 200                 ***\n" +
                "***   Agility           | 49                  ***\n" +
                "***   Dexterity         | 38                  ***\n" +
                "***   Engineering       | 27                  ***\n" +
                "***   Intellect         | 16                  ***\n" +
                "***   Magic             | 12                  ***\n" +
                "***   Strength          | 11                  ***\n" +
                "***-------------------------------------------***\n" +
                "*** BASE STATS                                ***\n" +
                "***-------------------------------------------***\n" +
                "***   Base Agility      | 49                  ***\n" +
                "***   Base Dexterity    | 38                  ***\n" +
                "***   Base Engineering  | 33                  ***\n" +
                "***   Base Intellect    | 40                  ***\n" +
                "***   Base Magic        | 39                  ***\n" +
                "***   Base Strength     | 42                  ***\n" +
                "***   Total Village HP  | 127                 ***\n" +
                "***-------------------------------------------***\n" +
                "*** AVERAGES                                  ***\n" +
                "***-------------------------------------------***\n" +
                "***   Avg. Age          | 26                  ***\n" +
                "***   Avg. Agility      | 1.63                ***\n" +
                "***   Avg. Dexterity    | 1.27                ***\n" +
                "***   Avg. Engineering  | 1.10                ***\n" +
                "***   Avg. HP           | 4.23                ***\n" +
                "***   Avg. Intellect    | 1.33                ***\n" +
                "***   Avg. Magic        | 1.30                ***\n" +
                "***   Avg. Strength     | 1.40                ***\n" +
                "***-------------------------------------------***\n" +
                "*** RESOURCES                                 ***\n" +
                "***-------------------------------------------***\n" +
                "***   Wood              | 100                 ***\n" +
                "***   Art               | 6                   ***\n" +
                "***   Brick             | 25                  ***\n" +
                "***   Clay              | 1134                ***\n" +
                "***   Coins             | 67                  ***\n" +
                "***   Copper Ore        | 111                 ***\n" +
                "***   Faith             | 267                 ***\n" +
                "***   Flowers           | 25                  ***\n" +
                "***   Glass             | 12                  ***\n" +
                "***   Gold Ore          | 8                   ***\n" +
                "***   Iron Ore          | 22                  ***\n" +
                "***   Jewelery          | 14                  ***\n" +
                "***   Lumber            | 876                 ***\n" +
                "***   Rock              | 230                 ***\n" +
                "***   Sand              | 2467                ***\n" +
                "***   Seeds             | 178                 ***\n" +
                "***   Spacegoo          | 0                   ***\n" +
                "***   Stone             | 1000                ***\n" +
                "***-------------------------------------------***\n" +
                "***                   0 | Standby Menu        ***\n" +
                "*************************************************\n";
    }

    public static String getStringFromPromptType(PromptMessage msg) {
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
        }
        return "";
    }

    public static String getRandomName() {
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
        names.add("Stacey");
        names.add("Stella");
        names.add("Steve-O");
        names.add("Stuart");
        names.add("Susan");
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
        return names.get(ThreadLocalRandom.current().nextInt(names.size()));
    }

}
