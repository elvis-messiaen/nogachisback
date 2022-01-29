package fr.nogachi.controllers;

import fr.nogachi.dtos.user.UserDTO;
import fr.nogachi.dtos.user.UserDeleteDTO;
import fr.nogachi.dtos.user.UserRoleDTO;
import fr.nogachi.dtos.user.UserSaveDTO;
import fr.nogachi.services.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Messiaen elvis
 */

@RestController
@CrossOrigin
public class UserController {

    UserServiceImpl userService;
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


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
/*    @PostMapping(path = "/user")
    public UserDTO create(@RequestBody UserSaveDTO userSaveDTO) {
        return this.userService.save(userSaveDTO);
    }*/

    /**
     * create un user with role user
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     */
    @PostMapping(path = "/userrole")
    public UserRoleDTO createWithUser(@RequestBody UserSaveDTO userSaveDTO) {
        return this.userService.save(userSaveDTO);
    }

    /**
     * mise a jour de l'user
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     * @param userUpdateDTO
     */
/*    @PutMapping(path = "/user")
    public UserDTO update(@RequestBody UserSaveDTO userUpdateDTO) {
        return this.userService.save(userUpdateDTO);
    }*/

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
