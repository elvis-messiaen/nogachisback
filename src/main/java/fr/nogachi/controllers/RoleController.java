package fr.nogachi.controllers;

import fr.nogachi.entities.Role;
import fr.nogachi.services.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoleController {

    private RoleService roleService;

    /**
     * instancie à la demande le repository role
     */
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * Affiche la liste des roles
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */

    @GetMapping(path = "/role")
    public List<Role> listRole() {
        return roleService.findAll();
    }

    /**
     * Recherche un role par ID
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     *
     * @return
     */

    @GetMapping(path = "/role/{id}")
    public Optional<Role> findRoleById(@PathVariable Long id) {
        return roleService.findById(id);
    }


    /**
     * Créer un role
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @PostMapping(path = "/role")
    public Role createRole(@RequestBody Role role) {
        return roleService.save(role);
    }


    /**
     * Met à jours un role par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */

   /* @PutMapping()
    public Role update(@RequestBody Role role) {
        return roleService.save(role);
    }
*/

    /**
     * Supprime  un role par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @DeleteMapping(path = "/role/{id}")
    public void deleteById(@PathVariable Long id) {
        roleService.deleteById(id);
    }

}
