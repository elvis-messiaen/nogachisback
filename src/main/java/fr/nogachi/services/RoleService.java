package fr.nogachi.services;

import fr.nogachi.dtos.role.RoleDTO;
import fr.nogachi.dtos.role.RoleDeleteDTO;
import fr.nogachi.dtos.role.RoleSaveDTO;
import fr.nogachi.dtos.role.RoleUpdateDTO;
import fr.nogachi.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    RoleDTO save(RoleSaveDTO roleSaveDTO);

    RoleDTO update(RoleUpdateDTO roleUpdateDTO);
    void deleteById(RoleDeleteDTO roleDeleteDTO);

    List<RoleDTO> findAll();

    Optional<RoleDTO> findById(Long id);
}
