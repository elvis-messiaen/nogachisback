package fr.nogachi.services.impl;

import fr.nogachi.entities.User;
import fr.nogachi.repositories.UserRepository;
import fr.nogachi.services.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    /**
     * instance de la méthode userRepository
     */
    private UserRepository userRepository;

    /**
     * constructeur du repository
     * @param userRepository
     */
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /**
     * Transactional => verifie qu'il n'y a pas de problème lors de la transaction
     * si un probleme annule toute modification
     * @param user
     * @return sauvegarde de l'user
     */
    @Transactional
    public User save(User user) {

       return userRepository.save(user);
    }

    /**
     * supprime l'user par son id
     * @param id
     */
    @Transactional
    public void deleteById(Long id) {

       userRepository.deleteById(id);
    }

    /**
     * affiche une liste d'user
     * @return la listes des users
     */
    @Transactional
    public List<User> findAll() {

       return userRepository.findAll();
    }

    /**
     *  récuperer un utlisateur par son id
     * @param id
     * @return
     */
    @Transactional
    public Optional<User> findById(Long id) {

       return userRepository.findById(id);
    }
}
