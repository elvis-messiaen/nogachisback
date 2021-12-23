package fr.nogachi.services;

import fr.nogachi.entities.User;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    User enregistrer(User utilisateur);

    void supprimer(Long id);

    List<User> lister();

    Optional<User> trouver(Long id);

}
