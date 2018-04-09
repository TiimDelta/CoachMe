package Delta.CoachMeSpring.user;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {this.userRepository = userRepository; }

    User addUser(User user){
        return userRepository.save(user);
    }

    List<User> getAllUsers() { return userRepository.findAll(); }
}
