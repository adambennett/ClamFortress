package main.utilities.persistence;

import java.util.*;

public class Database {

    private static Integer playerScore = 0;
    private static Boolean dwarvesUnlocked = false;
    private static Boolean elvesUnlocked = false;
    private static Boolean aliensUnlocked = false;
    private static Boolean clamanUnlocked = false;
    private static Boolean orcsUnlocked = false;
    private static ArrayList<User> users = new ArrayList<>();

    public static void updateUnlocks() {
        if (playerScore > 50000) { aliensUnlocked  = true; }
        if (playerScore > 10000) { clamanUnlocked  = true; }
        if (playerScore > 4000)  { dwarvesUnlocked = true; }
        if (playerScore > 1000)  { elvesUnlocked   = true; }
        if (playerScore > 500)   { orcsUnlocked   = true;  }
    }

    public static void logInQuickplay() {

    }

    public static Boolean logIn(String user, String pass) {
        for (User player : users){
            if (player.getName().equals(user) && player.getPass().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean isUser(String user) {
        for (User player : users){
            if (player.getName().equals(user)) {
                return true;
            }
        }
        return false;
    }

    public static void register(String user, String pass) {
        users.add(new User(user, pass));
    }

    public static void loadDatabase() {
        // load score from file
        updateUnlocks();
    }

    public static void saveDatabase() {
        // write score and saved games to file
    }

    public static void score(Integer amt) {
        Database.playerScore += amt;
        if (Database.playerScore < 0) {
            Database.playerScore = 0;
        }
        updateUnlocks();
    }

    public static Integer getPlayerScore() {
        return Database.playerScore;
    }
    public static Boolean getDwarvesUnlocked() {
        return Database.dwarvesUnlocked;
    }
    public static Boolean getElvesUnlocked() {
        return Database.elvesUnlocked;
    }
    public static Boolean getAliensUnlocked() {
        return Database.aliensUnlocked;
    }
    public static Boolean getClamanUnlocked() {
        return Database.clamanUnlocked;
    }
    public static Boolean getOrcsUnlocked() {
        return Database.orcsUnlocked;
    }

}
