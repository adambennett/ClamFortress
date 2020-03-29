package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import javax.persistence.*;
import java.math.*;
import java.util.*;
import java.util.concurrent.*;

@Entity
public class GameManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @MapsId
    private Game game;

    private Integer techLevel;
    private Integer techUp;
    private Integer techMod;
    private Integer nethermod;
    private BigInteger turnNumber;
    private Integer trainingCost;
    private Integer defeatedCities;
    private Integer merchantItems;
    private Date date;
    private String season;
    public Boolean gameIsLoaded;

    @Transient
    private City raidingCity;

    @Transient
    private ArrayList<City> raidable;

    private static final String[] seasons = {
            "Winter", "Winter", "Spring", "Spring", "Summer", "Summer",
            "Summer", "Summer", "Fall", "Fall", "Winter", "Winter"
    };

    public GameManager() {
        this.turnNumber = BigInteger.valueOf(1);
        this.trainingCost = 200;
        this.techLevel = 0;
        this.techUp = 1000;
        this.techMod = 2;
        this.nethermod = 1;
        this.defeatedCities = 0;
        this.merchantItems = 9;
        this.date = new Date();
        this.raidable = new ArrayList<>();
        updateSeason();
    }

    public void refreshGameManager(GameManager manager) {
        manager.setNethermod(this.nethermod);
        manager.setDate(this.date);
        manager.setRaidingCity(this.raidingCity);
        manager.setMerchantItems(this.merchantItems);
        manager.setDefeatedCities(this.defeatedCities);
        manager.setTrainingCost(this.trainingCost);
        manager.setGameIsLoaded(this.gameIsLoaded);
        manager.setSeason(this.season);
        manager.setTechLevel(this.techLevel);
        manager.setTechMod(this.techMod);
        manager.setTechUp(this.techUp);
        manager.setTurnNumber(this.turnNumber);
    }

    public void setTrainingCost(int newCost) {
        this.trainingCost = newCost;
        if (this.trainingCost < 0) {
            this.trainingCost = 0;
        }
    }

    public void setMerchantItems(Integer merchantItems) {
        this.merchantItems = merchantItems;
    }

    public void setDefeatedCities(Integer defeatedCities) {
        this.defeatedCities = defeatedCities;
    }

    public void setRaidingCity(City city) {
        this.raidingCity = city;
    }

    public void setNethermod(Integer nethermod) {
        this.nethermod = nethermod;
    }

    public void gainExperience() {
        gainExperience(ThreadLocalRandom.current().nextInt(0, 5));
    }

    public void gainExperience(int amt) {
        if (!TechTree.getCurrentEra().equals(TechTree.getTail())) {
            this.techLevel += amt;
            if (this.techLevel > this.techUp) {
                GameUtils.advanceEra();
                this.techLevel = 0;
                this.techUp *= this.techMod;
                this.techMod += ThreadLocalRandom.current().nextInt(1, 5);
            } else if (amt > 0) {
                OutputManager.exp(amt);
                StatTracker.incScore(amt);
            }
        } else {
            OutputManager.exp(amt);
            StatTracker.incScore(amt);
        }
    }

    public Integer getMerchantItems() {
        return merchantItems;
    }

    public City getRaidingCity() {
        return raidingCity;
    }

    public Integer getNethermod() {
        return nethermod;
    }

    private void updateSeason() {
        this.season = seasons[this.date.getMonth()];
    }

    public void incDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.date);
        c.add(Calendar.DATE, 1);
        this.date = c.getTime();
    }

    public Integer advanceDate(int minDays, int maxDays) {
        Date originalDate = this.date;
        Date newDate = this.date;
        Calendar calendar = Calendar.getInstance();
        long diffMilli = Math.abs(newDate.getTime() - originalDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffMilli, TimeUnit.MILLISECONDS);
        while (diff < minDays) {
            int randHour = ThreadLocalRandom.current().nextInt(1, 24);
            int randDay = ThreadLocalRandom.current().nextInt(1, 12);
            int randMinutes = ThreadLocalRandom.current().nextInt(1, 61);
            int randSecs = ThreadLocalRandom.current().nextInt(1, 61);
            int randMilli = ThreadLocalRandom.current().nextInt(1, 1001);
            calendar.setTime(newDate);
            calendar.add(Calendar.DAY_OF_WEEK, randDay);
            calendar.add(Calendar.HOUR, randHour);
            calendar.add(Calendar.MINUTE, randMinutes);
            calendar.add(Calendar.SECOND, randSecs);
            calendar.add(Calendar.MILLISECOND, randMilli);
            newDate = calendar.getTime();
            diffMilli = Math.abs(newDate.getTime() - originalDate.getTime());
            diff = TimeUnit.DAYS.convert(diffMilli, TimeUnit.MILLISECONDS);
            if (diff > maxDays) {
                calendar.setTime(this.date);
            }
            newDate = calendar.getTime();
            diffMilli = Math.abs(newDate.getTime() - originalDate.getTime());
            diff = TimeUnit.DAYS.convert(diffMilli, TimeUnit.MILLISECONDS);
        }
        this.date = newDate;
        StatTracker.incDays((int)diff);
        return (int)diff;
    }

    public void incTurns() {
        incTurns(1);
    }
    public void incTurns(int amt) {
        this.turnNumber = this.turnNumber.add(BigInteger.valueOf(amt));
    }
    public Integer getDefeatedCities() {
        return defeatedCities;
    }
    public ArrayList<City> getRaidable() {
        return raidable;
    }
    public BigInteger getTurnNumber() {
        return turnNumber;
    }
    public Date getDate() {
        return date;
    }
    public String getDateString() { return date.toString(); }
    public Integer getTrainingCost() { return this.trainingCost; }
    public String getSeason() {
        updateSeason();
        return season;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Integer getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(Integer techLevel) {
        this.techLevel = techLevel;
    }

    public Integer getTechUp() {
        return techUp;
    }

    public void setTechUp(Integer techUp) {
        this.techUp = techUp;
    }

    public Integer getTechMod() {
        return techMod;
    }

    public void setTechMod(Integer techMod) {
        this.techMod = techMod;
    }

    public void setTurnNumber(BigInteger turnNumber) {
        this.turnNumber = turnNumber;
    }

    public void setTrainingCost(Integer trainingCost) {
        this.trainingCost = trainingCost;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setRaidable(ArrayList<City> raidable) {
        this.raidable = raidable;
    }

    public Boolean getGameIsLoaded() {
        return gameIsLoaded;
    }

    public void setGameIsLoaded(Boolean gameIsLoaded) {
        this.gameIsLoaded = gameIsLoaded;
    }

    public static String[] getSeasons() {
        return seasons;
    }
}
