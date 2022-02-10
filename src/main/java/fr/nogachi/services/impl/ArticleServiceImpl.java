package fr.nogachi.services.impl;

import fr.nogachi.dtos.article.ArticleDTO;
import fr.nogachi.dtos.article.ArticleDeleteDTO;
import fr.nogachi.dtos.article.ArticleSaveDTO;
import fr.nogachi.dtos.article.ArticleUpdateDTO;
import fr.nogachi.entities.Article;
import fr.nogachi.entities.Category;
import fr.nogachi.repositories.ArticleRepository;
import fr.nogachi.repositories.CategoryRepository;
import fr.nogachi.services.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;
    private CategoryRepository categoryRepository;



    public ArticleServiceImpl(ArticleRepository articleRepository, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }


    @Transactional
    public ArticleSaveDTO save(ArticleSaveDTO articleSaveDTO) {
        Article articles = modelMapper.map(articleSaveDTO, Article.class);
        Category category = new Category();
        Article articleDTO = this.articleRepository.save(articles);
        articleDTO.setNamecategory(category);
        Article articlesauved = (articleDTO);
        articlesauved.setNamecategory(category);
        return modelMapper.map(articleSaveDTO, ArticleSaveDTO.class);
    }

    @Transactional
    public ArticleDTO update(ArticleUpdateDTO articleUpdateDTO) {
        Article article = modelMapper.map(articleUpdateDTO, Article.class);
        Article articleDTO = this.articleRepository.save(article);
        return modelMapper.map(articleDTO, ArticleDTO.class);
    }

    @Transactional
    public void delete(ArticleDeleteDTO articleDeleteDTO) {
        Article article = modelMapper.map(articleDeleteDTO, Article.class);
        articleRepository.delete(article);
    }

    @Transactional
    public List<ArticleDTO> findAll() {
        List<ArticleDTO> articleDTOList = new ArrayList<>();
        this.articleRepository.findAll().forEach(article -> articleDTOList.add(modelMapper.map(article, ArticleDTO.class)));
        return articleDTOList;
    }

    @Transactional
    public Optional<ArticleDTO> findById(long id) throws NoSuchElementException {
        Optional<Article> article = this.articleRepository.findById(id);
        return Optional.of(modelMapper.map(article.orElse(null), ArticleDTO.class));
    }
}
