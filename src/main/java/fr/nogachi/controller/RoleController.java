package fr.nogachi.controller;

import fr.nogachi.entity.Role;
import fr.nogachi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping(value = "role{id}")
    public Optional<Role> afficherUnUtilisateur(@PathVariable Long id) {

        return roleRepository.findById(id);
    }

// sauvergarde d'un utilisateur par son id
    /*

     */
    @PutMapping(value = "role{id}")
    public ResponseEntity<Role> updateTodo(@PathVariable Long id, @RequestBody Role role) {
        roleRepository.save(id, role);
        return new ResponseEntity<>(roleRepository.getById((id)), HttpStatus.OK);
    }

    @DeleteMapping({"/role{id}"})
    public void deleteRole(@PathVariable Long id) {
        roleRepository.deleteRole(id);
    }

/*    @RequestMapping(value = "role{id}", method = RequestMethod.DELETE)
    public void deletePlace(@PathVariable(value = "id") Long id) {
        this.roleRepository.deleteRole(id);
    }*/
}