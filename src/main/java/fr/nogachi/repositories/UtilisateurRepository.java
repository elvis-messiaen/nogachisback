package fr.nogachi.repositories;

import fr.nogachi.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Messiaen ELVIS
 */

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {


}
