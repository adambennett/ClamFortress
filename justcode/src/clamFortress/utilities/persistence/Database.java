package clamFortress.utilities.persistence;

public class Database {

    private static Integer playerScore = 0;
    private static Boolean dwarvesUnlocked = false;
    private static Boolean elvesUnlocked = false;
    private static Boolean aliensUnlocked = false;
    private static Boolean clamanUnlocked = false;
    private static Boolean orcsUnlocked = false;

    public static void updateUnlocks() {
        if (playerScore > 500) {
            aliensUnlocked = true;
        }

        if (playerScore > 400) {
            clamanUnlocked = true;
        }

        if (playerScore > 300) {
            dwarvesUnlocked = true;
        }

        if (playerScore > 200) {
            elvesUnlocked = true;
        }

        if (playerScore > 100) {
            orcsUnlocked = true;
        }
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
        if ( Database.playerScore < 0) {  Database.playerScore = 0; }
    }

    public static Integer getPlayerScore() {
        return  Database.playerScore;
    }

    public static void setPlayerScore(Integer playerScore) {
        Database.playerScore = playerScore;
        if (playerScore < 0) { Database.playerScore = 0; }
    }

    public static Boolean getDwarvesUnlocked() {
        return  Database.dwarvesUnlocked;
    }

    public static void setDwarvesUnlocked(Boolean dwarvesUnlocked) {
        Database.dwarvesUnlocked = dwarvesUnlocked;
    }

    public static Boolean getElvesUnlocked() {
        return  Database.elvesUnlocked;
    }

    public static void setElvesUnlocked(Boolean elvesUnlocked) {
        Database.elvesUnlocked = elvesUnlocked;
    }

    public static Boolean getAliensUnlocked() {
        return  Database.aliensUnlocked;
    }

    public static void setAliensUnlocked(Boolean aliensUnlocked) {
        Database.aliensUnlocked = aliensUnlocked;
    }

    public static Boolean getClamanUnlocked() {
        return  Database.clamanUnlocked;
    }

    public static void setClamanUnlocked(Boolean clamanUnlocked) {
        Database.clamanUnlocked = clamanUnlocked;
    }

    public static Boolean getOrcsUnlocked() {
        return Database.orcsUnlocked;
    }

    public static void setOrcsUnlocked(Boolean orcsUnlocked) {
        Database.orcsUnlocked = orcsUnlocked;
    }
}
