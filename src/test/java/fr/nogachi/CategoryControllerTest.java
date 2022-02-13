package fr.nogachi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.nogachi.dtos.article.ArticleDTO;
import fr.nogachi.dtos.article.ArticleSaveDTO;
import fr.nogachi.dtos.category.CategoryDTO;
import fr.nogachi.dtos.category.CategorySaveDTO;
import fr.nogachi.services.ArticleService;
import fr.nogachi.services.CategoryService;
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

@WebMvcTest(controllers = CategoryControllerTest.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService service;

    /**
     * on va tester la route qui permet de récuperer une categorie
     * @throws Exception
     */

    @Test
    public void testFindAllCategory() throws Exception{
        this.mockMvc.perform(get("/category"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$").isEmpty());
    }


    /**
     * On verifie si la route qui permet de retrouver une catégorie
     * renvoie bien un 404 si on ne trouve pas la catégorie
     * @throws Exception
     */

    @Test
    public void testFindOneCategory()throws Exception{
        CategoryDTO category = this.categoryDTO();
        BDDMockito.given(service.findById(1L))
                .willReturn(Optional.of(category));
        MvcResult result = this.mockMvc.perform(get("/category)"))
                .andExpect(status().isOk())
                .andReturn();
        Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        CategoryDTO body = json.fromJson(
                result.getResponse().getContentAsString(),
                CategoryDTO.class
        );
        Assertions.assertEquals(body.getNamecategory(), this.categoryDTO().getNamecategory());
        Assertions.assertEquals(body.getId(), this.categoryDTO().getId());
    }

    /**
     * Vérifie que l'on sauvegarde bien une catégorie une fois créée.
     * @throws Exception
     */
    @Test
    public void testSaveCategory() throws Exception {
        CategoryDTO category = this.categoryDTO();
        Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String body = json.toJson(category);
        this.mockMvc.perform(post("/categoy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated());
    }

    /**
     * on vérifie que la catégorie à bien été modifié
     * @throws Exception
     */
    @Test
    public void testUpdateCategory() throws Exception {
        CategoryDTO categoryDTOS = this.categoryDTO();
        CategoryDTO categoryUpdated = this.categoryUpdated();
        BDDMockito.given(service.findById(1L))
                .willReturn(Optional.of(categoryDTOS));
        MvcResult result =  this.mockMvc.perform(get("/category/1"))
                .andExpect(status().isOk())
                .andReturn();
        Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        CategoryDTO body = json.fromJson(result.getResponse().getContentAsString(), CategoryDTO.class);
        BDDMockito.when(service.save(any(CategorySaveDTO.class)))
                .thenReturn(categoryUpdated); // on retourne un articleUpdate
        body.setNamecategory("other category");
        String bodyToSave = json.toJson(body);
        MvcResult resultUptaded = this.mockMvc.perform(put("/category")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bodyToSave))
                .andExpect(status().isOk())
                .andReturn();
        CategoryDTO finalBody = json.fromJson(resultUptaded.getResponse().getContentAsString(), CategoryDTO.class);
        Assertions.assertEquals(finalBody.getNamecategory(), this.categoryDTO().getNamecategory());
    }

    /**
     * Vérifie que catégorie a bien été supprimé.
     * @throws Exception
     */
    @Test
    public void testDeleteCategory() throws Exception{
        Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String body = json.toJson(this.categoryDTO());
        this.mockMvc.perform(delete("/category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }
    private CategoryDTO categoryUpdated() {
        return new CategoryDTO(
                1L,"other category");
    }


    private CategoryDTO categoryDTO() {
        return new CategoryDTO(
                1L,"test");
    }
}
