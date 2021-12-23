package fr.nogachi.controllers;

import fr.nogachi.dtos.user.UserDTO;
import fr.nogachi.dtos.user.UserDeleteDTO;
import fr.nogachi.dtos.user.UserSaveDTO;
import fr.nogachi.entities.User;
import fr.nogachi.services.impl.UserServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Messiaen elvis
 */

@RestController
public class UserController {


    public UserController(UserServiceImp userService) {
        this.userService = userService;
    }

    UserServiceImp userService;

    /**
     *   instancie à la demande un user repository
     *   POSTMAN: OK
     *   TEST : (OK/FAIL/WIP)
     */

    /**
     * affiche la list des users
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     */
    @GetMapping(path = "/user")
    public List<UserDTO> listUser() {
        return userService.findAll();

    }

    /**
     * recherche un user par id
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     *
     * @return
     */
    @GetMapping(path = "/user/{id}")
    public Optional<UserDTO> findUnUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    /**
     * create un user
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     */
    @PostMapping(path = "/user")
    public UserDTO create(@RequestBody UserSaveDTO userSaveDTO) {
        UserDTO response = this.userService.save(userSaveDTO);
        return response;
    }

    /**
     * mise a jour de l'user
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     */
    @PutMapping(path = "/user/{id}")
    public UserDTO update(@RequestBody UserSaveDTO userSaveDTO) {
        UserDTO response = this.userService.save(userSaveDTO);
        return response;
    }

    /**
     * suppprimer un user
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     */
    @DeleteMapping(path = "/user")
    public void deleteUser(@RequestBody UserDeleteDTO userDeleteDTO) {
        this.userService.delete(userDeleteDTO);
    }
}
