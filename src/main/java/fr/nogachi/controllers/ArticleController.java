package fr.nogachi.controllers;

import fr.nogachi.entities.Article;
import fr.nogachi.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;


    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    // Affichage de la  liste des articles
    @GetMapping(path = "/article")
    public List<Article> ListArticle() {
        return articleRepository.findAll();
    }

    // Afficher un article par son id
    @GetMapping(path = "/article/{id}")
    public Article findArticleById(@PathVariable Long id) {
        return articleRepository.findById(id).get();
    }

    // Ajouter un article dans la table
    @PostMapping(path = "/article")
    public Article createArticle(@RequestBody Article article) {
        return articleRepository.save(article);
    }

    // modifier un article dans la table
    @PutMapping(path = "/article")
    public Article updateArticle(@RequestBody Article article) {
        return articleRepository.save(article);
    }

    // Suppression d'un article par son id
    @DeleteMapping(path = "/article/{id}")
    public void deleteArticleById(@PathVariable Long id) {
        articleRepository.deleteById(id);
    }


}

