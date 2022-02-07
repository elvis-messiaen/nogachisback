package fr.nogachi.services;

import fr.nogachi.dtos.article.ArticleDTO;
import fr.nogachi.dtos.article.ArticleDeleteDTO;
import fr.nogachi.dtos.article.ArticleSaveDTO;
import fr.nogachi.dtos.article.ArticleUpdateDTO;
import fr.nogachi.entities.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    Article save(Article article);

    ArticleDTO update(ArticleUpdateDTO articleUpdateDTO);

    void delete(ArticleDeleteDTO articleDeleteDTO);

    List<ArticleDTO> findAll();

    Optional<ArticleDTO> findById(long id);

}
