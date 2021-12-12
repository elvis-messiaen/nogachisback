package fr.nogachi.services;

import fr.nogachi.entities.Utilisateur;
import fr.nogachi.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService implements fr.nogachi.services.impl.UtilisateurService {
    /**
     * instance de la méthode utilisateurRepository
     */
    private UtilisateurRepository utilisateurRepository;

    /**
     * constructeur du repository
     * @param utilisateurRepository
     */
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    /**
     * Transactional => verifie qu'il n'y a pas de problème lors de la transaction
     * si un probleme annule toute modification
     * @param utilisateur
     * @return sauvegarde de l'utilisateur
     */
    @Transactional
    public Utilisateur enregistrer(Utilisateur utilisateur) {

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
    public List<Utilisateur> lister() {

       return utilisateurRepository.findAll();
    }

    /**
     *  récuperer un utlisateur par son id
     * @param id
     * @return
     */
    @Transactional
    public Optional<Utilisateur> trouver(Long id) {

       return utilisateurRepository.findById(id);
    }
}
