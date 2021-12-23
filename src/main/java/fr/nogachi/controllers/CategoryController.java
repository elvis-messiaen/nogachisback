package fr.nogachi.controllers;

import fr.nogachi.entities.Category;
import fr.nogachi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * Affiche la liste des categories
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @GetMapping(path = "/category")
    public List<Category> listCategory() {
        return categoryService.findAll();
    }

    /**
     * Recherche une catégorie par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     *
     * @return
     */
    @GetMapping(path = "/category/{id}")
    public Optional<Category> findCategoryById(@PathVariable Long id) {

        return categoryService.findById(id);
    }

    /**
     * Créer une catégorie
     * POSTMAN : Ok
     * TEST UNITAIRE : WIP
     */
    @PostMapping(path = "/category")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    /**
     * Met à jour une catégorie par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @PutMapping()
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    /**
     * Supprime une catégorie par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @DeleteMapping(path = "/category/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}

