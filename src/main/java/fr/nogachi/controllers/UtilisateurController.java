package fr.nogachi.controllers;

import fr.nogachi.entities.Utilisateur;
import fr.nogachi.repositories.UtilisateurRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Messiaen elvis
 */

@RestController
public class UtilisateurController {

    private UtilisateurRepository utilisateurRepository;
    
    /**
     *   instancie à la demande un utilisateur repository
     *   POSTMAN: OK
     *   TEST : (OK/FAIL/WIP)
     */
    public UtilisateurController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    /**
     *   affiche la list des utilisateurs
     *   POSTMAN: OK
     *   TEST : (OK/FAIL/WIP)
     */
    @GetMapping(path = "/utilisateur")
    public List<Utilisateur> ListUtilisateur() {
        return utilisateurRepository.findAll();
    }

    /**
     *   recherche un utilisateur par id
     *   POSTMAN: OK
     *   TEST : (OK/FAIL/WIP)
     */
    @GetMapping(path = "/utilisateur/{id}")
    public Utilisateur afficherUnUtilisateur(@PathVariable Long id) {

        return utilisateurRepository.findById(id).get();
    }

    /**
     *   ajouter un utilisateur
     *   POSTMAN: OK
     *   TEST : (OK/FAIL/WIP)
     */
    @PostMapping(path = "/utilisateur")
    public Utilisateur ajouter (@RequestBody Utilisateur utilisateur) {
        return  utilisateurRepository.save(utilisateur);
    }

    /**
     *   mise a jour de l'utilisateur
     *   POSTMAN: OK
     *   TEST : (OK/FAIL/WIP)
     */
    @PutMapping(path = "/utilisateur/{id}")
    public Utilisateur miseAJour (@PathVariable Long id, @RequestBody Utilisateur utilisateur){
        utilisateur.setId(id);
        return utilisateurRepository.save(utilisateur);
    }

    /**
     *   suppprimer un utilisateur
     *   POSTMAN: OK
     *   TEST : (OK/FAIL/WIP)
     */
    @DeleteMapping(path = "/utilisateur/{id}")
    public void supprimerUtilisateur (@PathVariable Long id){
        utilisateurRepository.deleteById(id);
    }
}
