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

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    // affiche la liste des roles check
    @GetMapping(path = "/role")
    public List<Role> roleListe(){
        return  roleRepository.findAll();
    }

    // affiche un utilisateur par son id check
    @GetMapping(path = "/role/{id}")
    public Role getRole(@PathVariable Long id) {
        return roleRepository.findById(id).get();
    }

// sauvergarde d'un utilisateur par son id
    @PostMapping(path = "/role")
    public Role save(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    // mise a jour role check
    @PutMapping(path = "/role/{id}")
    public Role update(@PathVariable Long id, @RequestBody Role role) {
        role.setId(id);
        return roleRepository.save(role);
    }

    // supprime un utilisateur check
    @DeleteMapping(path = "/role/{id}")
    public void delete(@PathVariable Long id) { roleRepository.deleteById(id);
    }


}