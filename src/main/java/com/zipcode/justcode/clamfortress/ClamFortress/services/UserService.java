package com.zipcode.justcode.clamfortress.ClamFortress.services;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import com.zipcode.justcode.clamfortress.ClamFortress.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Service
public class UserService {

    private static UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepo) {
        userRepository = userRepo;
    }

    public static void persist(User user) {
        userRepository.saveAndFlush(user);
    }

    public static List<User> load() {
        return userRepository.findAll();
    }

    public static void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }

    public static void flush() { userRepository.flush(); }



}
