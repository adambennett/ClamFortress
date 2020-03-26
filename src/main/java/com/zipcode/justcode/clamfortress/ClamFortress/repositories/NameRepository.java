package com.zipcode.justcode.clamfortress.ClamFortress.repositories;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface NameRepository extends JpaRepository<Name, Long> {

}
