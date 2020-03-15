package clamFortress.utilities;

import clamFortress.consoleIO.*;
import clamFortress.enums.*;
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


    private static String format(String s, String lenCheck, String endString) {
        while (s.length() < lenCheck.length()) {
            s += " ";
        }
        s += endString + "\n";
        return s;
    }

    private static void loadStrings() {
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

        priorityMenu = "";

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

        GameManager game = GameManager.getInstance();
        String endString = "***";
        String lenCheck = "************************************************************";
        String otherlen = "*******************************";
        String mana = "" + game.getMana();
        String faith = "" + game.getFaith();
        String coins = "" + game.getCoins();
        String stone = "" + game.getStone();
        String wood = "" + game.getWood();
        String population = "" + game.getPopulation() + " / " + game.getPopCap();
        String turnNumber = "" + game.getTurnNumber();
        String date = "***  " + game.getDateString() + " :: ";
        String season = game.getSeason();
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
                "***                6 | Upgrades                             ***\n" +
                "***---------------------------------------------------------***\n" +
                "***                0 | Continue to Priorities Menu          ***\n" +
                "***---------------------------------------------------------***\n" +
                "***             Skip | Skip turn                            ***\n" +
                "***              End | End Game                             ***\n" +
                "***             Exit | Save & Quit                          ***\n" +
                "***************************************************************\n";
    }

    public static String getStringFromPromptType(PromptMessage msg) {
        loadStrings();
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
