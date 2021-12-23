package fr.nogachi.services;

import fr.nogachi.entities.Category;


import java.util.List;
import java.util.Optional;


public interface CategorieService {

     Category enregistrer(Category categorie);

     void supprimer(long id);

     List<Category> lister();

     Optional<Category> trouver(long id);


}
