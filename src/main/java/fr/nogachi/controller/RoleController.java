package fr.nogachi.controller;

import fr.nogachi.entity.Role;
import fr.nogachi.repository.RoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    private RoleRepository roleRepository;

    /**
     *
     * instancie à la demande le repository role
     */
    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Affiche la liste des roles
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
 
    @GetMapping(path = "/role")
    public List<Role> roleListe(){
        return  roleRepository.findAll();
    }
    /**
     * Recherche un role par ID
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */

    @GetMapping(path = "/role/{id}")
    public Role getRole(@PathVariable Long id) {
        return roleRepository.findById(id).get();
    }


    /**
     * Créer un role
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @PostMapping(path = "/role")
    public Role save(@RequestBody Role role) {
        return roleRepository.save(role);
    }


    /**
     * Met à jours un role par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @PutMapping(path = "/role/{id}")
    public Role update(@PathVariable Long id, @RequestBody Role role) {
        role.setId(id);
        return roleRepository.save(role);
    }


    /**
     * Supprime  un role par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @DeleteMapping(path = "/role/{id}")
    public void delete(@PathVariable Long id) { roleRepository.deleteById(id);
    }


}