package main.utilities.stringUtils;

import java.util.*;

public class StringHelpers {

    public static Boolean startsWithVowel(String word) {
        return isVowel(word.charAt(0));
    }

    private static Boolean isVowel(Character character) {
        return (character != null) && GameStrings.vowels.contains(character);
    }

    public static String capFirstLetter(String s) {
        String color = s.toLowerCase();
        color = s.toLowerCase().substring(0, 1).toUpperCase() + color.substring(1);
        return color;
    }

    public static void reloadStrings() {
        GameStrings.loadArchive();
        GameStrings.loadPriorities();
        GameStrings.loadRaceMenu();
        GameStrings.loadTurnMenu();
        GameStrings.loadEndPhase();
        GameStrings.loadStats();
        GameStrings.loadInventory();
        GameStrings.loadVillagers();
        GameStrings.loadBoard();
        GameStrings.loadBuildings();
        GameStrings.loadResources();
        GameStrings.loadMerchant();
        GameStrings.loadSaleMerchant();
    }

    public static String getStringFromPromptType(main.enums.PromptMessage msg) {
        switch (msg) {
            case DEV_CONSOLE:
            case ARCHIVE:
                GameStrings.loadArchive();
                return GameStrings.archive;
            case BIOME_MENU:
                return GameStrings.chooseBiome;
            case CUSTOM_DIFF_MENU:
                return GameStrings.customDifficulty;
            case DIFF_MENU:
                return GameStrings.chooseDifficulty;
            case MAIN_MENU:
                return GameStrings.mainMenu;
            case BLURB:
                return GameStrings.openingBlurb;
            case PRIORITY_MENU:
                GameStrings.loadPriorities();
                return GameStrings.priorityMenu;
            case RACE_MENU:
                GameStrings.loadRaceMenu();
                return GameStrings.chooseRace;
            case TURN_MENU:
                GameStrings.loadTurnMenu();
                return GameStrings.turnMenu;
            case END_PHASE:
                GameStrings.loadEndPhase();
                return GameStrings.endPhase;
            case STAT_VIEW:
                GameStrings.loadStats();
                return GameStrings.stats;
            case INVENTORY_VIEW:
                GameStrings.loadInventory();
                return GameStrings.inv;
            case VILLAGERS:
                GameStrings.loadVillagers();
                return GameStrings.vil;
            case POP_SETUP:
                return GameStrings.pop;
            case GAME_BOARD:
                GameStrings.loadBoard();
                return GameStrings.board;
            case BOARD_SIZE:
                return GameStrings.boardSize;
            case NEW_GAME_HUB:
                return GameStrings.newGameHub;
            case LOGIN:
                return GameStrings.loginScreen;
            case START_ERA:
                return GameStrings.startEra;
            case BUILDINGS:
                GameStrings.loadBuildings();
                return GameStrings.build;
            case RESOURCE_VIEW:
                GameStrings.loadResources();
                return GameStrings.resources;
            case MERCHANT:
                GameStrings.loadMerchant();
                return GameStrings.merchant;
            case TRAINING:
                return GameStrings.train;
            case SALE_MERCHANT:
                GameStrings.loadSaleMerchant();
                return GameStrings.saleMerchant;
        }
        return "";
    }

    public static String twoColumnMenu(String leftAlignFormat, String headerFormat, String breakLine, String header, ArrayList<Map<String, String>> commandToLabelMapList) {
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

    public static String multiColumnMenu(String leftAlignFormat, String headerFormat, String breakLine, String header, ArrayList<LinkedHashMap<String, ArrayList<String>>> commandToLabelMapList) {
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
}
