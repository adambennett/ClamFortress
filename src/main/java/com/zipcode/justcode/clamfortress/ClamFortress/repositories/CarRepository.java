package com.zipcode.justcode.clamfortress.ClamFortress.repositories;

import com.zipcode.justcode.clamfortress.ClamFortress.models.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import java.util.*;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAll();

    List<Car> findByMake(String make);

}
