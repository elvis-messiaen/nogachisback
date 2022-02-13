package fr.nogachi.services.impl;

import fr.nogachi.dtos.role.RoleDTO;
import fr.nogachi.dtos.role.RoleDeleteDTO;
import fr.nogachi.dtos.role.RoleSaveDTO;
import fr.nogachi.dtos.role.RoleUpdateDTO;
import fr.nogachi.entities.Role;
import fr.nogachi.repositories.RoleRepository;
import fr.nogachi.services.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {


    private RoleRepository roleRepository;

    private ModelMapper mapper;

    /**
     * constructeur du RoleService
     *
     * @param roleRepository
     */
    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper mapper) {
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }

    /**
     * @param roleDTO enregistre un role
     * @return roleDTO sauvegarder
     */
    @Transactional
    public RoleDTO save(RoleSaveDTO roleDTO) {
        Role roleSave = mapper.map(roleDTO, Role.class);
        Role roleSaving = this.roleRepository.save(roleSave);
        return mapper.map(roleSaving, RoleDTO.class);
    }

    @Transactional
    public RoleDTO update(RoleUpdateDTO roleDTO) {
        Role roleUdpate = mapper.map(roleDTO, Role.class);
        Role roleSaving = this.roleRepository.save(roleUdpate);
        return mapper.map(roleSaving, RoleDTO.class);
    }

    @Transactional
    public void deleteById(RoleDeleteDTO roleDTO) {
        Role role = mapper.map(roleDTO, Role.class);
        roleRepository.delete(role);
    }



    /**
     * id deleteById un role par son id
     *
     * @param roleDTO
     */


    /**
     * affiche une liste de role
     *
     * @return List role
     */
    @Transactional
    public List<RoleDTO> findAll() {
        List<RoleDTO> roleDTOList = new ArrayList<>();
        this.roleRepository.findAll().forEach(role -> {
            roleDTOList.add(mapper.map(role, RoleDTO.class));
        });
        return roleDTOList;
    }


    /**
     * @param id findById un role par son id si il existe
     * @return role
     */
    @Transactional
    public Optional<RoleDTO> findById(Long id) throws NoSuchElementException {
        Optional<Role> role = this.roleRepository.findById(id);
        return Optional.of(mapper.map(role.get(), RoleDTO.class));
    }


}
