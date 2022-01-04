package fr.nogachi.controllerTest;

import fr.nogachi.controllers.UserController;
import fr.nogachi.dtos.user.UserDTO;
import fr.nogachi.entities.Role;
import fr.nogachi.services.UserService;
import fr.nogachi.services.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userServiceImpl;



    private UserDTO userDTO() {
        return new UserDTO(
                1L,
                "paul@hotmail.fr",
                "123456",
                new Role()
        );
    }

    private UserDTO userDTOUpdate() {
        return new UserDTO(
                1L,
                "louis@hotmail.fr",
                "654321",
                new Role()
        );
    }

    @Test
    public void testFindAllUser() throws Exception {
        this.mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
