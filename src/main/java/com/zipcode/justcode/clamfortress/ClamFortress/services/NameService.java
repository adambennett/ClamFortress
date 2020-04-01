package com.zipcode.justcode.clamfortress.ClamFortress.services;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import com.zipcode.justcode.clamfortress.ClamFortress.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import java.util.*;


@Service
public class NameService {

    private static NameRepository nameRepository;

    @Autowired
    public NameService(NameRepository nameRepo) {
        nameRepository = nameRepo;
    }

    public static void persist(Name name) {
        nameRepository.saveAndFlush(name);
    }

    public static List<Name> load() {
        return nameRepository.findAll();
    }

    public static void saveAll(List<Name> names) {
        nameRepository.saveAll(names);
    }

    public static void flush() { nameRepository.flush(); }

    public static Page<Name> findAll(Pageable pageable) { return nameRepository.findAll(pageable); }

}
