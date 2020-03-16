package clamFortress.game.logic;

import clamFortress.actions.*;

import java.math.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;

public class GameManager {

    private BigInteger turnNumber;
    private Integer wood;
    private Integer stone;
    private Integer coins;
    private Integer faith;
    private Integer mana;
    private Integer population;
    private Integer popCap;
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
        this.date = new Date();
        updateSeason();
    }

    public static GameManager getInstance() {
        return instance;
    }

    public static void reset() {
        instance.turnNumber = BigInteger.valueOf(1);
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
}
