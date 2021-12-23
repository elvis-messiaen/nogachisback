package fr.nogachi.services.impl;

import fr.nogachi.entities.Role;
import fr.nogachi.repositories.RoleRepository;
import fr.nogachi.services.RoleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {


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
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    /**
     *id deleteById un role par son id
     * @param id
     */
    @Transactional
    public void deleteById(Long id) {
        roleRepository.deleteById(id);

    }

    /**
     * affiche une liste de role
     * @return List role
     */
    @Transactional
    public List<Role> findAll() {
        return roleRepository.findAll();
    }


    /**
     *
     * @param id findById un role par son id si il existe
     * @return role
     */
    @Transactional
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }



}
