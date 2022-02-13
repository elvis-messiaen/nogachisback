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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;
    private CategoryRepository categoryRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }



    public ArticleSaveDTO save(ArticleSaveDTO articleSaveDTO) {
        Article articles = modelMapper.map(articleSaveDTO, Article.class);
        if (articleSaveDTO.getNamecategory() != null) {
            Category category = categoryRepository.findCategoryByNamecategory(articleSaveDTO.getNamecategory())
                    .orElseGet(() -> this.categoryRepository.save(Category.builder()
                            .namecategory(articleSaveDTO.getNamecategory())
                            .build()));
            articles.setNamecategory(category);
        }

        this.articleRepository.save(articles);

        return modelMapper.map(articleSaveDTO, ArticleSaveDTO.class);
    }


    public ArticleDTO update(ArticleUpdateDTO articleUpdateDTO) {
        Article article = modelMapper.map(articleUpdateDTO, Article.class);
        Article articleDTO = this.articleRepository.save(article);
        return modelMapper.map(articleDTO, ArticleDTO.class);
    }

    public void delete(ArticleDeleteDTO articleDeleteDTO) {
        Article article = modelMapper.map(articleDeleteDTO, Article.class);
        articleRepository.delete(article);
    }

    public List<ArticleDTO> findAll() {
        List<ArticleDTO> articleDTOList = new ArrayList<>();
        this.articleRepository.findAll().forEach(article -> articleDTOList.add(modelMapper.map(article, ArticleDTO.class)));
        return articleDTOList;
    }

    public Optional<ArticleDTO> findById(long id) throws NoSuchElementException {
        Optional<Article> article = this.articleRepository.findById(id);
        return Optional.of(modelMapper.map(article.orElse(null), ArticleDTO.class));
    }
}
