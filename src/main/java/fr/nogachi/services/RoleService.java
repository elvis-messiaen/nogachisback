package fr.nogachi.services;

import fr.nogachi.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Role save(Role role);

    void deleteById(Long id);

    List<Role> findAll();

    Optional<Role> findById(Long id);
}
