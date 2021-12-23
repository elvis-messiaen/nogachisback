package fr.nogachi.services.impl;

import fr.nogachi.dtos.user.UserDTO;
import fr.nogachi.dtos.user.UserDeleteDTO;
import fr.nogachi.dtos.user.UserSaveDTO;
import fr.nogachi.entities.User;
import fr.nogachi.repositories.UserRepository;
import fr.nogachi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    /**
     * instance de la méthode userRepository
     */
    private UserRepository userRepository;

    private ModelMapper mapper;

    /**
     * constructeur du repository
     * constructeur du mapper
     *
     * @param userRepository
     * @param mapper
     */
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
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
    public UserDTO save(UserSaveDTO userDTO) {
        User userSave = mapper.map(userDTO, User.class);
        User usersaving = this.userRepository.save(userSave);
        UserDTO response = mapper.map(usersaving, UserDTO.class);
        return response;
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
        this.userRepository.findAll().forEach(user -> {
            userDTOList.add(mapper.map(user, UserDTO.class));
        });
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
