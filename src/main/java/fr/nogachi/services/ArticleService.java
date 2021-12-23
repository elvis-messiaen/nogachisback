package fr.nogachi.services;

import fr.nogachi.dtos.article.ArticleDTO;
import fr.nogachi.dtos.article.ArticleDeleteDTO;
import fr.nogachi.dtos.article.ArticleSaveDTO;
import fr.nogachi.dtos.article.ArticleUpdateDTO;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    ArticleDTO save(ArticleSaveDTO articleSaveDTO);

    ArticleDTO update(ArticleUpdateDTO articleUpdateDTO);

    void delete(ArticleDeleteDTO articleDeleteDTO);

    List<ArticleDTO> findAll();

    Optional<ArticleDTO> findById(long id);

}
