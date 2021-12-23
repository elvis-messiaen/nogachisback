package fr.nogachi.services;

import fr.nogachi.entities.Categorie;


import java.util.List;
import java.util.Optional;


public interface CategorieService {

     Categorie enregistrer(Categorie categorie);

     void supprimer(long id);

     List<Categorie> lister();

     Optional<Categorie> trouver(long id);


}
