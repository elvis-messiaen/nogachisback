package fr.nogachi.controllers;

import fr.nogachi.dtos.article.ArticleDTO;
import fr.nogachi.dtos.article.ArticleDeleteDTO;
import fr.nogachi.dtos.article.ArticleSaveDTO;
import fr.nogachi.dtos.article.ArticleUpdateDTO;
import fr.nogachi.services.impl.ArticleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    final ArticleServiceImpl articleServiceImpl;

    /**
     * Instancie à la demande le service article
     */
    public ArticleController(ArticleServiceImpl articleServiceImpl) {
        this.articleServiceImpl = articleServiceImpl;
    }

    /*
     * Affiche de la liste des articles
     *
     */
    @GetMapping()
    public List<ArticleDTO> listArticle() {
        return articleServiceImpl.findAll();
    }

    /*
     * Affiche un article par son id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @GetMapping("/{id}")
    public Optional<ArticleDTO> findArticleById(@PathVariable Long id) {
        return articleServiceImpl.findById(id);
    }

    /*
     * Ajoute un article
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @PostMapping()
    public ArticleSaveDTO createArticle(@RequestBody ArticleSaveDTO articleSaveDTO) {
        return articleServiceImpl.save(articleSaveDTO);
    }

    // modifier un article dans la table
    @PutMapping()
    public ArticleDTO updateArticle(@RequestBody ArticleUpdateDTO articleUpdateDTO) {
        return articleServiceImpl.update(articleUpdateDTO);
    }

    /**
     * Supprime un article par id
     */
    @DeleteMapping()
    public void deleteArticle(@RequestBody ArticleDeleteDTO articleDeleteDTO) {
        articleServiceImpl.delete(articleDeleteDTO);
    }

}

