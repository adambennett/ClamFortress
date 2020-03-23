package main.models.managers;

import main.models.nodes.*;
import main.models.tech.*;
import main.utilities.*;
import main.utilities.persistence.*;

import java.math.*;
import java.util.*;
import java.util.concurrent.*;

public class GameManager {

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
    private City raidingCity;
    private ArrayList<City> raidable;
    public static Boolean gameIsLoaded;
    private static final GameManager instance;
    private static final String[] seasons = {
            "Winter", "Winter", "Spring", "Spring", "Summer", "Summer",
            "Summer", "Summer", "Fall", "Fall", "Winter", "Winter"
    };

    static {
        try { instance = new GameManager(); gameIsLoaded = false; }
        catch (Exception e) { throw new RuntimeException("Error occured while initializing GameManager"); }
    }

    private GameManager() {
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

    public static void reset() {
        gameIsLoaded = false;
        instance.raidingCity = null;
        instance.turnNumber = BigInteger.valueOf(1);
        instance.trainingCost = 200;
        instance.techLevel = 0;
        instance.techUp = 500;
        instance.techMod = 2;
        instance.nethermod = 1;
        instance.defeatedCities = 0;
        instance.merchantItems = 9;
        instance.date = new Date();
        instance.raidable = new ArrayList<>();
        instance.updateSeason();
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

    public static GameManager getInstance() {
        return instance;
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
}
