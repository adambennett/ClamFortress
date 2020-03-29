package com.zipcode.justcode.clamfortress.ClamFortress.services;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import com.zipcode.justcode.clamfortress.ClamFortress.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;


@Service
public class GameManagerService {

    private static GameManagerRepository gamesRepository;

    @Autowired
    public GameManagerService(GameManagerRepository gameRepo) {
        gamesRepository = gameRepo;
    }

    public static void persist(GameManager game) {
        gamesRepository.saveAndFlush(game);
    }

    public static List<GameManager> load() {
        return gamesRepository.findAll();
    }

    public static void saveAll(List<GameManager> games) {
        gamesRepository.saveAll(games);
    }

    public static void flush() { gamesRepository.flush(); }

    public static Optional<GameManager> findById(Long id) {
        return gamesRepository.findById(id);
    }

}
