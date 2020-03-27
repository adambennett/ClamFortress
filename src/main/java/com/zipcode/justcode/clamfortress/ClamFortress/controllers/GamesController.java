package com.zipcode.justcode.clamfortress.ClamFortress.controllers;

import com.zipcode.justcode.clamfortress.ClamFortress.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class GamesController {

    private GamesService gamesService;

    @Autowired
    public GamesController(GamesService gamesService) {
        this.gamesService = gamesService;
    }

}
