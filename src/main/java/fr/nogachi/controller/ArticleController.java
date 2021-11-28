package fr.nogachi.controller;

import fr.nogachi.entity.Article;
import fr.nogachi.repository.ArticleRepository;
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
    public Article rechercheArticleParId(@PathVariable Long id) {

        return articleRepository.findById(id).get();
    }

    // Ajouter un article dans la table
    @PostMapping(path = "/article")
    public Article ajouterArticle(@RequestBody Article article) {
        return articleRepository.save(article);
    }

    // modifier un article dans la table
    @PutMapping(path = "/article/{id}")
    public Article ajouterArticle(@PathVariable Long id, @RequestBody Article article) {
        return articleRepository.save(article);
    }

    // Suppression d'un article par son id
    @DeleteMapping(path = "/article/{id}")
    public void supprimerArticleParId(@PathVariable Long id) {
        articleRepository.deleteById(id);
    }


}
