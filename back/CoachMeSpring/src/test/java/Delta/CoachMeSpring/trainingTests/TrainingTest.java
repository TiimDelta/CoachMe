package Delta.CoachMeSpring.trainingTests;
import Delta.CoachMeSpring.training.Training;
import Delta.CoachMeSpring.training.TrainingRepository;
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
public class TrainingTest {
    private Training train;
    private List<Training> trainingList;


    @Before
    public void setUp(){
        train = new Training("Toomas", "tallinn", "korvpall", "tom@gmail.com");
        entityManager.merge(train);
        entityManager.flush();
        trainingList = trainingRepository.findAll();
    }

    @After
    public void tearDown(){
        train = null;
    }

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TrainingRepository trainingRepository;

    @Test
    public void trainerTest(){
        int lenght = trainingList.size();
        String trainer = trainingList.get(lenght -1).trainer;
        assertEquals(trainer, train.trainer);
    }

    @Test
    public void locationTest(){
        int lenght = trainingList.size();
        String location = trainingList.get(lenght -1).location;
        assertEquals(location, train.location);
    }

    @Test
    public void workoutTest(){
        int lenght = trainingList.size();
        String workout = trainingList.get(lenght -1).workout;
        assertEquals(workout, train.workout);
    }

    @Test
    public void mailTest(){
        int lenght = trainingList.size();
        String mail = trainingList.get(lenght -1).mail;
        assertEquals(mail, train.mail);
    }
}