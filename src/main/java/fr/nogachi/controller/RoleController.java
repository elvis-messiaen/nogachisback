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

    @GetMapping(path = "/role")
    public List<Role> roleList(){
        return  roleRepository.findAll();
    }

    @GetMapping(path = "/role{id}")
    public Role afficherUnUtilisateur(@PathVariable Long id) {

        return roleRepository.findById(id).get();
    }

// sauvergarde d'un utilisateur par son id
    /*

     */
    @PutMapping(path = "/role{id}")
    public ResponseEntity<Role> updateTodo(@PathVariable Long id, @RequestBody Role role) {
        roleRepository.save(role);
        return new ResponseEntity<>(roleRepository.getById((id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/role{id}")
    public void deleteRole(@PathVariable Role role) {
        roleRepository.delete(role);
    }

/*    @RequestMapping(value = "role{id}", method = RequestMethod.DELETE)
    public void deletePlace(@PathVariable(value = "id") Long id) {
        this.roleRepository.deleteRole(id);
    }*/
}