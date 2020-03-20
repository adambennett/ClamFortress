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
    private Date date;
    private String season;
    private City raidingCity;
    private static final GameManager instance;
    private static final String[] seasons = {
            "Winter", "Winter", "Spring", "Spring", "Summer", "Summer",
            "Summer", "Summer", "Fall", "Fall", "Winter", "Winter"
    };

    static {
        try { instance = new GameManager(); }
        catch (Exception e) { throw new RuntimeException("Error occured while initializing GameManager"); }
    }

    private GameManager() {
        this.turnNumber = BigInteger.valueOf(1);
        this.trainingCost = 200;
        this.date = new Date();
        this.techLevel = 0;
        this.techUp = 1000;
        this.techMod = 2;
        this.nethermod = 1;
        updateSeason();
    }

    public void setTrainingCost(int newCost) {
        this.trainingCost = newCost;
        if (this.trainingCost < 0) {
            this.trainingCost = 0;
        }
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
                Database.score(amt);
            }
        } else {
            OutputManager.exp(amt);
            Database.score(amt);
        }
    }

    public City getRaidingCity() {
        return raidingCity;
    }

    public Integer getNethermod() {
        return nethermod;
    }

    public Integer getTechLevel() {
        return techLevel;
    }

    public Integer getTechUp() {
        return techUp;
    }

    public Integer getTechMod() {
        return techMod;
    }

    public void setTechLevel(Integer techLevel) {
        this.techLevel = techLevel;
    }

    public void setTechUp(Integer techUp) {
        this.techUp = techUp;
    }

    public void setTechMod(Integer techMod) {
        this.techMod = techMod;
    }

    public static GameManager getInstance() {
        return instance;
    }

    public static void reset() {
        instance.turnNumber = BigInteger.valueOf(1);
        instance.date = new Date();
        instance.trainingCost = 200;
        instance.techLevel = 0;
        instance.updateSeason();
        instance.techUp = 500;
        instance.techMod = 2;
        instance.nethermod = 1;
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
        return (int)diff;
    }

    public void incTurns() {
        incTurns(1);
    }

    public void incTurns(int amt) {
        this.turnNumber = this.turnNumber.add(BigInteger.valueOf(amt));
    }


    public BigInteger getTurnNumber() {
        return turnNumber;
    }
    public Date getDate() {
        return date;
    }
    public String getDateString() {
        return date.toString();
    }
    public String getSeason() {
        updateSeason();
        return season;
    }

    public Integer getTrainingCost() {
        return this.trainingCost;
    }
}
