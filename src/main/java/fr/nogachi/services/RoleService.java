package fr.nogachi.services;

import fr.nogachi.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Role enregistrer(Role role);

    void supprimer(Long id);

    List<Role> lister();

    Optional<Role> trouver(Long id);
}
