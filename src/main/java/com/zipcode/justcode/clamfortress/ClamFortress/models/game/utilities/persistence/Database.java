package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.stringUtils.*;
import com.zipcode.justcode.clamfortress.ClamFortress.services.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class Database implements CommandLineRunner {


    private static String loginUser;
    private static Long loginGame;
    private static User currentUser;
    private static Game currentGame;

    public static void logInQuickplay() {
        StatTracker.clear();
    }


    public static Boolean logIn(String user, String pass) {
        for (User player : UserService.load()){
            if (player.getName().equals(user) && player.getPass().equals(pass)) {
                StatTracker.setStats(player.getStats());
                loginUser = user;
                currentUser = player;
                return true;
            }
        }
        return false;
    }

    public static Boolean isUser(String user) {
        for (User player : UserService.load()){
            if (player.getName().equals(user)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean isGame(Long id) {
        for (Game game : GamesService.load()){
            if (game.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static void registerUser(String user, String pass) {
        User newUser = new User(user, pass);
        loginUser = user;
        currentUser = newUser;
        UserService.persist(newUser);
    }

    public static void registerGame(Game game) {
        for (User player : UserService.load()) {
            if (player.getName().equals(loginUser)) {
                game.setUser(player);
                player.addGame(game);
                UserService.persist(player);
            }
        }
        currentGame = game;
    }

    public static Game setCurrentGame(Long id) {
        for (Game game : GamesService.load()) {
            if (game.getId().equals(id)) {
                currentGame = game;
                return game;
            }
        }
        return null;
    }

    public static void loadDatabase() {
        GameStrings.loadNames();
        StatTracker.updateUnlocks();
    }

    public static void saveDatabase() {
        for (User player : UserService.load()) {
            if (player.equals(getPlayer())) {
                StatTracker.getUserStatBundle(player);
                UserService.persist(player);
                break;
            }
        }

        for (Game game : GamesService.load()) {
            if (game.getId().equals(loginGame)) {
                GamesService.persist(game);
            }
        }
    }

    public static User getPlayer() {
        return currentUser;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static Game getDBGame() {
        for (Game game : GamesService.load()) {
            if (game.getId().equals(loginGame)) {
                return game;
            }
        }
        return null;
    }

    public static List<Game> getGames() {
        return GamesService.load();
    }

    public static List<User> getUsers() {
        return UserService.load();
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
       loadDatabase();
       saveNameToRandomNames(GameStrings.getAllRandomNames(true));
    }
}
