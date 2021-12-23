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
     *
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
    public List<Role> roleListe(){
        return  roleService.lister();
    }
    /**
     * Recherche un role par ID
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     * @return
     */

    @GetMapping(path = "/role/{id}")
    public Optional<Role> getRole(@PathVariable Long id) {
        return roleService.trouver(id);
    }


    /**
     * Créer un role
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @PostMapping(path = "/role")
    public Role save(@RequestBody Role role) {
        return roleService.enregistrer(role);
    }


    /**
     * Met à jours un role par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @PutMapping()
    public Role update(@RequestBody Role role) {
        return roleService.enregistrer(role);
    }


    /**
     * Supprime  un role par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @DeleteMapping(path = "/role/{id}")
    public void delete(@PathVariable Long id) { roleService.supprimer(id);
    }

}
