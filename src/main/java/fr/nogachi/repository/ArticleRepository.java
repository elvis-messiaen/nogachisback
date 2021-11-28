package fr.nogachi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.nogachi.entity.Article;

@Repository
public interface ArticleRepository  extends JpaRepository<Article, Long> {
	 
}
