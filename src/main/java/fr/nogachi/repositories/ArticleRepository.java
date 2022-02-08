package fr.nogachi.repositories;

import fr.nogachi.entities.Article;
import fr.nogachi.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
