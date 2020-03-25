package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.builders;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class StatBuilder {
    private Integer enemiesKilled = 0;
    private Integer villagersLost = 0;
    private Integer daysSurvived = 0;
    private Integer overallScore = 0;
    private Integer highestCoins = 0;
    private Integer highestResources = 0;
    private Integer highestBuildings = 0;
    private Integer highestPopulation = 0;

    public StatBuilder setEnemiesKilled(Integer enemiesKilled) {
        this.enemiesKilled = enemiesKilled;
        return this;
    }

    public StatBuilder setVillagersLost(Integer villagersLost) {
        this.villagersLost = villagersLost;
        return this;
    }

    public StatBuilder setDaysSurvived(Integer daysSurvived) {
        this.daysSurvived = daysSurvived;
        return this;
    }

    public StatBuilder setOverallScore(Integer overallScore) {
        this.overallScore = overallScore;
        return this;
    }

    public StatBuilder setHighestCoins(Integer highestCoins) {
        this.highestCoins = highestCoins;
        return this;
    }

    public StatBuilder setHighestResources(Integer highestResources) {
        this.highestResources = highestResources;
        return this;
    }

    public StatBuilder setHighestBuildings(Integer highestBuildings) {
        this.highestBuildings = highestBuildings;
        return this;
    }

    public StatBuilder setHighestPopulation(Integer highestPopulation) {
        this.highestPopulation = highestPopulation;
        return this;
    }

    public UserStats createUserStats() {
        return new UserStats(enemiesKilled, villagersLost, daysSurvived, overallScore, highestCoins, highestResources, highestBuildings, highestPopulation);
    }
}