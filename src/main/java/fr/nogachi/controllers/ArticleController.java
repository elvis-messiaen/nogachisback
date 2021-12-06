package fr.nogachi.controllers;

import fr.nogachi.dtos.article.ArticleDTO;
import fr.nogachi.dtos.article.ArticleDeleteDTO;
import fr.nogachi.dtos.article.ArticleSaveDTO;
import fr.nogachi.dtos.article.ArticleUpdateDTO;
import fr.nogachi.services.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArticleController {

    final ArticleService articleService;

    /**
     * Instancie à la demande le service article
     */
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /*
     * Affiche de la liste des articles
     */
    @GetMapping(path = "/article")
    public List<ArticleDTO> listArticle() {
        return articleService.findAll();
    }

    /*
     * Affiche un article par son id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @GetMapping(path = "/article/{id}")
    public Optional<ArticleDTO> findArticleById(@PathVariable Long id) {
        return articleService.findById(id);
    }

    /*
     * Ajoute un article
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @PostMapping(path = "/article")
    public ArticleDTO createArticle(@RequestBody ArticleSaveDTO articleSaveDTO) {
        return articleService.save(articleSaveDTO);
    }

    // modifier un article dans la table
    @PutMapping(path = "/article")
    public ArticleDTO updateArticle(@RequestBody ArticleUpdateDTO articleUpdateDTO) {
        return articleService.update(articleUpdateDTO);
    }

    /**
     * Supprime un article par id
     *
     */
    @DeleteMapping(path = "/article")
    public void deleteArticle(@RequestBody ArticleDeleteDTO articleDeleteDTO) {
        articleService.delete(articleDeleteDTO);
    }


}

