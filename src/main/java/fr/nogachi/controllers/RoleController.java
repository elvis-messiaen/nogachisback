package fr.nogachi.controllers;

import fr.nogachi.dtos.role.RoleDTO;
import fr.nogachi.dtos.role.RoleDeleteDTO;
import fr.nogachi.dtos.role.RoleSaveDTO;
import fr.nogachi.dtos.role.RoleUpdateDTO;
import fr.nogachi.entities.Role;
import fr.nogachi.services.impl.RoleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class RoleController {


    public RoleController(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    /**
     * instancie à la demande le repository role
     */


    RoleServiceImpl roleService;

    /**
     * Affiche la liste des roles
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */

    @GetMapping(path = "/role")
    public List<RoleDTO> listRole() {
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
    public Optional<RoleDTO> findRoleById(@PathVariable Long id) {
        return roleService.findById(id);
    }


    /**
     * Créer un role
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @PostMapping(path = "/role")
    public RoleDTO createRole(@RequestBody RoleSaveDTO roleSaveDTO) {
        return roleService.save(roleSaveDTO);
    }


    /**
     * Met à jours un role par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     * @param roleUpdateDTO
     */

   @PutMapping()
    public RoleDTO update(@RequestBody RoleSaveDTO roleUpdateDTO) {
        return roleService.save(roleUpdateDTO);
    }


    /**
     * Supprime  un role par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @DeleteMapping(path = "/role")
    public void deleteRole(@RequestBody RoleDeleteDTO roleDeleteDTO) {
        roleService.deleteById(roleDeleteDTO);
    }

}
