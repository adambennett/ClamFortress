package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.stringUtils.*;
import com.zipcode.justcode.clamfortress.ClamFortress.services.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class Database implements CommandLineRunner {


    private static final ArrayList<User> users = new ArrayList<>();
    private static final ArrayList<Game> games = new ArrayList<>();
    private static User player;
    private static Game currentGame;

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


    public static void registerUser(String user, String pass) {
        User newUser = new User(user, pass);
        users.add(newUser);
        try {
            UserService.persist(newUser);
        } catch (Exception ignored) {}
    }

    public static void registerGame(Game game) {
        games.add(game);
        //GamesService.insert(game);
    }

    public static void loadDatabase() {
        GameStrings.loadNames();
        users.addAll(UserService.load());
        // games.addAll(GamesService.load());
        StatTracker.updateUnlocks();
    }

    public static void saveDatabase() {
        for (User player : users) {
            if (player.equals(Database.player)) {
                try {
                    UserService.flush();
                } catch (Exception ignored) {}
                StatTracker.getUserStatBundle(player);
                StatTracker.getUserStatBundle(Database.player);
                try {
                    UserService.persist(player);
                } catch (Exception ignored) {}
                break;
            }
        }
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

    public static void saveNameToRandomNames(ArrayList<String> stringsToInsert) {
        Set<String> checkedIn = new HashSet<>();
        for (Name name : NameService.load()) {
            checkedIn.add(name.getName());
        }
        for (String s : stringsToInsert) {
            if (!checkedIn.contains(s)) {
                Name name = new Name();
                name.setName(s);
                NameService.persist(name);
                checkedIn.add(s);
            }
        }
    }

    @Override
    public void run(String... args) {
        try {
            loadDatabase();
            saveNameToRandomNames(GameStrings.getAllRandomNames(true));
        } catch (Exception ignored) {}
    }
}
