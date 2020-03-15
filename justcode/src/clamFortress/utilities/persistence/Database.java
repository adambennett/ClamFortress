package clamFortress.utilities.persistence;

public class Database {

    private static Integer playerScore;
    private static Boolean dwarvesUnlocked;
    private static Boolean elvesUnlocked;
    private static Boolean aliensUnlocked;
    private static Boolean clamanUnlocked;
    private static Boolean orcsUnlocked;

    public static void loadDatabase() {}

    public static void saveDatabase() {}

    public static void score(Integer amt) {
        Database.playerScore += amt;
        if ( Database.playerScore < 0) {  Database.playerScore = 0; }
    }

    public static Integer getPlayerScore() {
        return  Database.playerScore;
    }

    public static void setPlayerScore(Integer playerScore) {
        Database.playerScore = playerScore;
        if (playerScore < 0) { playerScore = 0; }
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
        return  Database.orcsUnlocked;
    }

    public static void setOrcsUnlocked(Boolean orcsUnlocked) {
        Database.orcsUnlocked = orcsUnlocked;
    }
}
