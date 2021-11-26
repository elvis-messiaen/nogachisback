package fr.nogachi.repository;

import fr.nogachi.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findById(int id);

    Utilisateur save(Utilisateur utilisateur);

    void deleteUtilisateur(Long id);
}
