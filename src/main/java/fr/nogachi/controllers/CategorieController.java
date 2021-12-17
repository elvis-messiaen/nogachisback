package fr.nogachi.controllers;

import fr.nogachi.entities.Categorie;
import fr.nogachi.services.impl.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
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
        return categorieService.lister();
    }

    /**
     * Recherche une catégorie par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     * @return
     */
    @GetMapping(path = "/categorie/{id}")
    public Optional<Categorie> afficherCategorie(@PathVariable Long id) {

        return categorieService.trouver(id);
    }

    /**
     * Créer une catégorie
     * POSTMAN : Ok
     * TEST UNITAIRE : WIP
     */
    @PostMapping(path = "/categorie")
    public Categorie ajouterCategorie(@RequestBody Categorie categorie) {
        return categorieService.enregistrer(categorie);
    }

    /**
     * Met à jour une catégorie par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @PutMapping()
    public Categorie miseAJourCategorie(@RequestBody Categorie categorie) {
        return categorieService.enregistrer(categorie);
    }

    /**
     * Supprime une catégorie par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @DeleteMapping(path = "/categorie/{id}")
    public void supprimerCategorie(@PathVariable Long id) {
        categorieService.supprimer(id);
    }
}

