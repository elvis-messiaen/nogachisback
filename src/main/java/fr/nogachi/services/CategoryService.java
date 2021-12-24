package fr.nogachi.services;

import fr.nogachi.dtos.category.CategoryDTO;
import fr.nogachi.dtos.category.CategoryDeleteDTO;
import fr.nogachi.dtos.category.CategorySaveDTO;
import fr.nogachi.dtos.category.CategoryUpdateDTO;
import fr.nogachi.entities.Category;


import java.util.List;
import java.util.Optional;


public interface CategoryService {

     CategoryDTO save(CategorySaveDTO categorySaveDTO);

     CategoryDTO update(CategoryUpdateDTO categoryUpdateDTO);

     void deleteById(CategoryDeleteDTO categoryDeleteDTO);

     List<CategoryDTO> findAll();

     Optional<CategoryDTO> findById(long id);


}
