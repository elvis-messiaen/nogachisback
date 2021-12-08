package fr.nogachi.controllers;

import fr.nogachi.entities.Categorie;
import fr.nogachi.repositories.CategorieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieController {

    private final CategorieRepository categorieRepository;

    /**
     * Instancie à la demande le repository catégorie
     */
    public CategorieController(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

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
