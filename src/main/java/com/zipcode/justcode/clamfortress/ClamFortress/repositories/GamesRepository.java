package com.zipcode.justcode.clamfortress.ClamFortress.repositories;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface GamesRepository extends JpaRepository<Game, Long> {

}
