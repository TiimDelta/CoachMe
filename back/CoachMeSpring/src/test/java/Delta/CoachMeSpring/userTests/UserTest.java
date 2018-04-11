package Delta.CoachMeSpring.userTests;

import Delta.CoachMeSpring.training.Training;
import Delta.CoachMeSpring.training.TrainingRepository;
import Delta.CoachMeSpring.user.User;
import Delta.CoachMeSpring.user.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class UserTest {
    private User user;
    private List<User> userList;


    @Before
    public void setUp(){
        user = new User("kalamees", "peeter", "kuusk", "salajaneparool","pets@mail.com", true);
        entityManager.merge(user);
        entityManager.flush();
        userList = userRepository.findAll();
    }

    @After
    public void tearDown(){
        user = null;
    }

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void usernameTest(){
        int lenght = userList.size();
        String username = userList.get(lenght -1).username;
        assertEquals(username, user.username);
    }

    @Test
    public void firstNameTest(){
        int lenght = userList.size();
        String firstName = userList.get(lenght -1).firstName;
        assertEquals(firstName, user.firstName);
    }

    @Test
    public void lastNameTest(){
        int lenght = userList.size();
        String lastName = userList.get(lenght -1).lastName;
        assertEquals(lastName, user.lastName);
    }

    @Test
    public void passwordTest(){
        int lenght = userList.size();
        String password = userList.get(lenght -1).password;
        assertEquals(password, user.password);
    }
    public void mailTest(){
        int lenght = userList.size();
        String mail = userList.get(lenght -1).mail;
        assertEquals(mail, user.mail);
    }
    public void userTypeTest(){
        int lenght = userList.size();
        Boolean userType = userList.get(lenght -1).userType;
        assertEquals(userType, user.userType);
    }
}