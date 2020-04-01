package com.zipcode.justcode.clamfortress.ClamFortress.controllers;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import com.zipcode.justcode.clamfortress.ClamFortress.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.*;

import java.net.*;
import java.util.*;

@RestController
public class NameController {

    private NameService serv;

    @Autowired
    public NameController(NameService serv) {
        this.serv = serv;
    }

    @GetMapping("/names")
    public List<Name> getAllNames()
    {
        return NameService.load();
    }

    @PostMapping("/names/{name}")
    public ResponseEntity<?> putName(@PathVariable String name) {
        Name newName = new Name();
        newName.setName(name);
        NameService.persist(newName);
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{name}")
                .buildAndExpand(newName.getId())
                .toUri();
        return new ResponseEntity<>(newPollUri, HttpStatus.CREATED);
    }

}
