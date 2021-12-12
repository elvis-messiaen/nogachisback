package fr.nogachi.controllers;

import fr.nogachi.entities.Categorie;
import fr.nogachi.services.impl.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class CategorieController {

   @Autowired
    CategorieService categorieService;


   
    /**
     * Affiche la liste des categories
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @GetMapping(path = "/categorie")
    public List<Categorie> listeCategorie() {
        return categorieRepository.findAll();
    }

    /**
     * Recherche une catégorie par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @GetMapping(path = "/categorie/{id}")
    public Categorie afficherCategorie(@PathVariable Long id) {

        return categorieRepository.findById(id).get();
    }

    /**
     * Créer une catégorie
     * POSTMAN : Ok
     * TEST UNITAIRE : WIP
     */
    @PostMapping(path = "/categorie")
    public Categorie ajouterCategorie(@RequestBody Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    /**
     * Met à jour une catégorie par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @PutMapping(path = "/categorie/{id}")
    public Categorie miseAJourCategorie(@PathVariable Long id, @RequestBody Categorie categorie) {
        categorie.setId(id);
        return categorieRepository.save(categorie);
    }

    /**
     * Supprime une catégorie par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @DeleteMapping(path = "/categorie/{id}")
    public void supprimerCategorie(@PathVariable Long id) {
        categorieRepository.deleteById(id);
    }
}

