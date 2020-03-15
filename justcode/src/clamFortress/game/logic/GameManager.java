package clamFortress.game.logic;

import java.math.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;

public class GameManager {

    private BigInteger turnNumber;
    private BigInteger wood;
    private BigInteger stone;
    private BigInteger coins;
    private BigInteger faith;
    private BigInteger mana;
    private BigInteger population;
    private BigInteger popCap;
    private Date date;
    private String season;
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
        this.wood = BigInteger.valueOf(0);
        this.stone = BigInteger.valueOf(0);
        this.coins = BigInteger.valueOf(0);
        this.faith = BigInteger.valueOf(0);
        this.mana = BigInteger.valueOf(0);
        this.population = BigInteger.valueOf(0);
        this.popCap = BigInteger.valueOf(0);
        this.date = new Date();
        updateSeason();
    }

    public static GameManager getInstance() {
        return instance;
    }

    public static void reset() {
        instance.turnNumber = BigInteger.valueOf(1);
        instance.wood = BigInteger.valueOf(0);
        instance.stone = BigInteger.valueOf(0);
        instance.coins = BigInteger.valueOf(0);
        instance.faith = BigInteger.valueOf(0);
        instance.mana = BigInteger.valueOf(0);
        instance.population = BigInteger.valueOf(0);
        instance.popCap = BigInteger.valueOf(0);
        instance.date = new Date();
        instance.updateSeason();
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

    public void incDateByMonth() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.date);
        c.add(Calendar.MONTH, 1);
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

    public void incWood() {
        incWood(1);
    }

    public void incWood(int amt) {
        this.wood = this.wood.add(BigInteger.valueOf(amt));
    }

    public void subWood(int amt) {
        this.wood = this.wood.subtract(BigInteger.valueOf(amt));
    }

    public void incStone() {
        incStone(1);
    }

    public void incStone(int amt) {
        this.stone = this.stone.add(BigInteger.valueOf(amt));
    }

    public void subStone(int amt) {
        this.stone = this.stone.subtract(BigInteger.valueOf(amt));
    }

    public void incFaith() {
        incFaith(1);
    }

    public void incFaith(int amt) {
        this.faith = this.faith.add(BigInteger.valueOf(amt));
    }

    public void subFaith(int amt) {
        this.faith = this.faith.subtract(BigInteger.valueOf(amt));
    }

    public void incMana() {
        incMana(1);
    }

    public void incMana(int amt) {
        this.mana = this.mana.add(BigInteger.valueOf(amt));
    }

    public void subMana(int amt) {
        this.mana = this.mana.subtract(BigInteger.valueOf(amt));
    }

    public void incCoins() {
        incCoins(1);
    }

    public void incCoins(int amt) {
        this.coins = this.coins.add(BigInteger.valueOf(amt));
    }

    public void subCoins(int amt) {
        this.coins = this.coins.subtract(BigInteger.valueOf(amt));
    }

    public Boolean incPop() {
        return incPop(1);
    }

    public Boolean incPop(int amt) {
        BigInteger orig = this.population;
        this.population = this.population.add(BigInteger.valueOf(amt));
        if (this.population.compareTo(this.popCap) > 0) {
            this.population = this.popCap;
        }
        return !orig.equals(this.population);
    }

    public void subPop(int amt) {
        this.population = this.population.subtract(BigInteger.valueOf(amt));
    }

    public void incPopCap() {
        incPopCap(1);
    }

    public void incPopCap(int amt) {
        this.popCap = this.popCap.add(BigInteger.valueOf(amt));
    }

    public void subPopCap(int amt) {
        this.popCap = this.popCap.subtract(BigInteger.valueOf(amt));
    }


    public BigInteger getTurnNumber() {
        return turnNumber;
    }

    public BigInteger getWood() {
        return wood;
    }

    public BigInteger getStone() {
        return stone;
    }

    public BigInteger getCoins() {
        return coins;
    }

    public BigInteger getFaith() {
        return faith;
    }

    public BigInteger getMana() {
        return mana;
    }

    public BigInteger getPopulation() {
        return population;
    }

    public BigInteger getPopCap() {
        return popCap;
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
}
