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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * affiche la list des users
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     */
    @GetMapping()
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
    @GetMapping("/{id}")
    public Optional<UserDTO> findUnUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    /**
     * create un user
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     */
    @PostMapping()
    public UserDTO create(@RequestBody UserSaveDTO userSaveDTO) {
//        return this.userService.save(userSaveDTO);
        return null;
    }

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
     *
     * @param userUpdateDTO
     */
    @PutMapping()
    public UserDTO update(@RequestBody UserSaveDTO userUpdateDTO) {
//        return this.userService.save(userUpdateDTO);
        return null;
    }

    /**
     * suppprimer un user
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     */
    @DeleteMapping()
    public void deleteUser(@RequestBody UserDeleteDTO userDeleteDTO) {
        this.userService.delete(userDeleteDTO);
    }
}
