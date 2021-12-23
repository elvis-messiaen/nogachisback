package fr.nogachi.services;

import fr.nogachi.entities.Category;


import java.util.List;
import java.util.Optional;


public interface CategoryService {

     Category save(Category category);

     void deleteById(long id);

     List<Category> findAll();

     Optional<Category> findById(long id);


}
