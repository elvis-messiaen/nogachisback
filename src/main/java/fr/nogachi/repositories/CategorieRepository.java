package fr.nogachi.repositories;

import fr.nogachi.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    Categorie findById(int id);

    public Categorie save(Categorie categorie);
}
