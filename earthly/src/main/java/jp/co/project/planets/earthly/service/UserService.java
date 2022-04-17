package jp.co.project.planets.earthly.service;

import jp.co.project.planets.pleiades.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * user service
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * new instance user service
     *
     * @param userRepository
     *         user repository
     */
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    

}
