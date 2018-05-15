package Delta.CoachMeSpring.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {this.userRepository = userRepository; }

    User addUser(User user){
        return userRepository.save(user);
    }

    List<User> getAllUsers() { return userRepository.findAll(); }

    public User getOrCreateUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseGet(() -> this.addUserByEmail(email));
       }

     private User addUserByEmail(String email) {
       User user = new User();
        user.setEmail(email);
        return this.addUser(user);
    }

    public Optional<User> getUser(Long user) {
        return userRepository.findById(user);
    }
}
