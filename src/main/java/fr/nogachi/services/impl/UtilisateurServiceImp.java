package fr.nogachi.services.impl;

import fr.nogachi.entities.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurServiceImp {

    Utilisateur enregistrer(Utilisateur utilisateur);

    void supprimer(Long id);

    List<Utilisateur> lister();

    Optional<Utilisateur> trouver(Long id);

}
