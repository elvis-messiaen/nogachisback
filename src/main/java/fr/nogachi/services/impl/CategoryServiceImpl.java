package fr.nogachi.services.impl;

import fr.nogachi.entities.Category;
import fr.nogachi.repositories.CategoryRepository;
import fr.nogachi.services.CategoryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    public void deleteById(long id) {
        categoryRepository.deleteById(id);
    }

    @Transactional
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    public Optional<Category> findById(long id) {
        return categoryRepository.findById(id);
    }
}
