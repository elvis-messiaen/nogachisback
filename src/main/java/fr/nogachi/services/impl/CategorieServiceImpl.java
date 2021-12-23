package fr.nogachi.services.impl;

import fr.nogachi.entities.Category;
import fr.nogachi.repositories.CategoryRepository;
import fr.nogachi.services.CategorieService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {

    private CategoryRepository categorieRepository;

    public CategorieServiceImpl(CategoryRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Transactional
    public Category enregistrer(Category categorie) {
        return categorieRepository.save(categorie);
    }

    @Transactional
    public void supprimer(long id) {
        categorieRepository.deleteById(id);
    }

    @Transactional
    public List<Category> lister() {
        return categorieRepository.findAll();
    }

    @Transactional
    public Optional<Category> trouver(long id) {
        return categorieRepository.findById(id);
    }
}
