package fr.nogachi.controllers;

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
    public List<User> listUser() {
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
    public Optional<User> findUnUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    /**
     * create un user
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     */
    @PostMapping(path = "/user")
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * mise a jour de l'user
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     */
    @PutMapping(path = "/user/{id}")
    public User update(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * suppprimer un user
     * POSTMAN: OK
     * TEST : (OK/FAIL/WIP)
     */
    @DeleteMapping(path = "/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
