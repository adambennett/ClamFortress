package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.builders.*;

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
    private static Integer highCoins;
    private static Integer highRes;
    private static Integer highPop;
    private static Integer highBuild;


    static {
        enemiesKilled= 0;
        villagersLost= 0;
        daysSurvived= 0;
        overallScore= 0;
        highCoins = 0;
        highRes = 0;
        highPop = 0;
        highBuild = 0;
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

    public static void getUserStatBundle(User user) {
        user.getStats().setDaysSurvived(daysSurvived);
        user.getStats().setEnemiesKilled(enemiesKilled);
        user.getStats().setVillagersLost(villagersLost);
        user.getStats().setOverallScore(overallScore);
        user.getStats().setHighestBuildings(highBuild);
        user.getStats().setHighestCoins(highCoins);
        user.getStats().setHighestPopulation(highPop);
        user.getStats().setHighestResources(highRes);
    }

    public static void setStats(UserStats statBundle) {
        enemiesKilled = statBundle.getEnemiesKilled();
        villagersLost = statBundle.getVillagersLost();
        daysSurvived = statBundle.getDaysSurvived();
        overallScore = statBundle.getOverallScore();
        highBuild = statBundle.getHighestBuildings();
        highCoins = statBundle.getHighestCoins();
        highPop = statBundle.getHighestPopulation();
        highRes = statBundle.getHighestResources();
    }

    public static void clear() {
        enemiesKilled = 0;
        villagersLost = 0;
        daysSurvived = 0;
        overallScore = 0;
        highCoins = 0;
        highPop = 0;
        highBuild = 0;
        highRes = 0;
    }

    // Incrementation
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

    // Getters
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
    public static Integer getHighCoins() { return highCoins; }
    public static Integer getHighRes() { return highRes; }
    public static Integer getHighPop() { return highPop; }
    public static Integer getHighBuild() { return highBuild; }
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

    // Setters


    public static void setHighCoins(Integer highCoins) {
        if (highCoins > StatTracker.highCoins) {
            StatTracker.highCoins = highCoins;
        }
    }

    public static void setHighRes(Integer highRes) {
        if (highRes > StatTracker.highRes) {
            StatTracker.highRes = highRes;
        }
    }

    public static void setHighPop(Integer highPop) {
        if (highPop > StatTracker.highPop) {
            StatTracker.highPop = highPop;
        }
    }

    public static void setHighBuild(Integer highBuild) {
        if (highBuild > StatTracker.highBuild) {
            StatTracker.highBuild = highBuild;
        }
    }
}
