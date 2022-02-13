package fr.nogachi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.nogachi.dtos.category.CategoryDTO;
import fr.nogachi.dtos.category.CategorySaveDTO;
import fr.nogachi.dtos.user.UserDTO;
import fr.nogachi.services.CategoryService;
import fr.nogachi.services.UserService;
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

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserControllerTest.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    /**
     * on va tester la route qui permet de récuperer un user
     * @throws Exception
     */

    @Test
    public void testFindAllUser() throws Exception{
        this.mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$").isEmpty());
    }


    /**
     * On verifie si la route qui permet de retrouver un user
     * renvoie bien un 404 si on ne trouve pas le user
     * @throws Exception
     */

    @Test
    public void testFindOneUser()throws Exception{
        UserDTO user = this.userDTO();
        BDDMockito.given(service.findById(1L))
                .willReturn(Optional.of(user));
        MvcResult result = this.mockMvc.perform(get("/user)"))
                .andExpect(status().isOk())
                .andReturn();
        Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        UserDTO body = json.fromJson(
                result.getResponse().getContentAsString(),
                UserDTO.class
        );
        Assertions.assertEquals(body.getPassword(), this.userDTO().getPassword());
        Assertions.assertEquals(body.getId(), this.userDTO().getId());
    }

    /**
     * Vérifie que l'on sauvegarde bien une catégorie une fois créée.
     * @throws Exception
     */
    @Test
    public void testSaveCategory() throws Exception {
        UserDTO category = this.userDTO();
        Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String body = json.toJson(category);
        this.mockMvc.perform(post("/user")
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
        UserDTO userDTOS = this.UserDTO();
        CategoryDTO userUpdated = this.userUpdated();
        BDDMockito.given(service.findById(1L))
                .willReturn(Optional.of(userDTOS));
        MvcResult result =  this.mockMvc.perform(get("/category/1"))
                .andExpect(status().isOk())
                .andReturn();
        Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        UserDTO body = json.fromJson(result.getResponse().getContentAsString(), UserDTO.class);
        BDDMockito.when(service.save(any(CategorySaveDTO.class)))
                .thenReturn(UserUpdated); // on retourne un articleUpdate
        body.setPassword("1234");
        String bodyToSave = json.toJson(body);
        MvcResult resultUptaded = this.mockMvc.perform(put("/category")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bodyToSave))
                .andExpect(status().isOk())
                .andReturn();
        CategoryDTO finalBody = json.fromJson(resultUptaded.getResponse().getContentAsString(), CategoryDTO.class);
        Assertions.assertEquals(finalBody.getNamecategory(), this.userDTO().getPassword());
    }

    /**
     * Vérifie qu'une photo a bien été supprimé.
     * @throws Exception
     */
    @Test
    public void testDeleteUser() throws Exception{
        Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String body = json.toJson(this.userDTO());
        this.mockMvc.perform(delete("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }
    private UserDTO UserUpdated() {
        return new UserDTO(
                1L,"wil@gmail.com","1234");
    }


    private UserDTO UserDTO() {
        return new UserDTO(
                1L,"1234",);
    }
}
