package fr.nogachi.repositories;

import fr.nogachi.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author Messiaen ELVIS
 */

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findById(int id);

    public Utilisateur save(Utilisateur utilisateur);
}
