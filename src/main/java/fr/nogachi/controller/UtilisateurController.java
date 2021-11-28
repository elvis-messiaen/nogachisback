package fr.nogachi.controller;

import fr.nogachi.entity.Utilisateur;
import fr.nogachi.repository.UtilisateurRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Meddiaen elvis
 */

@RestController
public class UtilisateurController {

    // @Autowired => depreceted  !! ceci est deprecated
    private UtilisateurRepository utilisateurRepository;

    // instancie à la demande un utilisateur repository
    public UtilisateurController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    // affiche la list des utilisateurs check
    @GetMapping(path = "/utilisateur")
    public List<Utilisateur> ListUtilisateur() {
        return utilisateurRepository.findAll();
    }

    // recherche un utilisateur par id check
    @GetMapping(path = "/utilisateur/{id}")
    public Utilisateur afficherUnUtilisateur(@PathVariable Long id) {

        return utilisateurRepository.findById(id).get();
    }

    //ajouter un utilisateur check
    @PostMapping(path = "/utilisateur")
    public Utilisateur ajouter (@RequestBody Utilisateur utilisateur) {
        return  utilisateurRepository.save(utilisateur);
    }

    // mise a jour de l'utilisateur check
    @PutMapping(path = "/utilisateur/{id}")
    public Utilisateur miseAJour (@PathVariable Long id, @RequestBody Utilisateur utilisateur){
        utilisateur.setId(id);
        return utilisateurRepository.save(utilisateur);
    }

    //sippprimer un utilisateur
    @DeleteMapping(path = "/utilisateur/{id}")
    public void supprimerUtilisateur (@PathVariable Long id){
        utilisateurRepository.deleteById(id);
    }
}
