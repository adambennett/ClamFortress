package main.utilities.persistence;

import main.utilities.builders.*;

public class StatTracker {

    private static Boolean dwarvesUnlocked;
    private static Boolean elvesUnlocked;
    private static Boolean aliensUnlocked;
    private static Boolean clamanUnlocked;
    private static Boolean orcsUnlocked;
    private static Integer enemiesKilled;
    private static Integer villagersLost;
    private static Integer daysSurvived;
    private static Integer overallScore;
    
    static {
        enemiesKilled= 0;
        villagersLost= 0;
        daysSurvived= 0;
        overallScore= 0;
        dwarvesUnlocked = false;
        elvesUnlocked = false;
        aliensUnlocked = false;
        clamanUnlocked = false;
        orcsUnlocked = false;
    }

    public static void updateUnlocks() {
        if (StatTracker.getOverallScore() > 50000) { aliensUnlocked  = true; }
        if (StatTracker.getOverallScore() > 10000) { clamanUnlocked  = true; }
        if (StatTracker.getOverallScore() > 4000)  { dwarvesUnlocked = true; }
        if (StatTracker.getOverallScore() > 1000)  { elvesUnlocked   = true; }
        if (StatTracker.getOverallScore() > 500)   { orcsUnlocked   = true;  }
    }

    public static UserStats getUserStatBundle() {
        return new StatBuilder()
                .setDaysSurvived(daysSurvived)
                .setEnemiesKilled(enemiesKilled)
                .setVillagersLost(villagersLost)
                .setOverallScore(overallScore)
                .createUserStats();
    }

    public static void setStats(UserStats statBundle) {
        enemiesKilled = statBundle.getEnemiesKilled();
        villagersLost = statBundle.getVillagersLost();
        daysSurvived = statBundle.getDaysSurvived();
        overallScore = statBundle.getOverallScore();
    }

    public static void clear() {
        enemiesKilled = 0;
        villagersLost = 0;
        daysSurvived = 0;
        overallScore = 0;
    }

    public static void incEnemies(int enemies) {
        enemiesKilled += enemies;
    }

    public static void incVillagers(int villagers) {
        villagersLost += villagers;
    }

    public static void incDays(int days) {
        daysSurvived += days;
    }

    public static void incScore(int score) {
        overallScore += score;
    }

    public static Integer getEnemiesKilled() {
        return enemiesKilled;
    }

    public static Integer getVillagersLost() {
        return villagersLost;
    }

    public static Integer getDaysSurvived() {
        return daysSurvived;
    }

    public static Integer getOverallScore() {
        return overallScore;
    }

    public static Boolean getDwarvesUnlocked() {
        return dwarvesUnlocked;
    }

    public static Boolean getElvesUnlocked() {
        return elvesUnlocked;
    }

    public static Boolean getAliensUnlocked() {
        return aliensUnlocked;
    }

    public static Boolean getClamanUnlocked() {
        return clamanUnlocked;
    }

    public static Boolean getOrcsUnlocked() {
        return orcsUnlocked;
    }
}
