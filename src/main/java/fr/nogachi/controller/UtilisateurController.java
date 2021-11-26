package fr.nogachi.controller;

import fr.nogachi.entity.Utilisateur;
import fr.nogachi.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UtilisateurController {

    // instancie à la demande un utilisateur repository !! ceci est deprecated
    public UtilisateurController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    // @Autowired => depreceted
    private UtilisateurRepository utilisateurRepository;

    // recherche un utilisateur par id
    @GetMapping(value = "utilisateur{id}")
    public Optional<Utilisateur> afficherUnUtilisateur(@PathVariable Long id) {
        return utilisateurRepository.findById(id);
    }

    // delet un utilisateur
    @DeleteMapping(value = "/utilisateur{id}")
    public void deleteUtilisateur(@PathVariable Long id) {
        utilisateurRepository.deleteUtilisateur(id);
    }

    // retour la list des utilisateurs
    @GetMapping(value = "/utilisateur")
    public List<Utilisateur> utilisateurList() {
        return utilisateurRepository.findAll();
    }

    // sauvegarde un utilisateur
    @PostMapping(value = "/utilisateur")
    public Utilisateur save(@RequestBody Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }




}
