package com.zipcode.justcode.clamfortress.ClamFortress.controllers;

import com.zipcode.justcode.clamfortress.ClamFortress.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value="/all")
    public @ResponseBody List<Car> findAll(){
        return carService.findAll();
    }

    @GetMapping(value = "/make")
    public @ResponseBody
    List<Car> findMake(@RequestParam String make) {

        return carService.findByMake(make);
    }

}
