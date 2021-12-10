package fr.nogachi.services;

import fr.nogachi.entities.Utilisateur;
import fr.nogachi.repositories.UtilisateurRepository;
import fr.nogachi.services.impl.UtilisateurServiceImp;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class UtilisateurService implements UtilisateurServiceImp {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

   @Transactional
    public Utilisateur enregistrer(Utilisateur utilisateur) {
       return utilisateurRepository.save(utilisateur);
    }

    @Transactional
    public void supprimer(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Transactional
    public List<Utilisateur> lister() {
        return utilisateurRepository.findAll();
    }

    @Transactional
    public Optional<Utilisateur> trouver(Long id) {
        return utilisateurRepository.findById(id);
    }
}
