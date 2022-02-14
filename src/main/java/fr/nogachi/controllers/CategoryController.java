package fr.nogachi.controllers;

import fr.nogachi.dtos.category.CategoryDTO;
import fr.nogachi.dtos.category.CategoryDeleteDTO;
import fr.nogachi.dtos.category.CategorySaveDTO;
import fr.nogachi.services.impl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class CategoryController {

    final CategoryServiceImpl categoryServiceImpl;

    public CategoryController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    /**
     * Affiche la liste des categories
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @GetMapping(path = "/category")
    public List<CategoryDTO> listCategory() {
        return categoryServiceImpl.findAll();
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

        return categoryServiceImpl.findById(id);
    }

    /**
     * Créer une catégorie
     * POSTMAN : Ok
     * TEST UNITAIRE : WIP
     */
    @PostMapping(path = "/category")
    public CategoryDTO createCategory(@RequestBody CategorySaveDTO categorySaveDTO) {
        return categoryServiceImpl.save(categorySaveDTO);
    }

    /**
     * Met à jour une catégorie par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @PutMapping("/category")
    public CategoryDTO updateCategory(@RequestBody CategorySaveDTO categoryUpdateDTO) {
        return categoryServiceImpl.save(categoryUpdateDTO);
    }

    /**
     * Supprime une catégorie par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @DeleteMapping(path = "/category")
    public void deleteCategory(@RequestBody CategoryDeleteDTO categoryDeleteDTO) {
        categoryServiceImpl.deleteById(categoryDeleteDTO);
    }
}

