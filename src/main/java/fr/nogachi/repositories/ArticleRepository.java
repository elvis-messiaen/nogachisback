package fr.nogachi.repositories;

import fr.nogachi.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.nogachi.entities.Article;

@Repository
public interface ArticleRepository  extends JpaRepository<Article, Long> {

    Article findbyId(int id);

    public Article save(Categorie categorie);
	 
}
