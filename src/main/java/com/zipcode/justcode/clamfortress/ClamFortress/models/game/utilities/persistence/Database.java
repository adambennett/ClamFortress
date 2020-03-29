package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.stringUtils.*;
import com.zipcode.justcode.clamfortress.ClamFortress.services.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class Database implements CommandLineRunner {

    private static User currentUser;
    private static Game currentGame;

    public static void logInQuickplay() {
        StatTracker.clear();
    }


    public static Boolean logIn(String user, String pass) {
        for (User player : UserService.load()){
            if (player.getName().equals(user) && player.getPass().equals(pass)) {
                StatTracker.setStats(player.getStats());
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
            if (game.getId().equals(id) && game.getUser().getId().equals(currentUser.getId())) {
                return true;
            }
        }
        return false;
    }

    public static void registerUser(String user, String pass) {
        User newUser = new User(user, pass);
        currentUser = newUser;
        UserService.persist(newUser);
    }

    public static void registerGame(Game game) {
        currentGame = game;
    }

    public static void setGameForTests(Game game) {
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
            if (player.getId().equals(currentUser.getId())) {
                StatTracker.getUserStatBundle(player);
                boolean found = false;
                for (Game game : player.getSavedGames()) {
                    if (game.getId().equals(currentGame.getId())) {
                        game.setUser(player);
                        currentGame.refreshSavedGame(game);
                        found = true;
                    }
                }
                if (!found) {
                    currentGame.setUser(player);
                    currentGame.setId(getNextGameID());
                    player.addGame(currentGame);
                }
                UserService.persist(player);
                break;
            }
        }
    }

    public static Long getNextGameID() {
        Long index = 0L;
        for (Game g : GamesService.load()) {
            if (g.getId() > index) {
                index = g.getId();
            }
        }
        index++;
        return index;
    }

    public static User getPlayer() {
        if (currentUser != null && currentUser.getId() != null) {
            for (User user : UserService.load()) {
                if (user.getId().equals(currentUser.getId())) {
                    return user;
                }
            }
        }
        return currentUser;
    }

    public static Game getCurrentGame() {
        return currentGame;
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

    public static void setCurrentUser(User currentUser) {
        Database.currentUser = currentUser;
    }

    @Override
    public void run(String... args) {
        loadDatabase();
        saveNameToRandomNames(GameStrings.getAllRandomNames(true));
    }
}
