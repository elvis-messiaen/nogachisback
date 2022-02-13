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

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    /**
     * constructeur du repository
     * constructeur du mapper
     *  @param categoryRepository
     * @param mapper
     * @param modelMapper
     */
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    /**
     * Transactional => verifie qu'il n'y a pas de problème lors de la transaction
     * si un probleme annule toute modification
     *
     * @param categoryDTO
     * * @return sauvegarde de l'user
     */

    public CategoryDTO save(CategorySaveDTO categoryDTO) {
        Category categorySave = modelMapper.map(categoryDTO, Category.class);
        Category categorySaving = this.categoryRepository.save(categorySave);
        return modelMapper.map(categorySaving, CategoryDTO.class);
    }

    public CategoryDTO update(CategoryUpdateDTO categoryDTO) {
        Category categoryUpdate = modelMapper.map(categoryDTO, Category.class);
        Category categorySaving = this.categoryRepository.save(categoryUpdate);
        return modelMapper.map(categorySaving, CategoryDTO.class);
    }

    public void deleteById(CategoryDeleteDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        categoryRepository.delete(category);

    }

    public List<CategoryDTO> findAll() {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        this.categoryRepository.findAll().forEach(category -> {
            categoryDTOList.add(modelMapper.map(category, CategoryDTO.class));
        });
        return categoryDTOList;
    }

    public Optional<CategoryDTO> findById(long id)throws NoSuchElementException {
        Optional<Category> category = this.categoryRepository.findById(id);
        return Optional.of(modelMapper.map(category.get(), CategoryDTO.class));
    }


}
