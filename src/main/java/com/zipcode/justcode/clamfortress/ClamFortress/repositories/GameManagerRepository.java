package com.zipcode.justcode.clamfortress.ClamFortress.repositories;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface GameManagerRepository extends JpaRepository<GameManager, Long> {

}
