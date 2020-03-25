package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class Database implements CommandLineRunner {


    private static final ArrayList<User> users = new ArrayList<>();
    private static final ArrayList<Game> games = new ArrayList<>();
    private static User player;
    private static Game currentGame;

    @Autowired
    private UserService controller;

    public static void logInQuickplay() {
        player = new User("Quickplayer", "");
        StatTracker.clear();
    }

    public void loadGame(Game game) {
        currentGame = game;
    }

    public static Boolean logIn(String user, String pass) {
        for (User player : users){
            if (player.getName().equals(user) && player.getPass().equals(pass)) {
                Database.player = player;
                StatTracker.setStats(Database.player.getStats());
                return true;
            }
        }
        return false;
    }

    public static Boolean isUser(String user) {
        for (User player : users){
            if (player.getName().equals(user)) {
                return true;
            }
        }
        return false;
    }


    public static void register(String user, String pass) {
        User newUser = new User(user, pass);
        users.add(newUser);
       // controller.insert(newUser);
    }

    public static void loadDatabase() {
        // load DB files
        // add each loaded user to list of users
        // add each loaded game to list of games
        StatTracker.updateUnlocks();
    }

    public static void saveDatabase() {
        for (User player : users) {
            if (player.equals(Database.player)) {
                player.setStats(StatTracker.getUserStatBundle());
                Database.player.setStats(StatTracker.getUserStatBundle());
            }
        }
        // write users and games to DB
    }

    public static User getPlayer() {
        return player;
    }

    public static ArrayList<Game> getGames() {
        return games;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public void run(String... args) throws Exception {
        /*User admin = new User("Adam", "pass");
        controller.insert(admin);*/
    }
}
