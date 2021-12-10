package fr.nogachi.controllers;

import fr.nogachi.entities.Utilisateur;
import fr.nogachi.services.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Messiaen elvis
 */

@RestController
public class UtilisateurController {


    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    UtilisateurService utilisateurService;

    /**
     *   instancie à la demande un utilisateur repository
     *   POSTMAN: OK
     *   TEST : (OK/FAIL/WIP)
     */

    /**
     * affiche la list des utilisateurs
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     */
    @GetMapping(path = "/utilisateur")
    public List<Utilisateur> ListUtilisateur() {
        return utilisateurService.lister();

    }

    /**
     * recherche un utilisateur par id
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     *
     * @return
     */
    @GetMapping(path = "/utilisateur/{id}")
    public Optional<Utilisateur> afficherUnUtilisateur(@PathVariable Long id) {
        return utilisateurService.trouver(id);
    }

    /**
     * ajouter un utilisateur
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     */
    @PostMapping(path = "/utilisateur")
    public Utilisateur ajouter(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.enregistrer(utilisateur);
    }

    /**
     * mise a jour de l'utilisateur
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     */
    @PutMapping(path = "/utilisateur/{id}")
    public Utilisateur miseAJour(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        utilisateur.setId(id);
        return utilisateurService.enregistrer(utilisateur);
    }

    /**
     * suppprimer un utilisateur
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     */
    @DeleteMapping(path = "/utilisateur/{id}")
    public void supprimerUtilisateur(@PathVariable Long id) {
        utilisateurService.supprimer(id);
    }
}
