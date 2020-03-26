package com.zipcode.justcode.clamfortress.ClamFortress.services;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import com.zipcode.justcode.clamfortress.ClamFortress.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;


@Service
public class GamesService {

    private static GamesRepository gamesRepository;

    @Autowired
    public GamesService(GamesRepository gameRepo) {
        gamesRepository = gameRepo;
    }

    public static void persist(User game) {
        gamesRepository.saveAndFlush(game);
    }

    public static List<User> load() {
        return gamesRepository.findAll();
    }

    public static void saveAll(List<User> games) {
        gamesRepository.saveAll(games);
    }

    public static void flush() { gamesRepository.flush(); }

}
