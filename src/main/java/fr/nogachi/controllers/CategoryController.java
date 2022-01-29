package fr.nogachi.controllers;

import fr.nogachi.dtos.category.CategoryDTO;
import fr.nogachi.dtos.category.CategoryDeleteDTO;
import fr.nogachi.dtos.category.CategorySaveDTO;
import fr.nogachi.dtos.category.CategoryUpdateDTO;
import fr.nogachi.entities.Category;
import fr.nogachi.services.CategoryService;
import fr.nogachi.services.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CategoryController {


    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    CategoryServiceImpl categoryService;

    /**
     * Affiche la liste des categories
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @GetMapping(path = "/category")
    public List<CategoryDTO> listCategory() {
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
    public Optional<CategoryDTO> findCategoryById(@PathVariable Long id) {

        return categoryService.findById(id);
    }

    /**
     * Créer une catégorie
     * POSTMAN : Ok
     * TEST UNITAIRE : WIP
     */
    @PostMapping(path = "/category")
    public CategoryDTO createCategory(@RequestBody CategorySaveDTO categorySaveDTO) {
        return categoryService.save(categorySaveDTO);
    }

    /**
     * Met à jour une catégorie par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @PutMapping("/category")
    public CategoryDTO updateCategory(@RequestBody CategorySaveDTO categoryUpdateDTO) {
        return categoryService.save(categoryUpdateDTO);
    }

    /**
     * Supprime une catégorie par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @DeleteMapping(path = "/category")
    public void deleteCategory(@RequestBody CategoryDeleteDTO categoryDeleteDTO) {
        categoryService.deleteById(categoryDeleteDTO);
    }
}

