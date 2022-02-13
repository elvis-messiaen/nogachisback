package fr.nogachi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.nogachi.dtos.article.ArticleDTO;
import fr.nogachi.dtos.article.ArticleSaveDTO;
import fr.nogachi.entities.Article;
import fr.nogachi.services.ArticleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ArticleControllerTest.class)
public class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleService service;

    /**
     * on va tester la route qui permet de récuperer un article
     * @throws Exception
     */

    @Test
    public void testFindAllArticles() throws Exception{
        this.mockMvc.perform(get("/article"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$").isEmpty());
    }


    /**
     * On verifie si la route qui permet de retrouver un article
     * renvoie bien un 404 si on ne trouve pas l'article
     * @throws Exception
     */

    @Test
    public void testFindOneArticle()throws Exception{
        ArticleDTO article = this.articleDTO();
        BDDMockito.given(service.findById(1L))
                .willReturn(Optional.of(article));
        MvcResult result = this.mockMvc.perform(get("/article)"))
                .andExpect(status().isOk())
                .andReturn();
        Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        ArticleDTO body = json.fromJson(
                result.getResponse().getContentAsString(),
                ArticleDTO.class
        );
        Assertions.assertEquals(body.getTitle(), this.articleDTO().getTitle());
        Assertions.assertEquals(body.getId(), this.articleDTO().getId());
    }
    @Test
    public void testSaveCinema() throws Exception {
        ArticleDTO article = this.articleDTO();
        Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String body = json.toJson(article);
        this.mockMvc.perform(post("/article")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated());
    }
    @Test
    public void testUpdateArticle() throws Exception {
        ArticleDTO articleDTOS = this.articleDTO();
        ArticleDTO articleUpdated = this.articleUpdated();
        BDDMockito.given(service.findById(1L))
                .willReturn(Optional.of(articleDTOS));
        MvcResult result =  this.mockMvc.perform(get("/article/1"))
                .andExpect(status().isOk())
                .andReturn();
        Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        ArticleDTO body = json.fromJson(result.getResponse().getContentAsString(), ArticleDTO.class);
        BDDMockito.when(service.save(any(ArticleSaveDTO.class)))
                .thenReturn(articleUpdated); // on retourne un articleUpdate
        body.setTitle("name have change");
        String bodyToSave = json.toJson(body);
        MvcResult resultUptaded = this.mockMvc.perform(put("/article")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bodyToSave))
                .andExpect(status().isOk())
                .andReturn();
        ArticleDTO finalBody = json.fromJson(resultUptaded.getResponse().getContentAsString(), ArticleDTO.class);
        Assertions.assertEquals(finalBody.getTitle(), this.articleDTO().getTitle());
    }


    @Test
    public void testDeleteArticle() throws Exception{
        Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String body = json.toJson(this.articleDTO());
        this.mockMvc.perform(delete("/cinemas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }
    private ArticleDTO articleUpdated() {
        return new ArticleDTO(
                1L,"name have change", "essai test controller article findOne", LocalDate.of(2021,01,01),"article1","photo1","recettes"
        );
    }


    private ArticleDTO articleDTO() {
        return new ArticleDTO(
                1L,"l'essai", "essai test controller article findOne", LocalDate.of(2021,01,01),"article1","photo1","recettes"
        );
    }
}
