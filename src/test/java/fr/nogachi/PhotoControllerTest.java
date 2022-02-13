package fr.nogachi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.nogachi.dtos.category.CategoryDTO;
import fr.nogachi.dtos.category.CategorySaveDTO;
import fr.nogachi.dtos.photo.PhotoDTO;
import fr.nogachi.dtos.photo.PhotoSaveDTO;
import fr.nogachi.services.CategoryService;
import fr.nogachi.services.impl.PhotoService;
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

@WebMvcTest(controllers = PhotoControllerTest.class)
public class PhotoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PhotoService service;

    /**
     * on va tester la route qui permet de récuperer une photo
     * @throws Exception
     */

    @Test
    public void testFindAllCategory() throws Exception{
        this.mockMvc.perform(get("/photo"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$").isEmpty());
    }


    /**
     * On verifie si la route qui permet de retrouver une photo
     * renvoie bien un 404 si on ne trouve pas la photo
     * @throws Exception
     */

    @Test
    public void testFindOnePhoto()throws Exception{
        PhotoDTO photo = this.photoDTO();
        BDDMockito.given(service.findById(1L))
                .willReturn(Optional.of(photo));
        MvcResult result = this.mockMvc.perform(get("/photo)"))
                .andExpect(status().isOk())
                .andReturn();
        Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        PhotoDTO body = json.fromJson(
                result.getResponse().getContentAsString(),
                PhotoDTO.class
        );
        Assertions.assertEquals(body.getNamephoto(), this.photoDTO().getNamephoto());
        Assertions.assertEquals(body.getId(), this.photoDTO().getId());
    }

    /**
     * Vérifie que l'on sauvegarde bien une photo une fois créée.
     * @throws Exception
     */
    @Test
    public void testSavePhoto() throws Exception {
        PhotoDTO photo = this.photoDTO();
        Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String body = json.toJson(photo);
        this.mockMvc.perform(post("/photo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated());
    }

    /**
     * on vérifie que la photo à bien été modifié
     * @throws Exception
     */
    @Test
    public void testUpdatePhoto() throws Exception {
        PhotoDTO photoDTOS = this.photoDTO();
        PhotoDTO photoUpdated = this.photoUpdated();
        BDDMockito.given(service.findById(1L))
                .willReturn(Optional.of(photoDTOS));
        MvcResult result =  this.mockMvc.perform(get("/photo/1"))
                .andExpect(status().isOk())
                .andReturn();
        Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        PhotoDTO body = json.fromJson(result.getResponse().getContentAsString(), PhotoDTO.class);
        BDDMockito.when(service.save(any(PhotoSaveDTO.class)))
                .thenReturn(photoUpdated); // on retourne un articleUpdate
        body.setNamephoto("new name");
        String bodyToSave = json.toJson(body);
        MvcResult resultUptaded = this.mockMvc.perform(put("/photo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bodyToSave))
                .andExpect(status().isOk())
                .andReturn();
        PhotoDTO finalBody = json.fromJson(resultUptaded.getResponse().getContentAsString(), PhotoDTO.class);
        Assertions.assertEquals(finalBody.getNamephoto(), this.photoDTO().getNamephoto());
    }

    /**
     * Vérifie que la photo a bien été supprimé.
     * @throws Exception
     */
    @Test
    public void testDeletePhoto() throws Exception{
        Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String body = json.toJson(this.photoDTO());
        this.mockMvc.perform(delete("/photo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }
    private PhotoDTO photoUpdated() {
        return new PhotoDTO(
                1L,"new name");
    }


    private PhotoDTO photoDTO() {
        return new PhotoDTO(
                1L,"test");
    }
}
