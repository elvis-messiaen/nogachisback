package fr.nogachi.services.impl;

import fr.nogachi.dtos.user.*;
import fr.nogachi.entities.ERole;
import fr.nogachi.entities.Role;
import fr.nogachi.entities.User;
import fr.nogachi.repositories.RoleRepository;
import fr.nogachi.repositories.UserRepository;
import fr.nogachi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    /**
     * instance de la méthode userRepository
     */
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private ModelMapper mapper;

    /**
     * constructeur du repository
     * constructeur du mapper
     *
     * @param userRepository
     * @param mapper
     */
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }


    /**
     * Transactional => verifie qu'il n'y a pas de problème lors de la transaction
     * si un probleme annule toute modification
     *
     * @param userDTO
     * @return sauvegarde de l'user
     */
    @Transactional
    public UserRoleDTO save(UserSaveDTO userDTO) {
        User userSave = mapper.map(userDTO, User.class);
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        userSave.setRoles(roles);
        User usersaving = this.userRepository.save(userSave);
        return mapper.map(usersaving, UserRoleDTO.class);
    }


    @Transactional
    public UserDTO update(UserUpdateDTO userUpdateDTO) {
        User userUpdate = mapper.map(userUpdateDTO, User.class);
        User usersaving = this.userRepository.save(userUpdate);
        return mapper.map(usersaving, UserDTO.class);
    }

    /**
     * supprime l'user par son id
     *
     * @param userDTO
     */
    @Transactional
    public void delete(UserDeleteDTO userDTO) {
        User user = mapper.map(userDTO, User.class);
        userRepository.delete(user);
    }

    /**
     * affiche une liste d'user
     *
     * @return la listes des users
     */
    @Transactional
    public List<UserDTO> findAll() {
        List<UserDTO> userDTOList = new ArrayList<>();
        this.userRepository.findAll().forEach(user ->
                userDTOList.add(mapper.map(user, UserDTO.class))
        );
        return userDTOList;
    }

    /**
     * récuperer un utlisateur par son id
     *
     * @param id
     * @return
     */
    @Transactional
    public Optional<UserDTO> findById(Long id) throws NoSuchElementException {
        Optional<User> user = this.userRepository.findById(id);
        return Optional.of(mapper.map(user.get(), UserDTO.class));
    }

}
