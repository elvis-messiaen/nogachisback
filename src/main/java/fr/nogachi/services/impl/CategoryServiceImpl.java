package fr.nogachi.services.impl;

import fr.nogachi.dtos.category.CategoryDTO;
import fr.nogachi.dtos.category.CategoryDeleteDTO;
import fr.nogachi.dtos.category.CategorySaveDTO;
import fr.nogachi.dtos.category.CategoryUpdateDTO;
import fr.nogachi.entities.Category;
import fr.nogachi.repositories.CategoryRepository;
import fr.nogachi.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapper mapper;

    /**
     * constructeur du repository
     * constructeur du mapper
     *
     * @param categoryRepository
     * @param mapper
     */
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }


    /**
     * Transactional => verifie qu'il n'y a pas de problème lors de la transaction
     * si un probleme annule toute modification
     *
     * @param categoryDTO
     * * @return sauvegarde de l'user
     */

    @Transactional
    public CategoryDTO save(CategorySaveDTO categoryDTO) {
        Category categorySave = mapper.map(categoryDTO, Category.class);
        Category categorySaving = this.categoryRepository.save(categorySave);
        return mapper.map(categorySaving, CategoryDTO.class);
    }

    @Transactional
    public CategoryDTO update(CategoryUpdateDTO categoryDTO) {
        Category categoryUpdate = mapper.map(categoryDTO, Category.class);
        Category categorySaving = this.categoryRepository.save(categoryUpdate);
        return mapper.map(categorySaving, CategoryDTO.class);
    }

    @Transactional
    public void deleteById(CategoryDeleteDTO categoryDTO) {
        Category category = mapper.map(categoryDTO, Category.class);
        categoryRepository.delete(category);

    }

    @Transactional
    public List<CategoryDTO> findAll() {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        this.categoryRepository.findAll().forEach(category -> {
            categoryDTOList.add(mapper.map(category, CategoryDTO.class));
        });
        return categoryDTOList;
    }

    @Transactional
    public Optional<CategoryDTO> findById(long id)throws NoSuchElementException {
        Optional<Category> category = this.categoryRepository.findById(id);
        return Optional.of(mapper.map(category.get(), CategoryDTO.class));
    }


}
