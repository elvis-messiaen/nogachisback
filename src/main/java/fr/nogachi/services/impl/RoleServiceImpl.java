package fr.nogachi.services.impl;

import fr.nogachi.entities.Role;
import fr.nogachi.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{


   private RoleRepository roleRepository;

    /**
     * constructeur du RoleService
     * @param roleRepository
     */
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     *
     * @param role enregistre un role
     * @return role sauvegarder
     */
    @Transactional
    public Role enregistrer(Role role) {
        return roleRepository.save(role);
    }

    /**
     *id supprimer un role par son id
     * @param id
     */
    @Transactional
    public void supprimer(Long id) {
        roleRepository.deleteById(id);

    }

    /**
     * affiche une liste de role
     * @return List role
     */
    @Transactional
    public List<Role> lister() {
        return roleRepository.findAll();
    }


    /**
     *
     * @param id trouver un role par son id si il existe
     * @return role
     */
    @Transactional
    public Optional<Role> trouver(Long id) {
        return roleRepository.findById(id);
    }



}
