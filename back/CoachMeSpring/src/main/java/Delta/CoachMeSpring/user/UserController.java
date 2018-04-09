package Delta.CoachMeSpring.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST,
            consumes = "application/json")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}