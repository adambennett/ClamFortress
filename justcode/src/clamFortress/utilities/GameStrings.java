package clamFortress.utilities;

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


    private static void loadStrings() {
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

        openingBlurb = "Blah blah help your guys survive and thrive... watch out for CLams";

        GameManager game = GameManager.getInstance();
        String endString = "***\n";
        String lenCheck = "************************************************************";
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
        ArrayList<String> toFormat = new ArrayList<>();
        String surroundings = "***                1 | Surrounding Region Report            ***\n";
        // TODO: Check Game for allow surroundings check
        toFormat.add(mana);
        toFormat.add(faith);
        toFormat.add(coins);
        toFormat.add(stone);
        toFormat.add(wood);
        toFormat.add(population);
        toFormat.add(turnNumber);
        toFormat.add(fullDate);
        for (String s : toFormat) {
            while (s.length() < lenCheck.length()) {
                s += " ";
            }
            s += endString;
        }
        turnMenu =
                "***************************************************************\n" +
                toFormat.get(7) +
                "***           Turn Number :: " + toFormat.get(6) +
                "***            Population :: " + toFormat.get(5) +
                "***                  Wood :: " + toFormat.get(4) +
                "***                 Stone :: " + toFormat.get(3) +
                "***                 Coins :: " + toFormat.get(2) +
                "***                 Faith :: " + toFormat.get(1) +
                "***                  Mana :: " + toFormat.get(0) +
                "***---------------------------------------------------------***\n" +
                surroundings +
                "***                2 | Village Resources                    ***\n" +
                "***                3 | Village Inventory                    ***\n" +
                "***                4 | Buildings                            ***\n" +
                "***                5 | Inspect Villagers                    ***\n" +
                "***                6 | Upgrades                             ***\n" +
                "***---------------------------------------------------------***\n" +
                "***                0 | Continue to Priorities Menu          ***\n" +
                "***************************************************************\n";
    }

    public static String getStringFromPromptType(/*TODO: add enum parameter*/) {
        loadStrings();
        // switch on parameter to return proper string
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
