package com.zipcode.justcode.clamfortress.ClamFortress.services;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Service
public class GamesService {

    private static GamesRepository gamesRepository;

    @Autowired
    public GamesService(GamesRepository gameRepo) {
        gamesRepository = gameRepo;
    }

    public static void persist(Game game) {
        gamesRepository.saveAndFlush(game);
    }

    public static List<Game> load() {
        return gamesRepository.findAll();
    }

    public static void saveAll(List<Game> games) {
        gamesRepository.saveAll(games);
    }

    public static void flush() { gamesRepository.flush(); }

    public static Optional<Game> findById(Long id) {
        return gamesRepository.findById(id);
    }

}
