package fr.nogachi.services.impl;

import fr.nogachi.entities.User;
import fr.nogachi.repositories.UserRepository;
import fr.nogachi.services.UtilisateurService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImp implements UtilisateurService {
    /**
     * instance de la méthode utilisateurRepository
     */
    private UserRepository utilisateurRepository;

    /**
     * constructeur du repository
     * @param utilisateurRepository
     */
    public UtilisateurServiceImp(UserRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    /**
     * Transactional => verifie qu'il n'y a pas de problème lors de la transaction
     * si un probleme annule toute modification
     * @param utilisateur
     * @return sauvegarde de l'utilisateur
     */
    @Transactional
    public User enregistrer(User utilisateur) {

       return utilisateurRepository.save(utilisateur);
    }

    /**
     * supprime l'utilisateur par son id
     * @param id
     */
    @Transactional
    public void supprimer(Long id) {

       utilisateurRepository.deleteById(id);
    }

    /**
     * affiche une liste d'utilisateur
     * @return la listes des utilisateurs
     */
    @Transactional
    public List<User> lister() {

       return utilisateurRepository.findAll();
    }

    /**
     *  récuperer un utlisateur par son id
     * @param id
     * @return
     */
    @Transactional
    public Optional<User> trouver(Long id) {

       return utilisateurRepository.findById(id);
    }
}
