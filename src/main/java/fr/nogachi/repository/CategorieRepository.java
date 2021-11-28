package fr.nogachi.repository;

import fr.nogachi.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    Categorie findById(int id);

    public Categorie save(Categorie categorie);
}
